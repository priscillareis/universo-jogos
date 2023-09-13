package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.core.domain.Plataforma;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleRequest {
    private Integer id;
    @NotBlank(groups = {ValidacaoCadastro.class},
              message = "Nome do console é obrigatório")
    private String nome;
    @Max(value = 4)
    private String anoLancamento;
    @NotNull(groups = {ValidacaoCadastro.class},
              message="Plataforma do console é obrigatório")
    private Plataforma plataforma;
}
