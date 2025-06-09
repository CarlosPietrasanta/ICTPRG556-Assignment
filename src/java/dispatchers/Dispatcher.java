/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import controller.FrontController;
import javax.servlet.http.HttpServletRequest;

/**
 * Defines a contract for handling user actions within the FrontController.
 * Each implementation processes a specific request and returns the next page to display.
 * 
 * @author Carlos Pietrasanta
 */
public interface Dispatcher {
    /**
     * Executes the action logic and returns the path to the next view.
     *
     * @param request the HTTP request containing user input
     * @param frontController that is handling HTTP requests and responses.
     * @return the path to the next JSP page
     */
    public String execute(HttpServletRequest request, FrontController frontController);
}
