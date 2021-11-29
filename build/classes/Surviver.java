
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vpoch
 */
public class Surviver extends Agent implements Runnable {
    Image vetImg[] = new Image[4];
    ImageIcon iconF0 = new ImageIcon("SurviverF.png");
    ImageIcon iconF1 = new ImageIcon("SurviverF1.png");
    ImageIcon iconF2 = new ImageIcon("SurviverF2.png");
    int sprite;
    int n;
    enum State {
        WALKING, RUNNING
    };
    State state = State.WALKING;

    public Surviver(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.alive = true;
        this.rapt = false;
        loadVetImage();
        this.image = iconF0.getImage();
        this.sizeX = iconF0.getIconWidth();
        this.sizeY = iconF0.getIconHeight();
        this.corpo = corpo();
        this.vx = 2;
        this.vy = 2;

    }
    Setor w = Setor.getInstance();

    public Rectangle corpo() {
        Rectangle c = new Rectangle((this.x + 13), (this.y + 17), (this.sizeX - 27), (this.sizeY - 17));
        return c;
    }
    private void loadVetImage(){
        
    }

    private void checkAndChangeState() {

    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        corpo = corpo();
    }
    public void moving(){
        
    }

    public void moviment(int i) throws InterruptedException {
        
    }
    public void isMoving(boolean t){
        this.move = t;
    }

    public boolean interactWith(Rectangle co) {
        return this.corpo.intersects(co);
    }

    //Método para pintar e mover o Dalek
    @Override
    public void run() {
        while (alive) {

            try {
                
                Thread.sleep(500);

            } catch (InterruptedException ex) {
                Logger.getLogger(Surviver.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
