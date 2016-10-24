package fr.ecp.sio.filrougeapi.auth;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by usersio on 24/10/2016.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String auth = ((HttpServletRequest) servletRequest).getHeader("Authorization");
        //TODO
        if (auth == null) {
            ((HttpServletResponse) servletResponse).sendError(401, "Auth required");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

}
