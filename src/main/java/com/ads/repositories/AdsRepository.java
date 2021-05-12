package com.ads.repositories;


import com.ads.entities.Ads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdsRepository  extends JpaRepository<Ads, Long> {


    /*Implementando consulta no banco de dados para pesquisa, busca por nome do cliente,
    * nome do anuncio, data inicial e data final*/
    @Query( value = "select * from tb_ads where (client_name like %?1% or ad_name like %?1% or final_date like %?1% or initial_date like %?1%)" , nativeQuery = true)
    List<Ads> searchAd(String clientName);
}
