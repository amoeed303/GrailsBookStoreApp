package BookStoreBackend

import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class authFilters extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        def session = request.getSession()
        def user = session.getAttribute("user")
        def isAdmin = session.getAttribute("isAdmin")
        def requestURI = request.getRequestURI()
        if (requestURI.contains("true") && !isAdmin) {
            response.sendRedirect("login/login")
        } else if (requestURI.contains("user") && !user) {
            response.sendRedirect("login/login")
        } else {
            filterChain.doFilter(request, response)
        }
    }

}
