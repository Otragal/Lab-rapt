/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpoch
 */
//Essa classe cria o Mundo od Jogo

public class App {

    //Métood para citar o Mundo
    public static void main(String[] args) {
        WorldPanel panel = new WorldPanel();
        WorldFrame frame = new WorldFrame(panel);
        frame.setVisible(true);

        /*Informar que o Observador está analisando e informando
         **para a classe que o mundo mudou
         */
        Setor.getInstance().addWorldChangeListener(panel);
        Surviver s = new Surviver(5*32,2*32);
        Reptor r = new Reptor(14*32, 1*32);
        Thread t1 = new Thread(s);
        t1.start();
        Setor.getInstance().addAgent(s);
        

        //gerar Daleks
        
    }
}

