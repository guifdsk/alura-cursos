package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.dadosPessoais.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido(){
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano",
                                                "123.123.123-16",
                                                "aluno@email.com");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.123.123-16"));

        assertEquals ("Fulano", encontrado.getNome());
        assertEquals ("aluno@email.com", encontrado.getEmail());
        assertEquals ("123.123.123-16", encontrado.getCpf());
    }
}