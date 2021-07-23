package br.com.alura.escola.dominio.dadosPessoais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecesInvalisdos(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("emailinvalido"));
    }

    @Test
    void criarEmailValido(){
        Email novoEmail1 = new Email("guilherme@email.com");
        Email novoEmail2 = new Email("guilherme_teste@email.com");
        Email novoEmail3 = new Email("guilherme123@email.com");
        Email novoEmail4 = new Email("guilhermeMAIUSCULO@email.com.br");
    }

}