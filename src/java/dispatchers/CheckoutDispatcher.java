/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Carlos Pietrasanta
 */
public class CheckoutDispatcher implements Dispatcher {
    
        @Override
        public String execute(HttpServletRequest request, FrontController frontController) {
        
        return "/jsp/checkout.jsp";
    }
}