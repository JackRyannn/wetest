package com.renchao.wetest.controllers;

import com.renchao.wetest.models.Mobile;
import com.renchao.wetest.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    MobileService mobileService;

    @RequestMapping("/index")
    public String index(Model model){
        List<Mobile> mobiles = mobileService.getMobiles();
        List<String> systemList = mobileService.getDistinctKinds("system");
        List<String> sizeList = mobileService.getDistinctKinds("size");
        List<String> brandList = mobileService.getDistinctKinds("brand");

        model.addAttribute("systemList",systemList);
        model.addAttribute("sizeList",sizeList);
        model.addAttribute("brandList",brandList);
        model.addAttribute("mobileList",mobiles);
        return "/index";
    }


}