/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import model.CartItem;
import utility.AdmitBookStoreDAO;

/**
 *
 * @author Carlos Pietrasanta
 */
public class UpdateCartDispatcher implements Dispatcher {

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
