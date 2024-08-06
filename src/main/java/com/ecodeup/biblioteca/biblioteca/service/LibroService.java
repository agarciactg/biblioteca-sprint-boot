package com.ecodeup.biblioteca.biblioteca.service;

import com.ecodeup.biblioteca.biblioteca.dto.LibroDTO;
import com.ecodeup.biblioteca.biblioteca.model.Autor;
import com.ecodeup.biblioteca.biblioteca.repository.AutorRepository;
import com.ecodeup.biblioteca.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private FabricaLibroService fabricaLibroService;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private FabricaLibroService fabricaAutorService;

    public LibroDTO save(LibroDTO libroDTO) {
        // buscar autor
        Autor autor = autorRepository.findById(libroDTO.getIdAutor()).get();
        libroDTO.setAutorDTO(fabricaAutorService.crearAutorDTO(autor));
        return fabricaLibroService.crearLibroDTO(libroRepository.save(fabricaLibroService.crearLibro(libroDTO)))
    }

    public LibroDTO findAll() {
        return fabricaLibroService.crearLibroDTO(libroRepository.findAll());
    }

    public LibroDTO findById(Integer id) {
        return fabricaLibroService.crearLibroDTO(libroRepository.findById(id).get());
    }

    public void deleteById(Integer id) {
        libroRepository.deleteById(id);
    }

}
