package bookshop.web.book;

import bookshop.dao.impl.book.BookDaoImpl;
import bookshop.entity.Book;
import bookshop.vo.ResultVO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/api/book/edit")
@MultipartConfig
public class BookEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int typeNo = Integer.parseInt(req.getParameter("typeNo"));
        int rid = Integer.parseInt(req.getParameter("rid"));
        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        int buyCount = Integer.parseInt(req.getParameter("buyCount"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String content = req.getParameter("content");
        Part cover = req.getPart("cover");

        //图片操作
        String fileName = null;
        try {
            if (cover.getSubmittedFileName() != null) {
//                //删除旧的存储地址
                Book getbookinfo = new BookDaoImpl().getBookinfo(id);
                Gson gson = new Gson();
                String s = gson.toJson(getbookinfo);
                Book book = gson.fromJson(s, Book.class);
                File file = new File(getServletContext().getRealPath("/") + book.getCover());
                file.delete();
                //新的存储地址
                fileName = "/img/" + "upload_" + System.currentTimeMillis() + "_" + cover.getSubmittedFileName();
                cover.write(getServletContext().getRealPath("/") + fileName); //保存地址
            } else {
                Book getbookinfo = new BookDaoImpl().getBookinfo(id);
                Gson gson = new Gson();
                String s = gson.toJson(getbookinfo);
                Book book = gson.fromJson(s, Book.class);
                fileName = book.getCover();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
        //更新
        try {
            BookDaoImpl bookDao = new BookDaoImpl();
            Book book = new Book(typeNo, rid, bookName, author, price, buyCount, stock, content, fileName);
            Book bookInfo = bookDao.updateBookInfo(book, id);
            if (bookInfo != null) {
                resp.getWriter().println(ResultVO.success(bookInfo, "编辑完成").toJSON());
            } else {
                resp.getWriter().println(ResultVO.err(400, "编辑失败，请重试"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }


}
