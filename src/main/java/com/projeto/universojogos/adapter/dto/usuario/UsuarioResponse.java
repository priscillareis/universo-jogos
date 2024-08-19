package com.projeto.universojogos.adapter.dto.usuario;

import com.projeto.universojogos.core.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private int id;
    private String usuario;
    private Status status;
}
