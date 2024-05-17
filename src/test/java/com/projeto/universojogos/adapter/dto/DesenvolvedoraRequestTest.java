package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.dto.desenvolvedora.DesenvolvedoraRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
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
public class DesenvolvedoraRequestTest {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @DisplayName("Adapter * Deve validar as requests da DesenvolvedoraRequest")
    @ParameterizedTest(name = "{4}")
    @MethodSource("getDesenvolvedoraRequest")
    public void validacaoObjetoDesenvolvedoraRequest(DesenvolvedoraRequest desenvolvedoraRequest,
                                                     int quantidadeErrosEsperados, Class classe,
                                                     List<String> camposViolados, String cenario){
        Set<ConstraintViolation<DesenvolvedoraRequest>> violations =  validator.validate(desenvolvedoraRequest,
                classe);

        if(camposViolados.isEmpty()){
            assertAll(
                    () -> assertNotNull(desenvolvedoraRequest),
                    () -> assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados)
            );
        }else{
            assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados);

            violations.forEach(violation ->
                    assertTrue(camposViolados.contains(violation.getPropertyPath().toString())));
        }
    }

    public static Collection<Object[]> getDesenvolvedoraRequest(){
        return Arrays.asList(new Object[][]{
                {new DesenvolvedoraRequest(5, "Game Freak"), 0, ValidacaoCadastro.class, List.of(),
                        "Deve criar a request com sucesso"},
                {new DesenvolvedoraRequest(6, ""), 1, ValidacaoCadastro.class, List.of("nome"),
                        "Deve ter violações ao tentar criar request de cadastro sem nome"},

                {new DesenvolvedoraRequest(7, null), 0, ValidacaoConsulta.class, List.of(),
                        "Deve criar a request de consulta com sucesso"},
                {new DesenvolvedoraRequest(0, "Santa Monica"), 1, ValidacaoConsulta.class, List.of("id"),
                        "Deve ter violações ao tentar criar request de consulta sem id"},

                {new DesenvolvedoraRequest(12, "Guerrilha"), 0, ValidacaoAtualizacao.class, List.of(),
                        "Deve criar a request de atualizar com sucesso"},
                {new DesenvolvedoraRequest(0, null), 2, ValidacaoAtualizacao.class, List.of("id","nome"),
                        "Deve ter violações ao tentar criar request de atualizar sem id e sem nome"},
                {new DesenvolvedoraRequest(0, "Guerrilha"), 1, ValidacaoAtualizacao.class, List.of("id"),
                        "Deve ter violações ao tentar criar request de atualizar sem id"},
                {new DesenvolvedoraRequest().setId(10).setNome(""), 1, ValidacaoAtualizacao.class, List.of("nome"),
                        "Deve ter violações ao tentar criar request de atualizar sem nome"}
        });
    }
}
