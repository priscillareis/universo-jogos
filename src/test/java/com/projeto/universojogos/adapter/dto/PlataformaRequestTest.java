package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.dto.plataforma.PlataformaRequest;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PlataformaRequestTest {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @DisplayName("Adapter * Deve criar a request de cadastro com sucesso")
    @Test
    public void cadastrarPlataformaComSucesso(){
        PlataformaRequest plataformaRequest = new PlataformaRequest(0, "Sony");

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoCadastro.class);

        assertAll(
                () -> assertNotNull(plataformaRequest),
                () -> assertThat(plataformaRequest.getNome()).isEqualTo("Sony"),
                () -> assertThat(violations.size()).isEqualTo(0)
        );
    }

    @DisplayName("Adapter * Deve ter violações ao tentar criar request de cadastro sem nome")
    @Test
    public void cadastrarPlataformaComErro() {
        PlataformaRequest plataformaRequest = new PlataformaRequest(0, "");

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoCadastro.class);

        assertThat(violations.size()).isEqualTo(1);

        violations.forEach(violation -> assertThat(violation.getPropertyPath().toString()).isEqualTo("nome"));

    }

    @DisplayName("Adapter * Deve criar a request de consulta com sucesso")
    @Test
    public void consultarPlataformaComSucesso(){
        PlataformaRequest plataformaRequest = new PlataformaRequest(5, null);

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoConsulta.class);

        assertAll(
                () -> assertNotNull(plataformaRequest),
                () -> assertThat(plataformaRequest.getId()).isEqualTo(5),
                () -> assertThat(violations.size()).isEqualTo(0)
        );
    }

    @DisplayName("Adapter * Deve ter violações ao tentar criar request de consulta sem id")
    @Test
    public void consultarPlataformaComErro() {
        PlataformaRequest plataformaRequest = new PlataformaRequest(0, "Xbox");

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoConsulta.class);

        assertThat(violations.size()).isEqualTo(1);

        violations.forEach(violation -> assertThat(violation.getPropertyPath().toString()).isEqualTo("id"));

    }

    @DisplayName("Adapter * Deve criar a request de atualizar com sucesso")
    @Test
    public void atualizarPlataformaComSucesso(){
        PlataformaRequest plataformaRequest = new PlataformaRequest(12, "Nintendo");

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoAtualizacao.class);

        assertAll(
                () -> assertNotNull(plataformaRequest),
                () -> assertThat(plataformaRequest.getId()).isEqualTo(12),
                () -> assertThat(plataformaRequest.getNome()).isEqualTo("Nintendo"),
                () -> assertThat(violations.size()).isEqualTo(0)
        );
    }

    @DisplayName("Adapter * Deve ter violações ao tentar criar request de atualizar sem id e sem nome")
    @Test
    public void atualizarPlataformaComErro() {
        PlataformaRequest plataformaRequest = new PlataformaRequest(0, null);

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoAtualizacao.class);

        assertThat(violations.size()).isEqualTo(2);
    }

    @DisplayName("Adapter * Deve ter violações ao tentar criar request de atualizar sem id")
    @Test
    public void atualizarPlataformaComErroId() {
        PlataformaRequest plataformaRequest = new PlataformaRequest(0, "nintendo");

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoAtualizacao.class);

        assertThat(violations.size()).isEqualTo(1);

        violations.forEach(violation -> assertThat(violation.getPropertyPath().toString()).isEqualTo("id"));
    }

    @DisplayName("Adapter * Deve ter violações ao tentar criar request de atualizar sem nome")
    @Test
    public void atualizarPlataformaComErroNome() {
        PlataformaRequest plataformaRequest = new PlataformaRequest(20, "");

        Set<ConstraintViolation<PlataformaRequest>> violations =  validator.validate(plataformaRequest,
                ValidacaoAtualizacao.class);

        assertThat(violations.size()).isEqualTo(1);

        violations.forEach(violation -> assertThat(violation.getPropertyPath().toString()).isEqualTo("nome"));
    }
}
