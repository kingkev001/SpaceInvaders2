import java.awt.*;
import java.awt.Rectangle;

public abstract class Entity {

    private Color color;
    private Game game;
    private int width, height, x, y;
    private int dx, dy;


    public Entity(Color color, int x, int y, int width, int height, Game game) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        dx=5;
        dy=5;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean collides(Alien other) {
        return getBounds().intersects(other.getBounds());
    }

    public abstract void paint(Graphics g);

    public void bulletShoot(){
        y-=dy;
    }

    public void move() {
        double nextRight=x+width+dx;
        double nextLeft=x+dx;

        if(getGame().isLeftPressed()){
            if(nextLeft <= 0){

            }else{
                x-=dx;
            }
        }

        if(getGame().isRightPressed()){
            if(nextRight > game.getWidth()){

            }else{
                x+=dx;
            }
        }

    }



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
