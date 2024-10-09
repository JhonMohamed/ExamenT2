package com.example.demo.Controller;


import com.example.demo.Model.Libros;
import com.example.demo.Service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibrosController {
    @Autowired
    private LibrosService service;

    @GetMapping("/libros")
    public String ListarLibros(Model model){
        List<Libros> libros = service.findAllLibros();
        model.addAttribute("libros", libros);
        return "index";
    }

    @PostMapping("/SaveLibros")
    public String GuardarLibros(@ModelAttribute Libros libros) {
        service.save(libros);
        return "redirect:/libros";
    }
    @GetMapping("/AgregarLibros")
    public String AgregarLibros(Model model) {
        model.addAttribute("libro", new Libros());
        return "AddLibro";
    }
    @GetMapping("/VerLibros/{id}")
    public String VerLibros(@PathVariable long id, Model model) {
        model.addAttribute("libro", service.findOneById(id));
        return "EditLibro";
    }
    @GetMapping("/BorrarLibros/{id}")
    public String BorrarLibros(@PathVariable long id) {
        service.delete(id);
        return "redirect:/libros";
    }
}
