import com.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintBillServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of products from the session
        List<Product> products = (List<Product>) request.getSession().getAttribute("products");
        
        // Check if products list is null or empty
        if (products == null || products.isEmpty()) {
            // If the list is null or empty, create a new empty list
            products = new ArrayList<>();
        }
        
        double totalWithoutTaxes = 0;
        
        // Calculate total without taxes
        for (Product product : products) {
            totalWithoutTaxes += product.getTotalWithoutTaxes();
        }
        
        // Calculate taxes
        double tax = totalWithoutTaxes * 0.18; 
        // Calculate grand total
        double grandTotal = totalWithoutTaxes + tax;
        
        // Set request attributes for use in JSP
        request.setAttribute("products", products);
        request.setAttribute("totalWithoutTaxes", totalWithoutTaxes);
        request.setAttribute("tax", tax);
        request.setAttribute("grandTotal", grandTotal);
        
        // Forward the request to bill.jsp for rendering
        request.getRequestDispatcher("bill.jsp").forward(request, response);
    }
}
