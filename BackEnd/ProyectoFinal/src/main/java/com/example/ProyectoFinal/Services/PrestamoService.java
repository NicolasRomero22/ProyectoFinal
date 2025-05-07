package com.example.ProyectoFinal.Services;

import com.example.ProyectoFinal.Model.Prestamo;
import com.example.ProyectoFinal.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {
    @Autowired
    public PrestamoRepository prestamoRepository;

    public Prestamo buscar(long id_prestamo) {
        if (prestamoRepository.existsById(id_prestamo)) {
            return prestamoRepository.getById(id_prestamo);
        } else {
            throw new RuntimeException("Id no asignada " + id_prestamo);
        }
    }

    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    public void eliminar(long id_prestamo) {
        if (prestamoRepository.existsById(id_prestamo)) {
            prestamoRepository.deleteById(id_prestamo);
        } else {
            throw new RuntimeException("Id no asignada " + id_prestamo);
        }
    }

    public Prestamo actualizar(long id_prestamo, Prestamo prestamo) {
        if (prestamoRepository.existsById(id_prestamo)) {
            prestamo.setId(id_prestamo);
            return prestamoRepository.save(prestamo);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
}