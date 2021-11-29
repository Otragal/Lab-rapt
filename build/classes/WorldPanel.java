/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpoch
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
//A classe vai extender a JPanel

public class WorldPanel extends JPanel implements WorldChangeListener, KeyListener {

    /*O método pinta os componentes, desenhar a imagem
     **será também o observador, se o mundo mudar, ele também tem que pintar
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.darkGray);

        Setor w = Setor.getInstance();
        for(Objetos ob : w.obj){
            g.drawImage(ob.image, ob.x, ob.y, this);
            g.setColor(Color.yellow);
            g.drawRect(ob.corpo.x, ob.corpo.y, ob.corpo.width, ob.corpo.height);
        }
        for (Agent a : w.agents) {
            g.drawImage(a.image, a.x, a.y, this);
            g.drawRect(a.corpo.x, a.corpo.y, a.corpo.width, a.corpo.height);
        }

    }

    @Override
    public void worldHasChanged() {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println(ke.getKeyCode());
        Setor w = Setor.getInstance();
        try{
        switch (ke.getKeyCode()) {

            case 39://Seta para Direita
                    w.movePlayer(2, 0, 0);
                    
                break;
            case 37://Seta para Esquerda
               
                    w.movePlayer(-2, 0, 1);
                
                break;
            case 38://Seta para Cima
                
                    w.movePlayer(0, -2, 2);
                
                break;
            case 40://Seta para Baixo
                
                    w.movePlayer(0, 2,3);
                    w.stayMoving();
                break;
            case 16://Tecla Shift
                    
                break;
            case 32://Tecla Espaço

                break;
            case 88://Tecla X
                System.exit(0);
                break;
            case 81://Tecla Q

        }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        Setor w = Setor.getInstance();
        try{
        switch (ke.getKeyCode()) {

            case 39://Seta para Direita
                    w.movePlayer(2, 0 , 0);
                break;
            case 37://Seta para Esquerda
               
                    w.movePlayer(-2, 0, 1);
                
                break;
            case 38://Seta para Cima
                
                    w.movePlayer(0, -2, 0);
                
                break;
            case 40://Seta para Baixo
                
                    w.movePlayer(0, 2, 0);
                    w.stopMoving();
                
                break;
            case 16://Tecla Shift
                    
                break;
            case 32://Tecla Espaço

                break;
            case 88://Tecla X
                System.exit(0);
                break;
            case 81://Tecla Q

        }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

}
