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

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/ads")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String searchAdd = request.getParameter("srch-term");
        if (request.getSession().getAttribute("user") != null) {
//            request.setAttribute("ads", DaoFactory.getAdsDao().all_searchads(searchAdd));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
//        request.setAttribute("ads", DaoFactory.getAdsDao().all_searchads(searchAdd));
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searchAdd = request.getParameter("srch-term");
        request.setAttribute("ads", DaoFactory.getAdsDao().all_searchads(searchAdd));
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
}