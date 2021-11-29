/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpoch
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
 
public class WorldFrame extends JFrame {
    public WorldFrame(WorldPanel panel) {
        this.setTitle("Labrapt");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Setor.getInstance().getFrameWidth(),Setor.getInstance().getFrameHeight());
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.addKeyListener(panel);               
    
    }
}
