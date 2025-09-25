package com.jdc.web.Controller;


import com.jdc.web.Services.ColegioService;
import com.jdc.web.Services.SedeService;
import com.jdc.web.entities.ContactoEntity;
import com.jdc.web.entities.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SedeController {

    @Autowired
    private SedeService sedeService;
    @Autowired
    private ColegioService colegioService;

    @GetMapping("Listarsedes")
    public String listarSedes(Model model){
        model.addAttribute("titulo","Listar Sedes");
        model.addAttribute("sedes",sedeService.findAll());
        return "ListarSede";
    }
    @GetMapping("crearsede")
    public String crearSede(Model model){
        model.addAttribute("titulo","Crear Sede");
        model.addAttribute("objcSede", new SedeEntity());
        model.addAttribute("objListColegios",colegioService.findBySede());
        return "CrearSede";
    }
    @PostMapping(value = "/crearsede")
    public String guardarSede(SedeEntity sede){
        sedeService.save(sede);
        return "redirect:/Listarsedes";
    }
    @RequestMapping("/eliminarsede/{id}")
    public String eliminarSede(@PathVariable("id") Long id){
        if(id > 0){
            sedeService.deleteById(id);
        }
        return "redirect:/Listarsedes";
    }
    @GetMapping("/editarSedeBy/{id}")
    public String editarSede(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("titulo","Actualizar Sede");
        model.addAttribute("sedeactualizar", sedeService.findById(id));
        model.addAttribute("objListColegios",colegioService.findBySede());
        return "EditarSede";
    }


    @PostMapping("/editarSedeBy/{id}")
    public String editarSedeBy(@PathVariable("id") Long id, @ModelAttribute("sedeactualizar") SedeEntity sede){
        SedeEntity sedeExistente = sedeService.findById(id);
        sedeExistente.setNombre(sede.getNombre());
        sedeExistente.setDireccion(sede.getDireccion());
        sedeExistente.setColegio(sede.getColegio());

        sedeService.save(sedeExistente);
        return "redirect:/Listarsedes";
    }

}
