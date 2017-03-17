import java.awt.*;

/**
 * Created by KevinJr on 3/15/2017.
 */
public class Bullet extends Entity {


    public Bullet(Color color, int x, int y, int width, int height, Game game){
        super(color,x,y,width,height,game);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
