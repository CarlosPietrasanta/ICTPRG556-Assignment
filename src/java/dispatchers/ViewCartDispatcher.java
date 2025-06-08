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
 *
 * @author Carlos Pietrasanta
 */
public class ViewCartDispatcher implements Dispatcher {
    
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
