package com.codeup.adsrus.controllers;

import com.codeup.adsrus.dao.DaoFactory;
import com.codeup.adsrus.models.Ad;
import com.codeup.adsrus.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }


        User user = (User) request.getSession().getAttribute("user");

        long use_id;
        Ad ad = new Ad(
                use_id = user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );

        request.setAttribute("ads", DaoFactory.getAdsDao().all_ua(use_id));
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
