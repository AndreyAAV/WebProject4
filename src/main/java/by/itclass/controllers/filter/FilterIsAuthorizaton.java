package by.itclass.controllers.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "FilterIsAuthorizatonFilter")
class FilterIsAuthorizatonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpSession session = servletRequest.getAttribute();
//
//        if () {
//            chain.doFilter(servletRequest, servletResponse)
//        } else {
//            HttpServletResponse response = (HttpServletResponse)
//                    servletResponse.sendRedirect("....");
//        }
    }

    @Override
    public void destroy() {

    }
}
