package controle;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dadosPessoaisM;
import controle.conexao;

public class dadosPessoaisC {
    
    conexao banco = new conexao();
    String resposta = "";

    public String CadastroDadospessoais(dadosPessoaisM dadospessoaism) {
        try {
            banco.ConectaBD();
        String SQL = "INSERT INTO dadospessoais (coddp, nome, idade, rg, cpf, sexo) VALUES (" 
                + dadospessoaism.getCoddp() + ", '" 
                + dadospessoaism.getNome() + "', "
                + dadospessoaism.getIdade() + ", '"
                + dadospessoaism.getRg() + "', '"
                + dadospessoaism.getCpf() + "', '"
                + dadospessoaism.getSexo() + "')";

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
    public List<dadosPessoaisM> ConsultaDadospessoais(String nome) {
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
    public String AtualizarDadosPessoais(dadosPessoaisM dadospessoaism) {
    try {
        banco.ConectaBD();
        String SQL = "UPDATE dadospessoais SET "
                + "nome = '" + dadospessoaism.getNome() + "', "
                + "idade = " + dadospessoaism.getIdade() + ", "
                + "rg = '" + dadospessoaism.getRg() + "', "
                + "cpf = '" + dadospessoaism.getCpf() + "', "
                + "sexo = '" + dadospessoaism.getSexo() + "' "
                + "WHERE coddp = " + dadospessoaism.getCoddp();
        banco.getStatement().execute(SQL);
        banco.destroy();
        resposta = "OK";
    } catch (Exception erro) {
        erro.printStackTrace();
        resposta = "ERRO: " + erro.getMessage();
    }
    return resposta;
}
    public String ExcluirDadosPessoais(int coddp) {
    try {
        banco.ConectaBD();
        String SQL = "DELETE FROM dadospessoais WHERE coddp = " + coddp;
        banco.getStatement().execute(SQL);
        banco.destroy();
        resposta = "OK";
    } catch (Exception erro) {
        erro.printStackTrace();
        resposta = "ERRO: " + erro.getMessage();
    }
    return resposta;
}

}

/*CREATE TABLE dadosPessoais (
    coddp SERIAL PRIMARY KEY,      -- Código único, incremento automático
    nome VARCHAR(100) NOT NULL,    -- Nome da pessoa
    idade INT NOT NULL,            -- Idade da pessoa
    rg VARCHAR(20) NOT NULL,       -- RG (Registro Geral)
    cpf VARCHAR(14) NOT NULL UNIQUE, -- CPF único
    sexo CHAR(1) NOT NULL          -- Sexo (M/F)
);
*/
