package ra.mainmd04.controller;



import org.example.baitap1.dao.student.IStudentDao;
import org.example.baitap1.dao.student.StudentDao;
import org.example.baitap1.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(value = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("students", studentDao.getAll());
                    request.getRequestDispatcher("/views/list.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    studentDao.delete(idDel);
                    response.sendRedirect("/student?action=GETALL");
                    break;
                case "DETAIL":
                    Integer idDetail = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("student", studentDao.getById(idDetail));
                    request.getRequestDispatcher("/views/detail.jsp").forward(request, response);
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("student", studentDao.getById(idEdit));
                    request.getRequestDispatcher("/views/edit.jsp").forward(request, response);
                    break;
                case "CREATE":
                    request.getRequestDispatcher("/views/create.jsp").forward(request, response);
                    break;
                case "SEARCH":
                    String name = request.getParameter("name");
                    request.setAttribute("students", studentDao.searchByName(name));
                    request.getRequestDispatcher("/views/search.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect("/student?action=GETALL");
                    break;
            }
        } else {
            response.sendRedirect("/student?action=GETALL");
        }
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        boolean status = request.getParameter("status") != null;

        if (action != null) {
            switch (action) {
                case "ADD":
                    Student newStudent = new Student(
                            0,
                            request.getParameter("name"),
                            request.getParameter("email"),
                            request.getParameter("address"),
                            request.getParameter("phone"),
                            status
                    );
                    studentDao.save(newStudent);
                    response.sendRedirect("/student?action=GETALL");
                    break;
                case "UPDATE":
                    Student updateStudent = new Student(
                            Integer.parseInt(request.getParameter("id")),
                            request.getParameter("name"),
                            request.getParameter("email"),
                            request.getParameter("address"),
                            request.getParameter("phone"),
                            status
                    );
                    studentDao.update(updateStudent);
                    response.sendRedirect("/student?action=GETALL");
                    break;
                default:
                    response.sendRedirect("/student?action=GETALL");
                    break;
            }
        } else {
            response.sendRedirect("/student?action=GETALL");
        }
    }
}
