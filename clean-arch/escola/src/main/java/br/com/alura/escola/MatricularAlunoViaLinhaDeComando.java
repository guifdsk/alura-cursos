package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "132.456.789-16";
        String email = "fulano@email.com";

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricular.executa(new MatricularAlunoDto(  nome,
                                                    cpf,
                                                    email)
        );

        nome = "Test";
        cpf = "123.123.123-16";
        email = "fulano@email.com";

        matricular.executa(new MatricularAlunoDto(  nome,
                cpf,
                email)
        );

        matricular.getLista();
    }
}
