package app;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bird extends Circle {
    double x;
    double y;
    double size;
    double gravity = 1;
    double force = -20;
    double velocity = 0;
    double resistance = 0.95;


    double width = 600.0;
    double height = 600.0;


    Bird(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    void show() {
        this.setCenterX(this.x);
        this.setCenterY(this.y);
        this.setRadius(this.size);
        this.setFill(null);
        this.setStroke(Color.WHITE);
    }

    void update() {
        this.velocity += this.gravity;
        this.y += this.velocity;
        this.velocity *= this.resistance;

        if (this.y + this.size >= this.height) {
            this.y = this.height - this.size;
            this.velocity = 0;
        }
        if (this.y - this.size <= 0) {
            this.y = 0 + this.size;
            this.velocity = 0;
        }
    }

    boolean pass(SubGroup pipes) {
        if (Math.abs(this.x - pipes.topPipe.x - 75) < 2) {
            return true;
        } else
            return false;
    }

    boolean collided(SubGroup pipes)
    {
        if((this.x + this.size >= pipes.topPipe.x && this.x <= pipes.topPipe.x + 75 && this.y - this.size + 5 <= pipes.topPipe.height) || this.x + this.size >= pipes.bottomPipe.x && this.x <= pipes.bottomPipe.x + 75 && this.y + this.size - 5 >= pipes.bottomPipe.y)
            return true;
        return false;
    }

    void lift()
    {
        this.velocity += this.force;
        this.velocity *= this.resistance;
        this.y += this.velocity;
    }
}


