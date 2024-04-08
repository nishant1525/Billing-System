import com.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	HttpSession session = request.getSession();
//    	List<Product> products = new ArrayList<>();
        List<Product> products =(List<Product>) request.getSession().getAttribute("products");
        if (products == null) {
            products = new ArrayList<>();
            request.getSession().setAttribute("products", products);
        }
        
        String itemCode = request.getParameter("itemCode");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bill";
            String username = "root";
            String password = "9172654545";
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sql = "SELECT * FROM products WHERE item_code = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, itemCode);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String item = resultSet.getString("item_name");
                double price = resultSet.getDouble("price");
                Product product = new Product(item, itemCode, price, quantity);
                products.add(product);
            }
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("buildingSystem.jsp");
    }
}
