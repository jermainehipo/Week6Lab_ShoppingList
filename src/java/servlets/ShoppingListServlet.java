package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerma
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                        .forward(request, response);
        } else {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                        .forward(request, response);
        }
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("username") == null) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
        }
        request.setAttribute("username", session.getAttribute("username"));
        
        if (session.getAttribute("list") == null) {
            if (request.getParameter("itemtoadd") != null || request.getParameter("itemtoadd") != "") {
                ArrayList<String> list = new ArrayList<String>();
                list.add(request.getParameter("itemtoadd"));
                session.setAttribute("items", list);
            }
        } else {
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
            list.add(request.getParameter("itemtoadd"));
            session.setAttribute("items", list);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                        .forward(request, response);
        
    }
}
