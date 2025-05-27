package com.ygor.ApelidoRomes.models;
import jakarta.persistence.*;

@Entity
@Table(name = "apelido")
public class ApelidoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String apelido;

    private String autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
