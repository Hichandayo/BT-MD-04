package ra.mainmd04.controller;

import ra.mainmd04.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showUserData")
public class UserDataServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // Khởi tạo đối tượng UserData với dữ liệu cố định
        User user = new User(1, "name", "name@gmail.com", 18);

        // Lưu đối tượng vào request scope
        request.setAttribute("user", user);

        // Chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/displayUserData.jsp").forward(request, response);
    }
}
