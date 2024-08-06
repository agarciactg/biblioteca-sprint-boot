package com.ecodeup.biblioteca.biblioteca.service;

import com.ecodeup.biblioteca.biblioteca.dto.LibroDTO;
import com.ecodeup.biblioteca.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;

public class FabricaLibroService {
    public Libro crearLibro(LibroDTO libroDTO) {
        return new Libro(libroDTO);
    }
    public LibroDTO crearLibroDTO(Libro libro) {
        return new LibroDTO(libro);
    }
    public List<LibroDTO> crearLibrosDTO(List<Libro> libros) {
        List<LibroDTO> libroDTOS = new ArrayList<>();
        libros.stream().forEach(
                libro -> {
                    libroDTOS.add(new LibroDTO());
                }
        );
        return libroDTOS;
    }
}
