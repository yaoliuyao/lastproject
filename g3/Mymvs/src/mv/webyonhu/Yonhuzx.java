package mv.webyonhu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/yhzx")
public class Yonhuzx extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
<<<<<<< HEAD
        session.setAttribute("sess2", null);
=======
        session.setAttribute("sess", null);
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa
    }

}
