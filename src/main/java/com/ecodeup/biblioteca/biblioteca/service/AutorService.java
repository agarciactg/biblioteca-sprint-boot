package com.ecodeup.biblioteca.biblioteca.service;

import com.ecodeup.biblioteca.biblioteca.dto.AutorDTO;
import com.ecodeup.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutorService {
    @Autowired
    private FabricaAutorService fabricaAutorService;

    @Autowired
    private AutorRepository autorRepository;

    public AutorDTO save(AutorDTO autorDTO) {
        return fabricaAutorService.crearAutoresDTO(autorRepository.save(fabricaAutorService.crearAutor(autorDTO)));
    }

    public List<AutorDTO> findAll(){
        return fabricaAutorService.crearAutoresDTO(autorRepository.findAll());
    }

    public AutorDTO findById(Integer id){
        return fabricaAutorService.crearAutoresDTO(autorRepository.findById(id).get())
    }

    public void deleteById(Integer id) {
        autorRepository.deleteById(id);
    }
}
