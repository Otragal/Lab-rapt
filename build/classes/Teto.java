
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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
public final class Teto extends Objetos {

    

    public Teto(int x, int y) {
        super(x, y);
        this.x = x*pixel;
        this.y = y*pixel;
        this.alive = true;
        this.bar = true;
        ImageIcon icon = new ImageIcon("Teto.png");
        this.image = icon.getImage();
        this.sizeX = 32;
        this.sizeY = 32;
        this.corpo = corpo();
        this.vx = 0;
        this.vy = 0;
    }

    public Rectangle corpo() {
        Rectangle c = new Rectangle(this.x,this.y,this.sizeX,this.sizeY);
        return c;
    }

}
