
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public abstract class Agent {
   //Tamanho do objeto
    int sizeX;
    int sizeY;
    int pixel = 32;
    //Se está vivo
    boolean alive;
    boolean bar;
    boolean rapt;
    //Sua Posição
    int x;
    int y;
    //Velocidade
    int vx;
    int vy;
    //Boolean se é Dalek
    boolean ativo;
    boolean move;
    Rectangle corpo;
    //Imagem
    Image image;
    BufferedImage bufimage;
    // buffer;
     //Método para defenir o objeto
    public Agent(int x, int y) {
        this.x = x;
        this.y = y;
        alive = true;
        vx = 2;
        vy = 2;
    }
}
