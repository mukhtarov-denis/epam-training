package by.epam.training.course.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.course.entity.DBRole;
import by.epam.training.course.entity.Role;
import by.epam.training.course.entity.User;
import by.epam.training.course.entity.user.UserContext;

/*
 * фильтр для анализа ролей
 * если urlApplication присутствует в отслеживаемых url'ах
 * но не авторизован, или не имеет необходимой роли,
 * происходит перенаправление на страницу аутентификации
 */
public class SecurityFilter implements Filter {
    private static final Logger logger = LogManager.getLogger();
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String url = httpRequest.getRequestURI();
        String context = httpRequest.getContextPath();
        String urlApplication = url.substring(context.length());
        logger.trace(String.format("URL application: \"%s\"", urlApplication));
        Set<DBRole> roles = Permission.getPermissions().get(urlApplication);
        if (roles != null) {
            logger.trace("Url requires permissions ...");
            UserContext userContext = (UserContext) httpRequest.getSession().getAttribute("session_user_context");
            if (userContext != null) {
                logger.trace("User found: " + userContext.getPerson().getUser().getUsername());
                DBRole foundedRole = roleIsFound(userContext.getPerson().getUser(), roles);
                if (foundedRole != null) {
                    request.setAttribute("role", foundedRole);
                } else {
                    logger.trace("user founded, but role not found ...");
                    httpRequest.getSession(false).setAttribute("lastUrl", urlApplication + "?" + httpRequest.getQueryString());
                    httpResponse.sendRedirect(context + "/app/login?message=application.messages.insufficient_privileges");
                    return;
                }
            } else {
                logger.trace("Url requires permissions, but user not found ...");
                httpRequest.getSession().setAttribute("lastUrl", urlApplication + "?" + httpRequest.getQueryString());
                httpResponse.sendRedirect(context + "/app/login?message=application.messages.needSignin");
                return;
            }
        }
        chain.doFilter(request, response);
    }
    
    private DBRole roleIsFound(User user, Set<DBRole> roles) {
        for (DBRole role : roles) {
            for (Role userRole : user.getRoles()) {
                if (role.getId() == userRole.getId()) {
                    return role;
                }
            }
        }
        return null;
    }
}