/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author arthur
 */
public class semestreM {
    private int numSemestre;
    private int codcurso;
    private int codDisciplina;

    public semestreM(int numSemestre, int codcurso, int codDisciplina) {
        this.numSemestre = numSemestre;
        this.codcurso = codcurso;
        this.codDisciplina = codDisciplina;
    }

    public int getNumSemestre() {
        return numSemestre;
    }

    public void setNumSemestre(int numSemestre) {
        this.numSemestre = numSemestre;
    }

    public int getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(int codcurso) {
        this.codcurso = codcurso;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }
    
    
    
}
