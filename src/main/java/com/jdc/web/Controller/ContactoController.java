package com.jdc.web.Controller;


import com.jdc.web.Services.ColegioService;
import com.jdc.web.Services.ContactoService;
import com.jdc.web.entities.ContactoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactoController {


    @Autowired
    private ContactoService contactoService;

    @Autowired
    private ColegioService colegioService;


    @GetMapping("Listarcontactos")
    public String listarContacto(Model model){
        model.addAttribute("titulo","Listar Contactos");
        model.addAttribute("contactos",contactoService.findAll());
        return "ListarContacto";
    }
    @GetMapping("crearcontacto")
    public String crearContacto(Model model){
        model.addAttribute("titulo","Crear Contacto");
        model.addAttribute("objContacto", new ContactoEntity());
        model.addAttribute("objListColegios",colegioService.findByContacto());
        return "CrearContacto";
    }
    @PostMapping(value = "/crearcontacto")
    public String guardarContacto(ContactoEntity contacto){
        contactoService.save(contacto);
        return "redirect:/Listarcontactos";
    }
    @RequestMapping("/eliminarcontacto/{id}")
    public String eliminarContacto(@PathVariable("id") Long id){
        if(id > 0){
            contactoService.deleteById(id);
        }
        return "redirect:/Listarcontactos";
    }
    @GetMapping("/editarContactoBy/{id}")
    public String editarContacto(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("titulo","Actualizar Contacto");
        model.addAttribute("contactoactualizar", contactoService.findById(id));
        model.addAttribute("objListColegios",colegioService.findByContacto());
        return "EditarContacto";
    }


    @PostMapping("/editarContactoBy/{id}")
    public String editarColegioBy(@PathVariable("id") Long id, @ModelAttribute("contactoactualizar") ContactoEntity contacto){
        ContactoEntity contactoExistente = contactoService.findById(id);
        contactoExistente.setNumero(contacto.getNumero());
        contactoExistente.setTipocontacto(contacto.getTipocontacto());
        contactoExistente.setColegio(contacto.getColegio());

        contactoService.save(contactoExistente);
        return "redirect:/Listarcontactos";
    }
    @GetMapping("Listarprimeroscontactos")
    public String listarprimeroscontactos(Model model) {
        model.addAttribute("titulo", "Listar 8 Contactos");
        model.addAttribute("contactos", contactoService.findFirstContactos());
        return "Consulta4";
    }




}
