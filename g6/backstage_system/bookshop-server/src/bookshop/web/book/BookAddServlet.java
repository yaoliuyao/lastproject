package bookshop.web.book;

import bookshop.dao.impl.book.BookDaoImpl;
import bookshop.dao.impl.book.BookTypeDaoImpl;
import bookshop.entity.Book;
import bookshop.vo.ResultVO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/api/add/book")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int typeNo = Integer.parseInt(req.getParameter("typeNo"));
        int rid = Integer.parseInt(req.getParameter("rid"));
        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        int buyCount = Integer.parseInt(req.getParameter("buyCount"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String content = req.getParameter("content");
        Part cover = req.getPart("cover");
        String fileName = null;
        if (cover != null) {
            fileName = "/img/" + "upload_" + System.currentTimeMillis() + "_" + cover.getSubmittedFileName();
            cover.write(getServletContext().getRealPath("/") + fileName); //保存地址

        }

        try {
             Book book = new Book(typeNo, rid, bookName, author, price, buyCount, stock, content,fileName );
             Book result = new BookDaoImpl().addBookInfo(book);
            if (result!=null){
                resp.getWriter().println(ResultVO.success(result,"书籍添加完成").toJSON());
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }

    }
}

