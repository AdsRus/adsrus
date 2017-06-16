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
import java.lang.Object;
import java.io.PrintWriter;

@WebServlet(name = "controllers.AdsIndividualServlet", urlPatterns = "/individual")
public class AdsIndividualServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String test = request.getParameter("id");
        Long ad_id = Long.parseLong(test);
       // Ad ad = DaoFactory.getAdsDao().findById(ad_id);
        //User user = DaoFactory.getUsersDao().findById(ad.getUserId());
        request.setAttribute("ads", DaoFactory.getAdsDao().findById(ad_id));

       // request.getSession().setAttribute("ads", ad);
       // request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/ads/indivAds.jsp").forward(request, response);
    }
}

        //request.getRequestDispatcher("/WEB-INF/ads/indivAds.jsp").forward(request, response);
    //}
//}