import java.awt.*;
import java.awt.Rectangle;

/**
 * Created by KevinJr on 3/15/2017.
 */
public abstract class AlienGod {
    private Color color;
    private Game game;
    private int width, height, x, y;
    private int dx, dy;


    public AlienGod(Color color, int x, int y, int width, int height, Game game) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        dx=5;
        dy=20;
    }

    public void move(){
        int nextRight=x+width+dx;
        int nextLeft=x+dx;

        if(nextRight > game.getWidth()||nextLeft <= 0){
            dx*=-1;
            y+=dy;
        }
        x+=dx;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean collides(Entity other) {
        return getBounds().intersects(other.getBounds());
    }

    public abstract void paint(Graphics g);






    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getX() {
        return x;
    }
    public void setX(double dx) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(double dy) {
        this.y = y;
    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public double getDx(){return dx;}
    public void setDx(int dx){this.dx=dx;}
    public double getDy(){return dy;}
    public void setDy(int dy){this.dy=dy;}
}
