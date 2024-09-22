package ra.mainmd04.controller;

import ra.mainmd04.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    static List<Customer> customers = new ArrayList<>();
    static{
        customers.add(new Customer(1, "Nguyễn Thế Hiển", LocalDate.of(1999, 8, 20), "Hà Nội", "https://img4.thuthuatphanmem.vn/uploads/2020/06/22/anh-dep-cho-desktop_092751588.jpg"));
        customers.add(new Customer(2, "Nguyễn Hoài Trung", LocalDate.of(1921, 8, 21), "Bắc Giang", "https://img4.thuthuatphanmem.vn/uploads/2020/06/22/anh-dep-cho-desktop_092751588.jpg"));
        customers.add(new Customer(3, "Phan Văn Trị", LocalDate.of(1943, 8, 22), "Nam Định", "https://img4.thuthuatphanmem.vn/uploads/2020/06/22/anh-dep-cho-desktop_092751588.jpg"));
        customers.add(new Customer(4, "Nguyễn Đăng Khoa", LocalDate.of(1963, 8, 17), "Hà Tây", "https://img4.thuthuatphanmem.vn/uploads/2020/06/22/anh-dep-cho-desktop_092751588.jpg"));
        customers.add(new Customer(5, "Nguyễn Văn Tuấn", LocalDate.of(1973, 8, 19), "Hà Nội", "https://img4.thuthuatphanmem.vn/uploads/2020/06/22/anh-dep-cho-desktop_092751588.jpg"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("getCustomer")) {
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}