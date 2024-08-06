package com.ecodeup.biblioteca.biblioteca.dto;

import com.ecodeup.biblioteca.biblioteca.model.Autor;
import com.ecodeup.biblioteca.biblioteca.model.Libro;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LibroDTO {
    private Integer id;
    private String isbn;
    private String nombre;
    private String editorial;
    private String genero;
    private int numeroPaginas;
    private BigDecimal precio;
    private LocalDate fehaEdicion;
    private AutorDTO autorDTO;
    private Integer idAutor;

    public LibroDTO(Libro libro) {
        this.nombre = libro.getNombre();
        this.isbn = libro.getIsbn();
        this.id = libro.getId();
        this.editorial = libro.getEditorial();
        this.genero = libro.getGenero();
        this.numeroPaginas = libro.getNumeroPaginas();
        this.fehaEdicion = libro.getFehaEdicion();
        this.precio = libro.getPrecio();
        this.autorDTO = new AutorDTO(libro.getAutor());
    }
}
