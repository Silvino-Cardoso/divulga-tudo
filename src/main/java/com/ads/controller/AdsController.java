package com.ads.controller;


import com.ads.entities.Ads;
import com.ads.services.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class AdsController {

    @Autowired
     private AdsService adsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBook(){
        ModelAndView mv = new ModelAndView("home");
        List<Ads> ads = adsService.findAll();
        mv.addObject("ads", ads);
        return mv;
    }

    @RequestMapping(value = "/newad", method = RequestMethod.GET)
    public String newAd(Model model){
        return "adForm";
    }

    @RequestMapping(value = "/newad", method = RequestMethod.POST)
    public String saveAd(@Valid Ads ads, BindingResult result, RedirectAttributes attributes) throws ParseException {
        if(result.hasErrors()){

            attributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/newad";
        }
        try{
            ads.setTotalInvestment(ads.getInitialDate(), ads.getFinalDate());
            ads.calculTotalViews();
            adsService.save(ads);
            return "redirect:/";
        }catch (Exception exception){
            attributes.addFlashAttribute("message", "Verifique se todos os campor foram preenchidos corretamente");

            return "redirect:/newad";
        }



    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("search") String search){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("ads", adsService.searchAd(search));
        return mv;
    }

}
