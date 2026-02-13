/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ra177462
 */
public class enderecoM {
    private int codend;
    private int numero;
    private String cep;
    private String bairro;
    private String estado;
    private String rua;

    public enderecoM(int codend, int numero, String cep, String bairro, String estado, String rua) {
        this.codend = codend;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.rua = rua;
    }

    public int getCodend() {
        return codend;
    }

    public void setCodend(int codend) {
        this.codend = codend;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    
    
    
    
}
