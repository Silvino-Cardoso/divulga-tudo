package com.ads.services.adsServiceImpl;


import com.ads.services.AdsService;
import com.ads.entities.Ads;
import com.ads.repositories.AdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {

    @Autowired
    AdsRepository adsRepository;

    @Override
    public List<Ads> findAll() {

        return adsRepository.findAll();
    }


    @Override
    public Ads save(Ads ads) {
        return adsRepository.save(ads);
    }

    @Override
    public List<Ads> searchAd(String clientName) {
        return adsRepository.searchAd(clientName);
    }
}
