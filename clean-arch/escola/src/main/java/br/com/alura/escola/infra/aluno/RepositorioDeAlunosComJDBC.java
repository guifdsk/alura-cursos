package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.dadosPessoais.CPF;
import br.com.alura.escola.dominio.dadosPessoais.Email;
import br.com.alura.escola.dominio.dadosPessoais.Telefone;
import br.com.alura.escola.dominio.exception.AlunoNaoEcontrado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone: aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        }
        catch(SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf){
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE CPF = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if(!encontrou){
                throw new AlunoNaoEcontrado(cpf);
            }
            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email@email.com"));
            Aluno encontrado = new Aluno (cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.adicionarTelefones(ddd, numero);
            }

            return encontrado;

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return null;
    }
}
