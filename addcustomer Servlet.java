package servlet;
import dao.CustomerDAO;
import model.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Customer customer = new Customer(name, email, phone);
        CustomerDAO customerDAO = new CustomerDAO();
        
        if (customerDAO.addCustomer(customer)) {
            response.sendRedirect("index.jsp?msg=Customer added successfully");
        } else {
            response.sendRedirect("add_customer.jsp?msg=Error adding customer");
        }
    }
}
