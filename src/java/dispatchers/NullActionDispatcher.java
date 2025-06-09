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
 * Loads all available books and stores them in the session.
 * Used when no specific action is requested by the user.
 * 
 * @author Carlos Pietrasanta
 */
public class NullActionDispatcher implements Dispatcher {
    
    /**
     * Executes the default action by retrieving all books and forwarding to the titles page. 
     * If an error occurs, redirects to the error page.
     * 
     * @param request the HTTP request
     * @param frontController used to access the book service
     * @return the path to either the titles or error JSP page
     */
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
