/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import modelo.semestreM;
import java.sql.*;

/**
 *
 * @author arthur
 */
public class semestreC {

    conexao banco = new conexao(); // Conexão com o banco de dados
    String resposta = "";

    // Método para cadastro de semestre
    public String CadastroSemestre(semestreM semestre) {
        try {
            banco.ConectaBD(); // Conecta ao banco
            
            // SQL para inserção dos dados
            String SQL = "INSERT INTO semestre (numSemestre, codCurso, codDisciplina) VALUES ("
                    + semestre.getNumSemestre() + ", "  // numSemestre (inteiro)
                    + semestre.getCodcurso() + ", "     // codCurso (inteiro)
                    + semestre.getCodDisciplina() + ")"; // codDisciplina (inteiro)
            
            // Executa o SQL
            banco.getStatement().execute(SQL);
            
            // Fecha a conexão
            banco.destroy();
            
            resposta = "OK";
        } catch (Exception erro) {
            erro.printStackTrace();
            resposta = "ERRO: " + erro.getMessage();
        }
        return resposta;
    }

    // Método para consulta de semestre
    public ResultSet ConsultaSemestre(int numSemestre) {
        ResultSet resultado = null;
        try {
            banco.ConectaBD(); // Conecta ao banco
            
            // SQL para consulta dos dados
            String SQL = "SELECT * FROM semestre WHERE numSemestre = " + numSemestre;
            resultado = banco.getStatement().executeQuery(SQL);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return resultado; // Retorna o resultado para ser tratado pelo chamador
    }

    // Método para atualização de semestre
    public String AtualizaSemestre(semestreM semestre) {
        try {
            banco.ConectaBD(); // Conecta ao banco
            
            // SQL para atualização dos dados
            String SQL = "UPDATE semestre SET "
                    + "codCurso = " + semestre.getCodcurso() + ", "
                    + "codDisciplina = " + semestre.getCodDisciplina() + " "
                    + "WHERE numSemestre = " + semestre.getNumSemestre();
            
            // Executa o SQL
            banco.getStatement().execute(SQL);
            
            // Fecha a conexão
            banco.destroy();
            
            resposta = "OK";
        } catch (Exception erro) {
            erro.printStackTrace();
            resposta = "ERRO: " + erro.getMessage();
        }
        return resposta;
    }

    // Método para exclusão de semestre
    public String ExcluirSemestre(int numSemestre) {
        try {
            banco.ConectaBD(); // Conecta ao banco
            
            // SQL para exclusão dos dados
            String SQL = "DELETE FROM semestre WHERE numSemestre = " + numSemestre;
            
            // Executa o SQL
            banco.getStatement().execute(SQL);
            
            // Fecha a conexão
            banco.destroy();
            
            resposta = "OK";
        } catch (Exception erro) {
            erro.printStackTrace();
            resposta = "ERRO: " + erro.getMessage();
        }
        return resposta;
    }
}





/*CREATE TABLE semestre (
    numSemestre INT NOT NULL,         -- Número do semestre
    codCurso INT NOT NULL,            -- Código do curso relacionado
    codDisciplina INT NOT NULL,       -- Código da disciplina relacionada
    PRIMARY KEY (numSemestre, codCurso, codDisciplina),  -- Chave primária composta
    FOREIGN KEY (codCurso) REFERENCES curso(codCurso),    -- Relaciona com a tabela curso
    FOREIGN KEY (codDisciplina) REFERENCES disciplina(codDisciplina)  -- Relaciona com a tabela disciplina
);
*/