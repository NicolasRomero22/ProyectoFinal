package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Ejemplar;
import com.example.ProyectoFinal.Services.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejemplar")
public class EjemplarController {

    @Autowired
    private EjemplarService ejemplarService;

    @GetMapping("/listar")
    public ResponseEntity<List<Ejemplar>> listar() {
        return new ResponseEntity<>(ejemplarService.listar(), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Ejemplar> buscar(@PathVariable long id) {
        try {
            return new ResponseEntity<>(ejemplarService.buscar(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Ejemplar> guardar(@RequestBody Ejemplar obj) {
        return new ResponseEntity<>(ejemplarService.guardar(obj), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ejemplar> actualizar(@PathVariable long id, @RequestBody Ejemplar obj) {
        try {
            return new ResponseEntity<>(ejemplarService.actualizar(id, obj), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        try {
            ejemplarService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

