package projeto_final;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dadosPessoaisM;
import controle.conexao;

public class dadosPessoaisC {
    
    conexao banco = new conexao();
    String resposta = "";

    public String CadastroAluno(dadosPessoaisM dadospessoaism) {
        try {
            banco.ConectaBD();
            String SQL = "insert into dadospessoais values("+dadospessoaism.getCoddp()+",'" + dadospessoaism.getNome() + "',"
                    + dadospessoaism.getIdade() + ","
                    + "'" + dadospessoaism.getRg() + "',"
                    + "'" + dadospessoaism.getCpf() + "',"
                    + "'" + dadospessoaism.getSexo() + "')";
            banco.getStatement().execute(SQL);
            banco.destroy();
            resposta = "OK";
        } catch (Exception erro) {
            erro.printStackTrace();
            resposta = "ERRO";
        }
        return resposta;
    }

    // Novo método para consulta
    public List<dadosPessoaisM> ConsultaAluno(String nome) {
        List<dadosPessoaisM> resultados = new ArrayList<>();
        try {
            banco.ConectaBD();
            String SQL = "SELECT * FROM dadospessoais WHERE nome LIKE '%" + nome + "%'";
            ResultSet rs = banco.getStatement().executeQuery(SQL);

            while (rs.next()) {
                dadosPessoaisM aluno = new dadosPessoaisM(
                    rs.getInt("coddp"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("rg"),
                    rs.getString("cpf"),
                    rs.getString("sexo").charAt(0)
                );
                resultados.add(aluno);
            }

            banco.destroy();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return resultados;
    }
}
