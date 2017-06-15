package com.codeup.adsrus.controllers;


import com.codeup.adsrus.dao.DaoFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String searchAd = request.getParameter("srch-term");
        request.setAttribute("ads", DaoFactory.getAdsDao().all_searchads(searchAd));*/
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searchAd = request.getParameter("srch-term");
        request.setAttribute("ads", DaoFactory.getAdsDao().all_searchads(searchAd));
        response.sendRedirect("/ads");

    }
}