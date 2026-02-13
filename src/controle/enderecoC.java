/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.enderecoM;

/**
 *
 * @author ra177462
 */
public class enderecoC {
    
    conexao banco = new conexao();
    String resposta = "";

    public String CadastroEndereco(enderecoM enderecom) {
    try {
        banco.ConectaBD();
String SQL = "INSERT INTO endereco (codend, numero, cep, bairro, estado, rua) VALUES ("
            + enderecom.getCodend() + ", "
            + enderecom.getNumero() + ", "
            + "'" + enderecom.getCep() + "', "
            + "'" + enderecom.getBairro() + "', "
            + "'" + enderecom.getEstado() + "', "
            + "'" + enderecom.getRua() + "')";
        banco.getStatement().execute(SQL);
        banco.destroy();
        resposta = "OK";
    } catch (Exception erro) {
        erro.printStackTrace();
        resposta = "ERRO";
    }
    return resposta;
}

    
        public List<enderecoM> ConsultaEndereco(int codend) {
        List<enderecoM> resultadosEnd = new ArrayList<>();
        try {
            banco.ConectaBD();
            String SQL = "SELECT * FROM endereco WHERE codend = " + codend;
            ResultSet rs = banco.getStatement().executeQuery(SQL);

            while (rs.next()) {
                enderecoM endereco = new enderecoM(
                    rs.getInt("codend"),
                    rs.getInt("numero"),
                    rs.getString("cep"),
                    rs.getString("bairro"),
                    rs.getString("estado"),
                    rs.getString("rua")
                );
                resultadosEnd.add(endereco);
            }

            banco.destroy();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return resultadosEnd;
    }
        
public String AtualizarEndereco(enderecoM enderecom) {
    try {
        banco.ConectaBD();
        String SQL = "UPDATE endereco SET "
                + "numero = " + enderecom.getNumero() + ", "
                + "cep = '" + enderecom.getCep() + "', "
                + "bairro = '" + enderecom.getBairro() + "', "
                + "estado = '" + enderecom.getEstado() + "', "
                + "rua = '" + enderecom.getRua() + "' "
                + "WHERE codend = " + enderecom.getCodend();
        banco.getStatement().execute(SQL);
        banco.destroy();
        resposta = "OK";
    } catch (Exception erro) {
        erro.printStackTrace();
        resposta = "ERRO: " + erro.getMessage();
    }
    return resposta;
}
public String ExcluirEndereco(int codend) {
    try {
        banco.ConectaBD();
        String SQL = "DELETE FROM endereco WHERE codend = " + codend;
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



/*CREATE TABLE endereco (
    codend SERIAL PRIMARY KEY,    -- Código único, incremento automático
    numero INT NOT NULL,          -- Número do endereço
    cep VARCHAR(10) NOT NULL,     -- Código postal (CEP)
    bairro VARCHAR(50) NOT NULL,  -- Nome do bairro
    estado VARCHAR(2) NOT NULL,   -- Sigla do estado (ex.: SP)
    rua VARCHAR(100) NOT NULL     -- Nome da rua
);*/