/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Leon Kowalski
 */
public class Aluno {
    
    private double nota;
    private String nome;

    public Aluno(double nota, String nome) {
        this.nota = nota;
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String retornarAluno(){
        return nome + " - Nota: " + nota;
    }
    
    
}
