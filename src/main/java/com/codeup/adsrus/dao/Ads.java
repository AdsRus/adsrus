package com.codeup.adsrus.dao;

import com.codeup.adsrus.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> findById(long ad_id);

    //update ad by  id
    void updateAd(long id,String title,String description);

    //delete ad by id
    void deleteAd(long id);
    //
}
