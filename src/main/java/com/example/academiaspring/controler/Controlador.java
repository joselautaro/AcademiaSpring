package com.example.academiaspring.controler;

import org.springframework.ui.Model;
import com.example.academiaspring.interfaceService.IpersonaService;
import com.example.academiaspring.modelo.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

//Indicamos que es el controlador
@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IpersonaService service;
    
    //Creamos el método para listar
    @GetMapping("/")
    public String listar(Model model){
        List<Persona>personas=service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }
    
    //Creamos el método para agregar new
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }
    
    //Funcionalidad para guardar los cambios
    @PostMapping("/save")
    public String save(@Valid Persona p, Model model){
        service.save(p);
        return "redirect:/";
    }
    
    //Funcionalidad para editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona>persona = service.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/";
    }
    
}
