package com.projeto.universojogos.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "plataformas")
public class PlataformaEntity {
    @Id
    @Column(name = "id_plataforma", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", nullable = false, unique = true)
    private String nome;
}
