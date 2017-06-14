package com.codeup.adsrus.dao;

import com.codeup.adsrus.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // get a list of all user ads
    List<Ad> all_ua(long uid);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
}
