package app;

import javafx.animation.AnimationTimer;



import javafx.scene.Scene;

import javafx.scene.input.KeyCode;

import javafx.scene.paint.Color;

public class FlappyScene
{


    static double width = 600.0;
    static double height = 600.0;

    MasterGroup root;
    static Scene scene;
    static AnimationTimer at;


    FlappyScene()
    {
        this.root = new MasterGroup();

        this.scene = new Scene(root, width, height, Color.BLACK);

        this.scene.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.SPACE))
            {
                this.root.bird.lift();
            }
        });

        at = new AnimationTimer() {
            @Override
            public void handle(long now)
            {
                root.show();
                root.update();
            }
        };
        at.start();
    }
    Scene getScene()
    {
        return scene;
    }
}
