package com.ads.services;

import com.ads.entities.Ads;

import java.util.List;

public interface AdsService {

        List<Ads> findAll();
        Ads save(Ads ads);
        List<Ads> searchAd(String clientName);

    }


