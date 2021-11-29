
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Setor extends JPanel {

    private int frameWidth = 640;
    private int frameHeight = 640;
    private static Setor singleton;
    private int numbSetor;
    List<Agent> agents;
    List<Agent> npc;
    List<Objetos> obj;
    List<WorldChangeListener> worldChangeListenerList;
    private Limites lim;
    private int mat[][] = new int[17][17];
    private Surviver s;

    public static Setor getInstance() {
        if (singleton == null) {
            singleton = new Setor();
        }
        return singleton;
    }

    private Setor() {
        agents = new ArrayList<>();
        worldChangeListenerList = new ArrayList<>();
        obj = new ArrayList<>();
        npc = new ArrayList<>();
        lim = new Limites();
        mat = lim.matriz();
        mapa();

    }

    //método que a lista do Observadora que avisa o mundo se mudou
    public void addWorldChangeListener(WorldChangeListener listener) {
        worldChangeListenerList.add(listener);
    }

    public void addObj(Objetos ob) {
        obj.add(ob);
        for (WorldChangeListener listener : worldChangeListenerList) {
            listener.worldHasChanged();
        }
    }

    public void addAgent(Agent ag) {
        s = new Surviver(ag.x, ag.y);
        agents.add(s);
        for (WorldChangeListener listener : worldChangeListenerList) {
            listener.worldHasChanged();
        }
    }
    
    public boolean piso(Agent r, int x, int y){
        if(mat[x][y] == 3){
            return true;
        }
        return false;
    }

    public void mat() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void reset() {
        agents = new ArrayList<>();
        obj = new ArrayList<>();

    }

    public Setor(LayoutManager layout) {
        super(layout);
    }

    public void mapa() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[j][i] == 0 || mat[j][i] == 5) {
                    addObj(new Piso(i, j));
                } else if (mat[j][i] == 1) {
                    addObj(new Teto(i, j));
                } else if (mat[j][i] == 3) {
                    addObj(new Inter(i, j));
                } else if (mat[j][i] == 4) {
                    addObj(new Parede(i, j));
                }
            }
        }

    }

    @Override
    public void move(int dx, int dy) {
        for (Agent ag : agents) {
            if (ag.rapt) {
                ag.x += dx;
                ag.y += dy;
            }
        }
    }

    public void movePlayer(int dx, int dy, int mv) throws InterruptedException {
        if (agents.contains(s) && s.alive) {

            if (!canMove(s, dx, dy)) {

                s.move(0, 0);
            } else {
                s.moviment(mv);
                s.move(dx, dy);
            }

        }

        for (WorldChangeListener listener : worldChangeListenerList) {
            listener.worldHasChanged();
        }

    }
    public void stayMoving(){
        s.isMoving(true);
    }
    public void stopMoving(){
        s.isMoving(false);
    }

    public boolean canMove(Agent agent, int dx, int dy) {
        Rectangle agent1, agent2;
        Objetos ob;
        agent1 = agent.corpo;
        for (int i = 0; i < obj.size(); i++) {
            ob = obj.get(i);
            agent2 = ob.corpo;
            if (ob.bar) {
                if ((agent1.getMinX() + dx >= agent2.getMinX() && agent1.getMinX() + dx <= agent2.getMaxX())
                        && (agent1.getMinY() + dy >= agent2.getMinY() && agent1.getMinY() + dy <= agent2.getMaxY())) {
                    return false;
                }

                if ((agent1.getMaxX() + dx >= agent2.getMinX() && agent1.getMaxX() + dx <= agent2.getMaxX())
                        && (agent1.getMinY() + dy >= agent2.getMinY() && agent1.getMinY() + dy <= agent2.getMaxY())) {
                    return false;
                }

                if ((agent1.getMinX() + dx >= agent2.getMinX() && agent1.getMinX() + dx <= agent2.getMaxX())
                        && (agent1.getMaxY() + dy >= agent2.getMinY() && agent1.getMaxY() + dy <= agent2.getMaxY())) {
                    return false;
                }

                if ((agent1.getMaxX() + dx >= agent2.getMinX() && agent1.getMaxX() + dx <= agent2.getMaxX())
                        && (agent1.getMaxY() + dy >= agent2.getMinY() && agent1.getMaxY() + dy <= agent2.getMaxY())) {
                    return false;
                }
            }

            //                    System.out.println(ag.corpo.x + " "+ ag.corpo.height);
            //                    System.out.println(ob.corpo.x + " " + ag.corpo.height);
            //                    if(ag.corpo.x >= ob.x + ob.corpo.width){
            //                        s.move(1, 0);
            //                        
            //                    }
            //                    if(ag.corpo.y >= ob.corpo.y + ob.corpo.height){
            //                        s.move(0, 1);
            //                    }
            //                    if(ag.corpo.x + ag.corpo.width <= ob.corpo.x){
            //                        s.move(-1,0);
            //                        
            //                    }
            //                    if(ag.corpo.y + ag.corpo.height <= ob.corpo.y){
            //                        s.move(0, -1);
            //                        
            //                    }
        }

        return true;

    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

//    @Override
//    public void paint(Graphics g) {
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, frameWidth, frameHeight);
//        for (Objetos o : obj) {
//            
//        }
//    }
//
//    @Override
//    public void run() {
//        reset();
//        while (true) {
//            this.repaint();
//            
//        }
//    }
}
