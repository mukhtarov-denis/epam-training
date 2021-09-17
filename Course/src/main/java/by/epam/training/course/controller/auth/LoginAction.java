package by.epam.training.course.controller.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.training.course.controller.Action;
import by.epam.training.course.controller.Forward;
import by.epam.training.course.entity.User;
import by.epam.training.course.entity.user.StudentState;
import by.epam.training.course.entity.user.UserContext;
import by.epam.training.course.exception.ServiceException;
import by.epam.training.course.exception.ServiceFactoryException;
import by.epam.training.course.util.HashCode;

public class LoginAction extends Action {
        
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        HttpSession session = req.getSession();
        String lastUrl = (String) session.getAttribute("lastUrl");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username != null && password !=null) {
            try {
                User user = getServiceFactory().getUserService().findByUsername(username);
                if (user != null) {
                    String hashPassword = HashCode.getHash(password);
                    if (hashPassword.equals(user.getPassword())) {
                        UserContext userContext = new UserContext(user);
                        userContext.setState(new StudentState());
                        userContext.define();
                        session.setAttribute("session_user_context", userContext);
                        if (lastUrl != null) {
                            return new Forward(lastUrl, true);
                        } else {
                            return new Forward("/app/course", true);
                        }
                    } else {
                        req.setAttribute("message", "application.messages.auth.bad_password");
                    }
                } else {
                    req.setAttribute("message", "application.messages.auth.bad_user");
                }
            } catch (ServiceException | ServiceFactoryException e) {
                String catchMessage = String.format("Error login username for user: %s ", username);
                logger.error(catchMessage);
                throw new ServletException(catchMessage, e);
            }
        }
        Forward forward = new Forward("/login", false);
        return forward;
    }
}