/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelo.cursoM;
import java.sql.*;

/**
 *
 * @author arthur
 */
public class cursoC {

    conexao banco = new conexao(); // Conexão com o banco de dados
    String resposta = "";

    // Método para cadastro de curso
    public String CadastroCurso(cursoM curso) {
        try {
            banco.ConectaBD(); // Conecta ao banco
            
            // SQL para inserção dos dados
            String SQL = "INSERT INTO curso (codcurso, nome, turno) VALUES ("
                    + curso.getCodcurso() + ", " 
                    + "'" + curso.getNome() + "', " 
                    + "'" + curso.getTurno() + "')";
            
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

    // Método para consulta de curso
    public ResultSet ConsultaCurso(int codcurso) {
        ResultSet resultado = null;
        try {
            banco.ConectaBD(); // Conecta ao banco
            String SQL = "SELECT * FROM curso WHERE codcurso = " + codcurso;
            resultado = banco.getStatement().executeQuery(SQL);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return resultado; // Retorna o resultado para ser tratado pelo chamador
    }

    // Método para atualização de curso
    public String AtualizaCurso(cursoM curso) {
        try {
            banco.ConectaBD(); // Conecta ao banco
            
            // SQL para atualização dos dados
            String SQL = "UPDATE curso SET "
                    + "nome = '" + curso.getNome() + "', "
                    + "turno = '" + curso.getTurno() + "' "
                    + "WHERE codcurso = " + curso.getCodcurso();
            
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

    // Método para exclusão de curso
    public String ExcluirCurso(int codcurso) {
        try {
            banco.ConectaBD(); // Conecta ao banco
            
            // SQL para exclusão dos dados
            String SQL = "DELETE FROM curso WHERE codcurso = " + codcurso;
            
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

/* CREATE TABLE curso (
    codcurso INT NOT NULL,         
    nome VARCHAR(100) NOT NULL,   
    turno VARCHAR(20) NOT NULL,    
    PRIMARY KEY (codcurso)         
);
*/