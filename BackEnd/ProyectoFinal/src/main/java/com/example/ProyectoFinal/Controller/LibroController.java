package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Libro;
import com.example.ProyectoFinal.Services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Libro>> listar() {
        return new ResponseEntity<>(libroService.listar(), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable long id) {
        try {
            return new ResponseEntity<>(libroService.buscar(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Libro> guardar(@RequestBody Libro obj) {
        return new ResponseEntity<>(libroService.guardar(obj), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable long id, @RequestBody Libro obj) {
        try {
            return new ResponseEntity<>(libroService.actualizar(id, obj), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        try {
            libroService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

