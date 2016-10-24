// Copyright © 2016 Lane Peeler
package edu.elon.events;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goelon")
public class HalloweenServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      
      String url = "/index.html";
      
      // get current action
      String action = request.getParameter("action");
      if (action == null) {
          action = "join";  // default action
      }
            
      // perform action and set URL to appropriate page
      if (action.equals("join")) {
          url = "/index.html";    // the "join" page
      } else if (action.equals("add")) {
          // get parameters from the request
          String firstName = request.getParameter("first-name");
          String lastName = request.getParameter("last-name");
          String email = request.getParameter("email");
          String zipCode = request.getParameter("zip-code");
          
          // print parameters; only print zip if one was entered
          System.out.println("First name: " + firstName);
          System.out.println("Last name: " + lastName);
          System.out.println("Email: " + email);
          if (zipCode != null && !zipCode.equals("")) {
              System.out.println("Zip code: " + zipCode);
          }
          
          url = "/subscribe.html";
      }
      
      getServletContext().getRequestDispatcher(url).forward(request, response);
      
    }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }

}
