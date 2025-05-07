package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Prestamo;
import com.example.ProyectoFinal.Services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Prestamo>> listar() {
        return new ResponseEntity<>(prestamoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Prestamo> buscar(@PathVariable long id) {
        try {
            return new ResponseEntity<>(prestamoService.buscar(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Prestamo> guardar(@RequestBody Prestamo obj) {
        return new ResponseEntity<>(prestamoService.guardar(obj), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Prestamo> actualizar(@PathVariable long id, @RequestBody Prestamo obj) {
        try {
            return new ResponseEntity<>(prestamoService.actualizar(id, obj), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        try {
            prestamoService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

