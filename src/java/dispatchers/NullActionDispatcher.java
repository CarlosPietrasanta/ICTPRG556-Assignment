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

/**
 *
 * @author Carlos Pietrasanta
 */
public class NullActionDispatcher implements Dispatcher {
    
    @Override
    public String execute(HttpServletRequest request, FrontController frontController) {
        
        HttpSession session = request.getSession();
        
        String nextPage = "";
        
        List<Book> books = null;
        try {
            books = frontController.bookService.findAllBooks();
            
            session.setAttribute("books", books);
            nextPage = "/jsp/titles.jsp";
        } catch (Exception ex) {
            request.setAttribute("result", ex.getMessage());
            nextPage = "/jsp/error.jsp";
        }
        
        return nextPage;
    }
}
