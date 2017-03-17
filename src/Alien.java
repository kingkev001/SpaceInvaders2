import java.awt.*;

public class Alien extends AlienGod {


    public Alien(Color color, int x, int y, int diameter, Game game) {

        super(color, x, y, diameter, diameter, game);
    }





    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillOval(getX(),getY(),getWidth(),getHeight());
    }



}