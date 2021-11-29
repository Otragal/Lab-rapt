
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpoch
 */
public class Reptor extends Agent implements Runnable{
    enum State {PASSVIO,ATIVO};
    State state = State.ATIVO;
    Setor w = Setor.getInstance();
    public Reptor(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.alive = true;
        this.rapt = true;
        this.ativo = false;
        this.vx = 4;
        this.vy = 4;
        this.corpo = corpo();
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void walk(){
        if(w.piso(this, x, y)){
            int r = (int) (Math.random()*3);
            if(r == 0){
                this.vx = 4;
                this.vy = 0;
            }
            if(r == 1){
                this.vx = -4;
                this.vy = 0;
            }
            if(r == 2){
                this.vx = 0;
                this.vy = 4;
            }
            if(r == 3){
                this.vx = 0;
                this.vy = -4;
            }
        }
    }
    
    
    
    public Rectangle corpo(){
        Rectangle c = new Rectangle((this.x + 8), (this.y + 8), (this.x + 16), (this.y + 16));
        
        return c;
    }
    
    private void catching(Agent s, int px, int py){
        int gX, gY, rX, rY, feetX, feetY, vx, vy;
        gX =(int) s.corpo.getCenterX();
        gY = (int) s.corpo.getCenterY();
        rX = (int) this.corpo.getCenterX();
        rY = (int) this.corpo.getCenterY();
        
        feetX = gX - rX;
        feetY = gY - rY;
        
        if (feetX == 0 && feetY == 0) {
            
            w.move(0, 0);
        }
        if (feetX == 0 && feetY > 0) {
            
            w.move(0, this.vy);
        }
        if (feetX == 0 && feetY < 0) {
           
            w.move(0, -this.vy);
        }
        if (feetX > 0 && feetY == 0) {
           
            w.move(this.vx, 0);
        }
        if (feetX < 0 && feetY == 0) {
            
            w.move(this.vx, 0);
        }
        
    }
    

    
    
}
