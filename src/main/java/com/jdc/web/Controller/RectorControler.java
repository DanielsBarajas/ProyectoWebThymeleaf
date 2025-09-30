package com.jdc.web.Controller;

import com.jdc.web.Services.ColegioService;
import com.jdc.web.Services.RectorService;
import com.jdc.web.entities.ColegioEntity;
import com.jdc.web.entities.RectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RectorControler {

    @Autowired
    private RectorService rectorService;

    @Autowired
    private ColegioService colegioService;

    @GetMapping("Listarrectores")
    public String listarRector(Model model){
        model.addAttribute("titulo","Listar Rector");
        model.addAttribute("rectores",rectorService.findAll());
        return "ListarRector";
    }
    @GetMapping("crearrector")
    public String crearRector(Model model){
        model.addAttribute("titulo", "Formulario Rectores");
        model.addAttribute("objRector", new RectorEntity());
        model.addAttribute("objListColegios",colegioService.findByRector());
        return "CrearRector";
    }
    @PostMapping(value = "/crearrector")
    public String guardarRector(RectorEntity rector){
        rectorService.save(rector);
        return "redirect:/Listarrectores";
    }
    @RequestMapping("/eliminarrector/{id}")
    public String eliminarRector(@PathVariable("id") Long id){
        if(id > 0){
            rectorService.deleteById(id);
        }
        return "redirect:/Listarrectores";
    }
    @GetMapping("/editarRectorBy/{id}")
    public String editarRector(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("titulo","Actualizar Rector");
        model.addAttribute("rectoractualizar", rectorService.findById(id));
        model.addAttribute("objListColegios",colegioService.findByRector());
        return "EditarRector";
    }


    @PostMapping("/editarRectorBy/{id}")
    public String editarRectorBy(@PathVariable("id") Long id, @ModelAttribute("rectoractualizar") RectorEntity rector){
        RectorEntity rectorExistente = rectorService.findById(id);
        rectorExistente.setNombre(rector.getNombre());
        rectorExistente.setPrimerapellido(rector.getPrimerapellido());
        rectorExistente.setPrimerapellido(rector.getSegundoapellido());
        rectorExistente.setNumdocumento(rector.getNumdocumento());
        rectorExistente.setTipodocumento(rector.getTipodocumento());
        rectorExistente.setColegio(rector.getColegio());
        rectorService.save(rectorExistente);
        return "redirect:/Listarrectores";
    }

    @GetMapping("Listarrectores1")
    public String findRector1(Model model){

        model.addAttribute("titulo","Rectores = 1");

        model.addAttribute("rectores",rectorService.findByRector());
        return "Consulta1";
    }

}
