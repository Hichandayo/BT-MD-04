package ra.mainmd04.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Dữ liệu tài khoản và mật khẩu cố định
    private static final String FIXED_USERNAME = "admin";
    private static final String FIXED_PASSWORD = "password123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra tài khoản và mật khẩu
        if (FIXED_USERNAME.equals(username) && FIXED_PASSWORD.equals(password)) {
            // Đăng nhập thành công
            response.sendRedirect("/views/success.jsp");
        } else {
            // Đăng nhập thất bại, quay lại trang đăng nhập với thông báo lỗi
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không chính xác");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}