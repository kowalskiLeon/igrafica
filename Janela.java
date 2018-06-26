/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.stage.Screen;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Leon Kowalski
 */
public class Janela {

        ControladorAluno controlador;
    
    
        public void desenhar() {
        //criando o jframe
        controlador = new ControladorAluno();
        JFrame jframe = new JFrame("Interface Gráfica");
        jframe.setSize(500, 640); //Define o tamanho de Jframes, pode ser utilzado em vários componentes
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define a operação na hora que fechar a janela do jframe
        
        //Centralizando a Janela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation(dim.width/2-jframe.getSize().width/2, dim.height/2-jframe.getSize().height/2);
        
        //Cria um Jpanel que conterá os componentes da nossa interface
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        
        JButton jButtonAdd = new JButton("Adicionar");
        jButtonAdd.setBounds(10, 5, 100, 30);
        jpanel.add(jButtonAdd);
        
        
        jframe.add(jpanel);
        
        //Mostrar a tela - Set visible torna a tela vísivel (well duh.)
        jframe.setVisible(true);
        
        
        

    }
    
    
    public void adicionarAluno(JTextField nome, JTextField nota , List l, JComboBox jc, JPanel jp){
        if(nome.getText().isEmpty() || nota.getText().isEmpty()){
            
        }else{
            String n = nome.getText();
            double d = Double.parseDouble(nota.getText());
            nome.setText("");
            nota.setText("");
            controlador.adicionarAluno(n,d);
            controlador.salvarAlunos();
            atualizarTela(l, jc, jp);
        }
        
        
    }
    
    public void removerAluno(List l, JComboBox jc, JPanel jp){
        if(controlador.quantidade() > 0){
            controlador.removerAluno(jc.getSelectedIndex());
            controlador.salvarAlunos();
            atualizarTela(l, jc , jp);
        }
    }
    
    public void atualizarTela(List l, JComboBox j, JPanel jp){
        l.removeAll();
        j.removeAllItems();
        controlador.carregarNomes();
        for(int i =0; i < controlador.quantidade(); i++){
            Aluno temp = controlador.getListaAluno().get(i);  
            l.add(temp.retornarAluno());
            j.addItem(temp.getNome());
        }
        exibirMedia(jp);
        
    }
    
   public void exibirMedia(JPanel jp){
        if(controlador.quantidade() > 0){
            Graphics2D g2d = (Graphics2D) jp.getGraphics();
            int acima = controlador.alunosAcimaMedia();
            int max = controlador.quantidade();
            int novo = (acima*jp.getWidth())/max;
            g2d.setColor(Color.blue);
            g2d.fillRect(0, 0, novo, jp.getHeight());
            g2d.setColor(Color.red);
            g2d.fillRect(novo + 1, 0, jp.getWidth() - novo, jp.getHeight());
            jp.paintComponents(g2d);
        }
        
    }
    
}
