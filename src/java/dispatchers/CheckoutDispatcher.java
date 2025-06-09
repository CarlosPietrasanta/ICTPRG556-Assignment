/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import javax.servlet.http.HttpServletRequest;

/**
 * Directs the user to the checkout page to enter payment details.
 * 
 * @author Carlos Pietrasanta
 */
public class CheckoutDispatcher implements Dispatcher {
    
        /**
        * Processes the "Check Out" action.
        * 
        * @param request the HTTP request
        * @param frontController that is handling HTTP requests and responses.
        * @return the path to the checkout JSP page
        */
        @Override
        public String execute(HttpServletRequest request, FrontController frontController) {
        
        return "/jsp/checkout.jsp";
    }
}