/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CartItem;

/**
 * Updates the user's shopping cart by removing selected items and updating quantities.
 * Redirects to the cart page after processing.
 * 
 * @author Carlos Pietrasanta
 */
public class UpdateCartDispatcher implements Dispatcher {
    
    /**
     * Processes the update-cart action.
     * 
     * @param request the HTTP request containing updated quantities and items to remove
     * @param frontController that is handling HTTP requests and responses.
     * @return the path to the cart JSP page
     */
    @Override
    public String execute(HttpServletRequest request, FrontController frontController) {

        HttpSession session = request.getSession();

        Map<String, CartItem> cart = null;
        CartItem item = null;
        String isbn = null;
        cart = (Map<String, CartItem>) session.getAttribute("cart");
        String[] booksToRemove = request.getParameterValues("remove");
        if (booksToRemove != null) {
            for (String bookToRemove : booksToRemove) {
                cart.remove(bookToRemove);
            }
        }
        Set<Map.Entry<String, CartItem>> entries = cart.entrySet();
        Iterator<Map.Entry<String, CartItem>> iter = entries.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, CartItem> entry = iter.next();
            isbn = entry.getKey();
            item = entry.getValue();
            int quantity = Integer.parseInt(request.getParameter(isbn));
            item.updateQuantity(quantity);
        }
        
        return "/jsp/cart.jsp";
    }
}
