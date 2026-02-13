/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author arthur
 */
public class disciplinaM {
    private int codDisciplina;
    private String nome;
    private String professor;
    private int cargaHoraria;

    public disciplinaM(int codDisciplina, String nome, String professor, int cargaHoraria) {
        this.codDisciplina = codDisciplina;
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    
    
    
    
}
