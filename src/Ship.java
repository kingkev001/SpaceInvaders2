import java.awt.*;


public class Ship extends Entity {

    public Ship(Color color, int x, int y, int width, int height, Game game) {
        super(color, x, y, width, height, game);
    }

    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(getX(),getY(),getWidth()/2,getHeight()/3);
    }







}



