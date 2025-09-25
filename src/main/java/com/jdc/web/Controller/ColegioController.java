package com.jdc.web.Controller;


import com.jdc.web.Services.ColegioService;
import com.jdc.web.entities.ColegioEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class ColegioController {

    @Autowired
    private ColegioService colegioService;

    @GetMapping("Listarcolegios")
    public String listarColegio(Model model){
        model.addAttribute("titulo", "Listar Colegio");
        model.addAttribute("colegios", colegioService.findAll());
        return "ListarColegio";


    }
    @GetMapping("crearcolegio")
    public String crearColegio(Model model){
        model.addAttribute("titulo", "Formulario Colegio");
        model.addAttribute("objcolegio", new ColegioEntity());
        return "CrearColegio";
    }

    @PostMapping(value = "/crearcolegio")
    public String guardarColegio(@Valid ColegioEntity colegio, SessionStatus status){
        colegio.setEstado(true);
        colegioService.save(colegio);
        status.setComplete();
        return "redirect:/Listarcolegios";
    }

    @RequestMapping("/eliminarcolegio/{id}")
    public String eliminarColegio( @PathVariable("id") Long id){
        if(id>0){
            colegioService.deleteById(id);
        }
        return "redirect:/Listarcolegios";
    }
    @GetMapping("/editarColegioBy/{id}")
    public String editarColegioBy( @PathVariable(value = "id") Long id, Model model){
        model.addAttribute("titulo", "Actualizar Colegio");
        model.addAttribute("colegioActualizar", colegioService.findById(id));
        return "EditarColegio";
    }
    @PostMapping("/editarColegioBy/{id}")
    public String guardarEditarColegio(@PathVariable(value = "id") Long id, @ModelAttribute("colegioActualizar")ColegioEntity colegio, SessionStatus status){
        ColegioEntity colegioExistente = colegioService.findById(id);
        colegioExistente.setNombre(colegio.getNombre());
        colegioExistente.setDescripcion(colegio.getDescripcion());
        colegio.setEstado(true);

        colegioService.save(colegioExistente);
        return "redirect:/Listarcolegios";
    }
    @RequestMapping(value = "/cambiarEstado/{id}")
    public String cambiarEstado (@PathVariable(value = "id")Long id){
        if(id > 0){
            colegioService.updateEstado(id);
        }
        return "redirect:/Listarcolegios";
    }

}
