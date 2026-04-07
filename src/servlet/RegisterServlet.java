package servlet;

import model.User;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ServletContext context = request.getServletContext();
        List<User> userList = (List<User>) context.getAttribute("userList");

        if(userList == null){
            userList = new ArrayList<User>();

            userList.add(new User(0,"Lamhandi","Taha","tahalamhandi11@gmail.com","1234"));
            userList.add(new User(1,"Nassih","Ayoub","ayoub11@gmail.com","1234"));

            context.setAttribute("userList",userList);
        }

        User newUser = new User(userList.getLast().getId() + 1,nom,prenom,email,password);

        for(User user : userList){
            if(user.getEmail().equals(newUser.getEmail())){
                request.setAttribute("errorSignup","Cet email est déjà associé à un compte");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        }

        userList.add(newUser);
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", newUser);
        response.sendRedirect("home.jsp");



    }
}
