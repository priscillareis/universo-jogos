package com.projeto.universojogos.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuarios")
public class UsuarioEntity {
    @Id
    @Column(name="id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="usuario")
    private String usuario;

    @Column(name="senha")
    private String senha;

    @Column(name="status")
    private String status;
}
