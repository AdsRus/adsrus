package com.codeup.adsrus.controllers;

import com.codeup.adsrus.dao.DaoFactory;
import com.codeup.adsrus.models.User;
import com.codeup.adsrus.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null ) {
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        }
        else {
            request.setAttribute("error", "You must login to create an Ad!");
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");


        Ad ad = new Ad(
                user.getId(), // for now we'll hardcode the user id
                request.getParameter("title"),
                request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);

        response.sendRedirect("/ads");
        request.setAttribute("user_id", request.getSession().getAttribute("user_id"));




    }
}
