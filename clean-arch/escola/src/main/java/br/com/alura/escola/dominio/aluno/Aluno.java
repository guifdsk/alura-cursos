package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.dadosPessoais.Email;
import br.com.alura.escola.dominio.dadosPessoais.CPF;
import br.com.alura.escola.dominio.dadosPessoais.Telefone;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private CPF cpf;
    private String nome;
    private Email email;
    private String senha;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefones(String ddd, String numero){
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", email=" + email +
                '}';
    }
}

//Anotacões
// Classe Entidade - Possui um identificador que o torna único e não pode ser repetido.
