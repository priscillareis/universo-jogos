package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.dto.plataforma.PlataformaRequest;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PlataformaRequestTest {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @DisplayName("Adapter * Deve validar as requests da PlataformaRequest")
    @ParameterizedTest(name = "{4}")
    @MethodSource("getPlataformaRequest")
    public void validacaoObjetoPlataformaRequest(PlataformaRequest plataformaRequest, int quantidadeErrosEsperados,
                                                 Class classe, List<String> camposViolados, String cenario){
        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                classe);

        if(camposViolados.isEmpty()){
            assertAll(
                    () -> assertNotNull(plataformaRequest),
                    () -> assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados)
            );
        }else{
            assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados);

            violations.forEach(violation ->
                    assertTrue(camposViolados.contains(violation.getPropertyPath().toString())));
        }
    }

    public static Collection<Object[]> getPlataformaRequest(){
        return Arrays.asList(new Object[][]{
                {new PlataformaRequest(5, "Sony"), 0, ValidacaoCadastro.class, List.of(),
                        "Deve criar a request com sucesso"},
                {new PlataformaRequest(6, ""), 1, ValidacaoCadastro.class, List.of("nome"),
                        "Deve ter violações ao tentar criar request de cadastro sem nome"},

                {new PlataformaRequest(7, null), 0, ValidacaoConsulta.class, List.of(),
                        "Deve criar a request de consulta com sucesso"},
                {new PlataformaRequest(0, "Xbox"), 1, ValidacaoConsulta.class, List.of("id"),
                        "Deve ter violações ao tentar criar request de consulta sem id"},

                {new PlataformaRequest(12, "Nintendo"), 0, ValidacaoAtualizacao.class, List.of(),
                        "Deve criar a request de atualizar com sucesso"},
                {new PlataformaRequest(0, null), 2, ValidacaoAtualizacao.class, List.of("id","nome"),
                        "Deve ter violações ao tentar criar request de atualizar sem id e sem nome"},
                {new PlataformaRequest(0, "Nintendo"), 1, ValidacaoAtualizacao.class, List.of("id"),
                        "Deve ter violações ao tentar criar request de atualizar sem id"},
                {new PlataformaRequest().setId(10).setNome(""), 1, ValidacaoAtualizacao.class, List.of("nome"),
                        "Deve ter violações ao tentar criar request de atualizar sem nome"}
        });
    }
}
