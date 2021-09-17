function doLang() {
	let lang = getCookie('lang');
    if (lang == 'ru') {
    	document.cookie = 'lang=en';	
    } 
    if (lang == 'en') {
    	document.cookie = 'lang=ru';
	}
    window.location.reload();
}
            		
function getCookie(name) {
	let matches = document.cookie.match(new RegExp("(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}