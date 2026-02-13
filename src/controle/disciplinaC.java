/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import modelo.disciplinaM;
import java.sql.*;

/**
 *
 * @author arthur
 */
public class disciplinaC {

    conexao banco = new conexao(); 
    String resposta = "";

    // Método para cadastro de disciplina
    public String CadastroDisciplina(disciplinaM disciplina) {
        try {
            banco.ConectaBD(); 
            
            // SQL para inserção dos dados
            String SQL = "INSERT INTO disciplina (codDisciplina, nome, professor, cargaHoraria) VALUES ("
                    + disciplina.getCodDisciplina() + ", "  
                    + "'" + disciplina.getNome() + "', "   
                    + "'" + disciplina.getProfessor() + "', " 
                    + disciplina.getCargaHoraria() + ")";
            
            banco.getStatement().execute(SQL);
            banco.destroy();
            
            resposta = "OK";
        } catch (Exception erro) {
            erro.printStackTrace();
            resposta = "ERRO: " + erro.getMessage();
        }
        return resposta;
    }

    // Método para consulta de disciplina
    public ResultSet ConsultaDisciplina(int codDisciplina) {
        ResultSet resultado = null;
        try {
            banco.ConectaBD(); 
            String SQL = "SELECT * FROM disciplina WHERE codDisciplina = " + codDisciplina;
            resultado = banco.getStatement().executeQuery(SQL);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return resultado; // Retorna os dados para serem tratados pelo chamador
    }

    // Método para atualização de disciplina
    public String AtualizaDisciplina(disciplinaM disciplina) {
        try {
            banco.ConectaBD(); 
            String SQL = "UPDATE disciplina SET "
                    + "nome = '" + disciplina.getNome() + "', "
                    + "professor = '" + disciplina.getProfessor() + "', "
                    + "cargaHoraria = " + disciplina.getCargaHoraria()
                    + " WHERE codDisciplina = " + disciplina.getCodDisciplina();
            
            banco.getStatement().execute(SQL);
            banco.destroy();
            
            resposta = "OK";
        } catch (Exception erro) {
            erro.printStackTrace();
            resposta = "ERRO: " + erro.getMessage();
        }
        return resposta;
    }

    // Método para exclusão de disciplina
    public String ExcluirDisciplina(int codDisciplina) {
        try {
            banco.ConectaBD(); 
            String SQL = "DELETE FROM disciplina WHERE codDisciplina = " + codDisciplina;
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


/* CREATE TABLE disciplina (
    codDisciplina INT NOT NULL,        
    nome VARCHAR(100) NOT NULL,        
    professor VARCHAR(100) NOT NULL,   
    cargaHoraria INT NOT NULL,         
    PRIMARY KEY (codDisciplina)        
);*/
