package club.piclight.LibraryManLite.Controller;

import club.piclight.LibraryManLite.Model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/bookregister", "/managebook"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("user");
        try {
            if (!user.getUsername().equals("admin")) {
                throw new IllegalAccessException("Not admin");
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (IllegalAccessException e) { // 非法访问
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/WEB-INF/errorpage.html");
            dispatcher.forward(servletRequest, servletResponse);
        } catch (NullPointerException e) { //未登录
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/WEB-INF/errorpage.html");
            dispatcher.forward(servletRequest, servletResponse);
        } catch (Exception e) { //未知错误
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/WEB-INF/errorpage.html");
            dispatcher.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
