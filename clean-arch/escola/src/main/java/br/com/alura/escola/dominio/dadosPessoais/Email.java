package br.com.alura.escola.dominio.dadosPessoais;

public class Email {

    private String endereco;

    public Email(String endereco) {
        if(endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){

            throw new IllegalArgumentException("E-mail inválido");

        }

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return endereco;
    }
}

//Anotacões
// Classe Value Object - Os objetos podem não posuir identificadores únicos