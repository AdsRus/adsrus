package com.codeup.adsrus.dao;

import com.codeup.adsrus.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // get a list of all user ads
    List<Ad> all_ua(long uid);
    // get a list of all the ads searched by title
    List<Ad> all_searchads(String ad);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
}
