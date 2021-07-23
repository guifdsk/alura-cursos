package br.com.alura.escola.dominio.exception;

import br.com.alura.escola.dominio.dadosPessoais.CPF;

public class AlunoNaoEcontrado extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public AlunoNaoEcontrado(CPF cpf){
        super("Aluno nao encontrado com CPF: " + cpf.getNumero());
    }
}
