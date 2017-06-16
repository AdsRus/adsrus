package com.codeup.adsrus.controllers;

import com.codeup.adsrus.models.User;
import com.codeup.adsrus.util.Password;
import com.codeup.adsrus.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate empty input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        // validate email format
        boolean validemailFormat = isValidEmailAddress(email);

        // validate password length is at least 7 digits
        boolean passwordFormat = isPasswordLengthSeven(password);



        if (inputHasErrors) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Fields cannot be empty!");
            response.sendRedirect("/register");
            return;
        }
        else if (!validemailFormat) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Email format is invalid! ");
            response.sendRedirect("/register");
            return;
        }
        else if (passwordFormat) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Password must contain at least 7 characters!");
            response.sendRedirect("/register");
            return;
        }

        // hash password
        Password pass = new Password();
        String hash = pass.hash(password);

        // create and save a new user

        User user = new User(username, email, hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");

    }

    static boolean isValidEmailAddress(String emailVar) {

        String mylRegExpVar = "[A-Za-z0-9._%+-]{2,}+@[A-Za-z-]{2,}+\\.[A-Za-z]{2,}";

        Pattern pVar = Pattern.compile(mylRegExpVar);
        Matcher mVar = pVar.matcher(emailVar);
        return mVar.matches();
    }

    static boolean isPasswordLengthSeven(String passVar) {
        if (passVar.length() < 7) {
            return false;
        }
        return true;

    }


}
