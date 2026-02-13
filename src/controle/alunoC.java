/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelo.alunoM;
import java.sql.*;

/**
 *
 * @author arthur
 */
public class alunoC {

    conexao banco = new conexao(); 
    String resposta = "";

    // Método para cadastro de aluno
  public String CadastroAluno(alunoM aluno) {
    try {
        banco.ConectaBD();

        // Valida se o curso existe antes de inserir o aluno
        String consultaCurso = "SELECT COUNT(*) FROM curso WHERE codcurso = " + aluno.getCodCurso();
        ResultSet rs = banco.getStatement().executeQuery(consultaCurso);

        if (rs.next() && rs.getInt(1) == 0) {
            // Se o curso não existir
            resposta = "Erro: Curso não encontrado!";
            banco.destroy();
            return resposta;
        }

        // Se o curso existe, insere o aluno
        String SQL = "INSERT INTO aluno (ra, codCurso, rg, cpf, sexo) VALUES ("
                + aluno.getRa() + ", " 
                + aluno.getCodCurso() + ", " 
                + "'" + aluno.getDadospessoaism().getRg() + "', " 
                + "'" + aluno.getDadospessoaism().getCpf() + "', " 
                + "'" + aluno.getDadospessoaism().getSexo() + "')";
        
        banco.getStatement().execute(SQL);
        banco.destroy();
        
        resposta = "OK";
    } catch (Exception erro) {
        erro.printStackTrace();
        resposta = "ERRO: " + erro.getMessage();
    }
    return resposta;
}


    // Método para consulta de aluno
    public ResultSet ConsultaAluno(int ra) {
        ResultSet resultado = null;
        try {
            banco.ConectaBD(); 
            String SQL = "SELECT * FROM aluno WHERE ra = " + ra;
            resultado = banco.getStatement().executeQuery(SQL);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return resultado; // Retorna o resultado para ser tratado pelo chamador
    }

    // Método para atualização de aluno
    public String AtualizaAluno(alunoM aluno) {
        try {
            banco.ConectaBD(); 
            String SQL = "UPDATE aluno SET "
                    + "codCurso = " + aluno.getCodCurso() + ", "
                    + "rg = '" + aluno.getDadospessoaism().getRg() + "', "
                    + "cpf = '" + aluno.getDadospessoaism().getCpf() + "', "
                    + "sexo = '" + aluno.getDadospessoaism().getSexo() + "' "
                    + "WHERE ra = " + aluno.getRa();
            
            banco.getStatement().execute(SQL);
            banco.destroy();
            
            resposta = "OK";
        } catch (Exception erro) {
            erro.printStackTrace();
            resposta = "ERRO: " + erro.getMessage();
        }
        return resposta;
    }

    // Método para exclusão de aluno
    public String ExcluirAluno(int ra) {
        try {
            banco.ConectaBD(); 
            String SQL = "DELETE FROM aluno WHERE ra = " + ra;
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

/* CREATE TABLE aluno (
    ra INT NOT NULL,            )
    codCurso INT NOT NULL,      
    rg VARCHAR(20) NOT NULL,    
    cpf VARCHAR(14) NOT NULL,   
    sexo CHAR(1) NOT NULL,     
    PRIMARY KEY (ra)            
);
*/