package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
            //httpServletResponse.sendRedirect("/hello");
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        boolean hasUser = false;
        boolean hasAdmin = false;
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("USER")) {
                hasUser = true;
                //response.sendRedirect("user");
                //  break;
            } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                hasAdmin = true;
                //response.sendRedirect("admin");
            }
//            else {
//                response.sendRedirect("login");
//            }
        }
        if (hasAdmin) {
            response.sendRedirect("admin");
        } else if (hasUser){
            response.sendRedirect("user");
        } else {
            response.sendRedirect("login");
        }
    }
}

