package app;

import javafx.scene.Group;

public class SubGroup extends Group {
    Pipe topPipe;
    Pipe bottomPipe;

    double height = FlappyScene.height;
    static int xpos = 1000;

    SubGroup(){
        topPipe = new Pipe(xpos, 0, 75);
        double pipeSpace = 175;
        double pipeHS = topPipe.height + pipeSpace;
        double rPipeHeight = height - topPipe.height - pipeSpace;
        bottomPipe = new Pipe(xpos, pipeHS, 75, rPipeHeight);

        this.getChildren().addAll(topPipe,bottomPipe);
    }
    void update(){
        topPipe.x -= 5;
        bottomPipe.x -= 5;
    }
    void show(){
        topPipe.show();
        bottomPipe.show();
    }
}
