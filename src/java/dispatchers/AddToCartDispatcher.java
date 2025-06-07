/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import model.CartItem;

/**
 *
 * @author Carlos Pietrasanta
 */
public class AddToCartDispatcher implements Dispatcher {
    
    @Override
    public String execute(HttpServletRequest request, FrontController frontController){

        HttpSession session = request.getSession();
        
        String nextPage = "/jsp/titles.jsp";
        
        // Retrieve the cart from the session
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        String[] selectedBooks = request.getParameterValues("add");

        // Check if selectedBooks is null or empty
        if (selectedBooks == null || selectedBooks.length == 0) {
            return nextPage;
        }

        // If the cart is null, create a new cart and add selected books
        if (cart == null) {
            cart = new HashMap();

            for (String isbn : selectedBooks) {
                int quantity = Integer.parseInt(request.getParameter(isbn));
                Book book = frontController.getBookFromList(isbn, session);
                CartItem item = new CartItem(book);
                item.setQuantity(quantity);
                cart.put(isbn, item);
            }
            session.setAttribute("cart", cart);
        } else {
            // If the cart already exists, update the quantities of selected books
            for (String isbn : selectedBooks) {
                int quantity = Integer.parseInt(request.getParameter(isbn));
                if (cart.containsKey(isbn)) {
                    CartItem item = cart.get(isbn);
                    item.setQuantity(quantity);
                } else {
                    Book book = frontController.getBookFromList(isbn, session);
                    CartItem item = new CartItem(book);
                    item.setQuantity(quantity);
                    cart.put(isbn, item);
                }
            }
        }
        
        return nextPage;
    }
}
