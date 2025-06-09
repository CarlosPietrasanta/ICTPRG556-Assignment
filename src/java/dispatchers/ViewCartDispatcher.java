/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CartItem;

/**
 * Directs the user to the shopping cart page if the cart exists, 
 * or back to the titles page if the cart is empty or not created.
 * 
 * @author Carlos Pietrasanta
 */
public class ViewCartDispatcher implements Dispatcher {
    
        /**
        * Processes the "View Shopping Cart" action.
        * 
        * @param request the HTTP request containing session cart data
        * @param frontController that is handling HTTP requests and responses.
        * @return the path to either the cart or titles JSP page
        */
        @Override
        public String execute(HttpServletRequest request, FrontController frontController) {
        
        HttpSession session = request.getSession();
        
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            return "/jsp/titles.jsp";
        }
        else{
            return "/jsp/cart.jsp";
        }
    }
}
