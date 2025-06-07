/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import utility.AdmitBookStoreDAO;

/**
 *
 * @author Carlos Pietrasanta
 */
public class NullActionDispatcher implements Dispatcher {

    @Override
    public String execute(HttpServletRequest request, FrontController frontController) {
        
        HttpSession session = request.getSession();
        
        String nextPage = "";

        AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
        List<Book> books = null;
        session = request.getSession();
        try {
            books = dao.getAllBooks();
            session.setAttribute("books", books);
            nextPage = "/jsp/titles.jsp";
        } catch (Exception ex) {
            request.setAttribute("result", ex.getMessage());
            nextPage = "/jsp/error.jsp";
        }
        
        return nextPage;
    }
}
