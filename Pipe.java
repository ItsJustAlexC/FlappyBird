package app;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import java.security.SecureRandom;


public class Pipe extends Rectangle
{
    double x;
    double y;
    double width;
    double height;

    Pipe(double x, double y, double width)
    {
        SecureRandom random = new SecureRandom();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = 25 + random.nextInt(400);
    }
    Pipe(double x, double y, double width,double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    void show()
    {
        this.setX(this.x);
        this.setY(this.y);
        this.setWidth(this.width);
        this.setHeight(this.height);
        this.setFill(null);
        this.setStroke(Color.WHITE);
    }

    void update()
    {
        this.x -= 5;
    }


}
