package com.projeto.universojogos.adapter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int codigo;
    private String classe;
    private String mensagem;
}
