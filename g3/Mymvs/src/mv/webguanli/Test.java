package mv.webguanli;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {      //------跨域代理cookie测试
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getHeader("COOKIE"));
        HttpSession session = req.getSession();
        System.out.println("session: " + session.getId());
        if (session.getAttribute("hello") == null) {
            session.setAttribute("hello", "man");
            System.out.println("settring session.");
        } else {
            System.out.println(session.getAttribute("hello"));
        }

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName());
            }
        }
    }
}
