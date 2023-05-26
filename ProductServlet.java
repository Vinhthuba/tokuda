package Demo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private List<Product> productList;
    @Override
    public void init() throws ServletException{
        super.init();
        productList = new ArrayList<>();
        productList.add(new Product(1,"Doraemon","tokuda",18500,"manga","good for kid", 12000));
        productList.add(new Product(2,"Conan","aoi",20000,"manga","good for kid", 11000));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = productList.size() + 1;
        String name = request.getParameter("name");
        String author = request.getParameter("author");

        float price = Float.parseFloat(request.getParameter("price"));
        String category = request.getParameter("category");
        String desc = request.getParameter("desc");
        float amount = Float.parseFloat(request.getParameter("amount"));

        Product newProduct = new Product(id, name, author,price,category,desc,amount);
        productList.add(newProduct);

        response.sendRedirect("products");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = getProductById(id);

        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");

        float price = Float.parseFloat(request.getParameter("price"));
        String category = request.getParameter("category");
        String desc = request.getParameter("desc");
        float amount = Float.parseFloat(request.getParameter("amount"));

        Product product = getProductById(id)
                ;
        product.setName(name);
        product.setAuthor(author);
        product.setPrice(price);
        product.setCategory(category);
        product.setDesc(desc);
        product.setAmount(amount);



        response.sendRedirect("products");
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = getProductById(id)
                ;
        productList.remove(product);

        response.sendRedirect("products");

    }
    private Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
