package com.ecodeup.biblioteca.biblioteca.model;

import com.ecodeup.biblioteca.biblioteca.dto.AutorDTO;
import com.ecodeup.biblioteca.biblioteca.dto.LibroDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String isbn;
    private String nombre;
    private String editorial;
    private String genero;
    private int numeroPaginas;
    private BigDecimal precio;
    private LocalDate fehaEdicion;
    @ManyToOne
    private Autor autor;


    public Libro(LibroDTO libroDTO) {
        this.id = libroDTO.getId();
        this.isbn = libroDTO.getIsbn();
        this.nombre = libroDTO.getNombre();
        this.editorial = libroDTO.getEditorial();
        this.genero = libroDTO.getGenero();
        this.numeroPaginas = libroDTO.getNumeroPaginas();
        this.precio = libroDTO.getPrecio();
        this.fehaEdicion = libroDTO.getFehaEdicion();
        this.autor = new Autor(libroDTO.getAutorDTO());
    }
}
