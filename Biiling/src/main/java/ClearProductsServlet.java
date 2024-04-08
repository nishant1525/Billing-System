import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Remove the "products" attribute from the session
        request.getSession().removeAttribute("products");
        
        // Redirect back to the bill.jsp page or any other appropriate page
        response.sendRedirect("buildingSystem.jsp");
    }
}
