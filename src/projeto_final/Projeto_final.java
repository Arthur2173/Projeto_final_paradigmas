/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto_final;


import controle.alunoC;
import controle.cursoC;
import controle.dadosPessoaisC;
import visao.dadospessoaisV;
import modelo.dadosPessoaisM;
import java.util.List;
import modelo.alunoM;
import modelo.cursoM;
import modelo.enderecoM;
import visao.enderecoV;


/**
 *
 * @author ra177462
 */
public class Projeto_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Cadastro dadospessoais
        dadosPessoaisM dados = new dadosPessoaisM(2,"arthur", 20, "09204", "390284", 'm');
        dadosPessoaisC cadastro = new dadosPessoaisC();
        enderecoM end  = new enderecoM(1, 467, "ioewjoj", "kjdhf", "ms", "jdkhfkj");
        ///String resultadoCadastro = cadastro.CadastroAluno(dados);
        //System.out.println("Resultado do cadastro: " + resultadoCadastro);
        
        /*dadospessoaisV main=new dadospessoaisV();
        main.setVisible(true);*/

        // Consulta de alunos
        List<dadosPessoaisM> dadosPessoaisEncontrados = cadastro.ConsultaDadospessoais("ana");
        System.out.println("Resultados da consulta:");
        for (dadosPessoaisM dadosPessoaisEncontrado : dadosPessoaisEncontrados) {
            System.out.println("coddp: "+dadosPessoaisEncontrado .getCoddp());
            System.out.println("Nome: " + dadosPessoaisEncontrado .getNome());
            System.out.println("Idade: " + dadosPessoaisEncontrado .getIdade());
            System.out.println("RG: " + dadosPessoaisEncontrado .getRg());
            System.out.println("CPF: " + dadosPessoaisEncontrado .getCpf());
            System.out.println("Sexo: " + dadosPessoaisEncontrado .getSexo());
            System.out.println("-----------------------");
        }
        

        /*enderecoV main = new enderecoV();
        main.setVisible(true);*/
        
        
        //criar primeiro o curso depois aluno
        /*cursoM cursoaluno = new cursoM(1890,"engenharia de computação", "noturno");
        cursoC cursonoturno = new cursoC();
        String Resultado = cursonoturno.CadastroCurso(cursoaluno);
        System.out.println("Resultado do cadastro: "+ Resultado);*/
        
        /*alunoM aluno = new alunoM(177462, 1890, dados,end);
        alunoC alcadastro = new  alunoC();
        String resultadoAluno = alcadastro.CadastroAluno(aluno);
        System.out.println("Resultado do cadastro: " + resultadoAluno);*/
        
        //cadastro.ExcluirDadosPessoais(1);
        //cadastro.AtualizarDadosPessoais(dados);
        
        
        
    }     
        
}
