
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leon Kowalski
 */
public class ControladorAluno {
    
    private ArrayList<Aluno> listaAluno;


    public ControladorAluno() {
        listaAluno = new ArrayList<>();
    }
    
    public void adicionarAluno(String nome, double nota){
        listaAluno.add(new Aluno(nota, nome));

    }
    
    public void adicionarAluno(Aluno a){
        listaAluno.add(a);

    }
    
    public void removerAluno(int i){
        listaAluno.remove(i);

    }

    public ArrayList<Aluno> getListaAluno() {
        return listaAluno;
    }
    
    public int quantidade(){
        return listaAluno.size();
    }
    
    public void carregarNomes(){
        listaAluno = new ArrayList<>();
        try {
            File f = new File("alunos");
            if(f.exists()){
                BufferedReader br = new BufferedReader(new FileReader(new File("alunos")));
                int entradas = Integer.parseInt(br.readLine());
                while(entradas > 0){
                    String nome = br.readLine();
                    double d = Double.parseDouble(br.readLine());
                    Aluno a = new Aluno(d, nome);
                    listaAluno.add(a);
                    entradas--;
                }
                br.close();
                
            }else{
                f.createNewFile();
            }
            
            
        } catch (IOException ex){
            Logger.getLogger(ControladorAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    public void salvarAlunos(){
        File f = new File("alunos");
        if(f.exists()){
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                bw.flush();
                bw.write(listaAluno.size()+ "\n");
                for(int i = 0; i < listaAluno.size();i++){
                    Aluno a = listaAluno.get(i);
                    bw.write(a.getNome() + "\n");
                    bw.write(a.getNota()+ "\n");
                }

                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int alunosAcimaMedia(){
        int a = 0;
        for(int i = 0; i < quantidade(); i++){
            if(listaAluno.get(i).getNota() > 59) a++;
        }
        return a;
    }
    
    
    
}
