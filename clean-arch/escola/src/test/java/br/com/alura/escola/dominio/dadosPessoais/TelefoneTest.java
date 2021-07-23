package br.com.alura.escola.dominio.dadosPessoais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void numeroDeTelefonesInvalidos(){
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("15"," "));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("15","9999999999"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("15","9999999"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("1","99999999"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("111","99999999"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("11","999gg999"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("11","99999999"));
    }

    @Test
    void numeroTelefoneCorreto(){

        Telefone telefone1 = new Telefone("15", "9999-9999");
    }

}