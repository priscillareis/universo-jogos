package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlataformaRequest {
    @NotNull(groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class}, message = "ID é obrigatório")
    private Integer id;
    @NotBlank(groups = {ValidacaoCadastro.class, ValidacaoAtualizacao.class},
            message = "Nome da plataforma é obrigatório")
    private String nome;
}
