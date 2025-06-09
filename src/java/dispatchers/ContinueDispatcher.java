/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import javax.servlet.http.HttpServletRequest;

/**
 * Returns the user to the titles page to continue browsing books.
 * 
 * @author Carlos Pietrasanta
 */
public class ContinueDispatcher implements Dispatcher {
    
        /**
        * Processes the "Continue Shopping" action.
        * 
        * @param request the HTTP request
        * @param frontController that is handling HTTP requests and responses.
        * @return the path to the titles JSP page
        */
        @Override
        public String execute(HttpServletRequest request, FrontController frontController) {
        
        return "/jsp/titles.jsp";
    }
}