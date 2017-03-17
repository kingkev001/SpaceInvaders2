import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Game extends JPanel implements ActionListener {

    ArrayList<Entity> entities;
    ArrayList<Alien>aliens;
    ArrayList<Entity>bullets;

    public boolean upPressed,downPressed,rightPressed,leftPressed,spacePressed;


    public Game(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Space Invaders");
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_W) {
                    upPressed=false;
                    System.out.println("W");
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    downPressed=false;
                    System.out.println("S");
                }

                if (e.getKeyCode() == KeyEvent.VK_D) {
                    rightPressed=true;
                    System.out.println("D");
                }

                if (e.getKeyCode() == KeyEvent.VK_A) {
                    leftPressed=true;
                    System.out.println("A");
                }

                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    System.out.println("SPACE");
                    addBullet();
                    spacePressed=true;

                }



            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    upPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    downPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_D) {
                    rightPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_A) {
                    leftPressed = false;
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){

                    spacePressed=false;
                }
            }

        });

        setBackground(Color.black);
        setPreferredSize(new Dimension(600,700));
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        Game game = new Game();
        game.init();
        game.run();
    }

    public void run(){
        Timer timer = new Timer(1000/60,this);
        timer.start();
    }

    public void init(){
        entities= new ArrayList<Entity>();
        aliens = new ArrayList<Alien>();
        bullets = new ArrayList<Entity>();


        entities.add(new Ship(Color.white, (getWidth()/2),650,100,100,this));
        int aX = 0;
        int aY = 20;
        for(int i = 0; i<44;i++){
            aX+=50;
            aliens.add(new Alien(Color.green,aX,aY,20,this));
            if(aX%11==0){
                aY+=25;
                aX=0;
            }
        }

    }

    public void addBullet(){
        bullets.add(new Bullet(Color.red, ((entities.get(0).getX() + (entities.get(0).getWidth() / 2))-25), entities.get(0).getY()-5, 5, 5, this));

    }

    public void paint(Graphics g){
        super.paint(g);
        for(Entity obj: entities){
            obj.paint(g);
        }
        for(AlienGod obj: aliens){
            obj.paint(g);
        }
        for(Entity obj: bullets){
            obj.paint(g);
        }

    }

    public void collisions(){

        for(int i = 0;i<aliens.size();i++){
            if(entities.get(0).collides(aliens.get(i))){
               System.out.println("YOU LOSE");
                entities.remove(entities.get(0));
            }
        }

        for(int i = 0; i < aliens.size();i++){
            for(int j = 0; j <bullets.size();j++){
                if(aliens.get(i).collides(bullets.get(j))){
                    aliens.remove(aliens.get(i));
                    bullets.remove(bullets.get(j));
                    break;
                }
            }

        }



    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (Stats.isPlay()) {
            collisions();
            entities.get(0).move();


            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).bulletShoot();
            }

            for (int i = 0; i < aliens.size(); i++) {
                aliens.get(i).move();
            }

            repaint();

        }
    }


    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isRightPressed(){return rightPressed;}

    public boolean isLeftPressed(){return leftPressed;}

}
