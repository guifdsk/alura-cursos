package br.com.alura.escola.dominio.dadosPessoais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void naoDeveriaCadastrarEsseCPF(){
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));

        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));

        assertThrows(IllegalArgumentException.class,
                () -> new CPF("12312312315"));

        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123.123.123-!5"));
    }

    @Test
    void criarCPFValido(){
        CPF cpf = new CPF("123.456.789-09");
    }

}