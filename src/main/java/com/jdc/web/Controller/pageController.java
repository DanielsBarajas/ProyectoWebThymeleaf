package com.jdc.web.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {



    @GetMapping("pensum")
    public String miweb(){
        return "pensum.html";
    }

    @GetMapping("AcercaDe")
    public String acercaDe(){
        return "AcercaDe.html";
    }

    @GetMapping("index")
    public String index(){
        return "index.html";
    }
}
