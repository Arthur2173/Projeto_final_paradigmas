/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ra177462
 */
public class dadosPessoaisM {
    private int coddp;
    private String nome;
    private int idade;
    private String rg;
    private String cpf;
    private char sexo;
    
    public dadosPessoaisM() {}


    public dadosPessoaisM(int coddp, String nome, int idade, String rg, String cpf, char sexo) {
        this.coddp = coddp;
        this.nome = nome;
        this.idade = idade;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public int getCoddp() {
        return coddp;
    }

    public void setCoddp(int coddp) {
        this.coddp = coddp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
    
    
}
