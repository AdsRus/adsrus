package com.codeup.adsrus.controllers;

import com.codeup.adsrus.models.User;
import com.codeup.adsrus.util.Password;
import com.codeup.adsrus.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        //Password in Database
        String userpass = user.getPassword();

        //Check login user password against hashed password in database
        Password pass = new Password();


        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

//        boolean validAttempt = password.equals(user.getPassword());
        boolean validAttempt = pass.check(password, userpass);

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            request.setAttribute("error", "Either your username or password are incorrect");
            request.getRequestDispatcher("/ogin");
//            request.getRequestDispatcher("/WEB-INF/login.jsp");
//            response.sendRedirect("/login");
        }
    }
}
