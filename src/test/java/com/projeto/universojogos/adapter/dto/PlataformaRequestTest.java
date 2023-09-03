package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PlataformaRequestTest {

    @DisplayName("Adapter * Plataforma request correto")
    @Validated(ValidacaoCadastro.class)
    @Test
    public void cadastrarPlataformaComSucesso(){
        PlataformaRequest plataformaRequest = new PlataformaRequest(null, "Sony");

        assertNotNull(plataformaRequest);
    }

    /* TODO - Construção do teste com validator factory

    https://stackoverflow.com/questions/29069956/how-to-test-validation-annotations-of-a-class-using-junit
    https://karuppiah7890.github.io/blog/posts/validating-beans-and-testing-it/

    @DisplayName("Adapter * Plataforma request sem nome")
    @Validated(ValidacaoCadastro.class)
    @Test
    public void cadastrarPlataformaComErro() {

    }

     */

}
