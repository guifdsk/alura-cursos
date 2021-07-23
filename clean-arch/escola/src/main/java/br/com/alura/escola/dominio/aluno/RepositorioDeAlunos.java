package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.dadosPessoais.CPF;
import br.com.alura.escola.dominio.exception.AlunoNaoEcontrado;

import java.util.List;

public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf) throws AlunoNaoEcontrado;

    List<Aluno> listarTodosAlunosMatriculados();
}
