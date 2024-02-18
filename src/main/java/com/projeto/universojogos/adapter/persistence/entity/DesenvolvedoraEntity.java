package com.projeto.universojogos.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="desenvolvedoras")
public class DesenvolvedoraEntity {
    @Id
    @Column(name = "id_desenvolvedora", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", nullable = false, unique = true)
    private String nome;
}
