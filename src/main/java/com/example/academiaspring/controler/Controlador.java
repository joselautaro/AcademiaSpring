package com.example.academiaspring.controler;

import org.springframework.ui.Model;
import com.example.academiaspring.interfaceService.IpersonaService;
import com.example.academiaspring.modelo.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IpersonaService service;
    
    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona>personas=service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }
    
    
    
    
    
}
