/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author arthur
 */
public class alunoM {
    
    private int ra;
    private int codCurso;
    private dadosPessoaisM dadospessoaism;
    private enderecoM enderecom;

    public alunoM(int ra, int codCurso, dadosPessoaisM dadospessoaism, enderecoM enderecom) {
        this.ra = ra;
        this.codCurso = codCurso;
        this.dadospessoaism = dadospessoaism;
        this.enderecom = enderecom;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public dadosPessoaisM getDadospessoaism() {
        return dadospessoaism;
    }

    public void setDadospessoaism(dadosPessoaisM dadospessoaism) {
        this.dadospessoaism = dadospessoaism;
    }

    public enderecoM getEnderecom() {
        return enderecom;
    }

    public void setEnderecom(enderecoM enderecom) {
        this.enderecom = enderecom;
    }
    
    
    
    
    
    
}
