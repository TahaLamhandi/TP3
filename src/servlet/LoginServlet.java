package servlet;

import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        List<User> userList = (List<User>) context.getAttribute("userList");

        if( userList == null ) {
            userList = new ArrayList<User>();

            userList.add(new User(0,"Lamhandi","Taha","tahalamhandi11@gmail.com","1234"));
            userList.add(new User(1,"Nassih","Ayoub","ayoub11@gmail.com","1234"));

            context.setAttribute("userList",userList);
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        for (User user : userList){
            if( user.getEmail().equals(email) && user.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                response.sendRedirect("home.jsp");
                return ;
            }
        }

        request.setAttribute("error", "Email ou mot de passe incorrect !");
        request.getRequestDispatcher("login.jsp").forward(request,response);

    }


}
