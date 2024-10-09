package com.example.demo.Controller;

import com.example.demo.Model.Libros;
import com.example.demo.Model.Ordenes;
import com.example.demo.Service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class OrdenesController {
    @Autowired
    private OrdenesService service;

    @GetMapping("/ordenes")
    public String ListarOrdenes(Model model){
        List<Ordenes> ordenes = service.findAllOrdenes();
        model.addAttribute("ordenes", ordenes);
        return "index";
    }

    @PostMapping("/SaveOrdenes")
    public String GuardarOrdenes(@ModelAttribute Ordenes ordenes){
        service.save(ordenes);
        return "redirect:/ordenes";
    }

    @GetMapping("/AgregarOrdenes")
    public String AgregarOrdenes(Model model){
        model.addAttribute("ordenes",new Ordenes());
        return "AddOrdenes";
    }
    @GetMapping("/VerOrden/{id}")
    public String VerOrdenes(@PathVariable long id, Model model){
        model.addAttribute("ordenes",service.findOneById(id));
        return "EditOrdenes";
    }
    @GetMapping("/BorrarOrdenes/{id}")
    public String BorrarOrdenes(@PathVariable long id){
        service.delete(id);
        return "redirect:/ordenes";
    }
}
