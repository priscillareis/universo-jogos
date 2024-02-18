package com.projeto.universojogos.adapter.dto.console;

import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.dto.plataforma.PlataformaRequest;
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
    private int id;

    @NotBlank(groups = {ValidacaoCadastro.class},
              message = "Nome do console é obrigatório")
    private String nome;

    @Max(value = 4)
    private String anoLancamento;

    @NotNull(groups = {ValidacaoCadastro.class},
              message="Plataforma do console é obrigatório")
    private PlataformaRequest plataforma;
}
