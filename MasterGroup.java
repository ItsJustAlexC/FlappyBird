package app;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MasterGroup extends Group {
    static int numOfGroups = 999;
    int score = 0;
    Label lbl_score = new Label("" + score);
    Bird bird = new Bird(FlappyScene.width/3, FlappyScene.height/3, 25);
    SubGroup[] groups = new SubGroup[numOfGroups];

    MasterGroup(){
        createGroup();

        this.getChildren().add(lbl_score);
        this.lbl_score.setTranslateX(FlappyScene.width/2);
        this.lbl_score.setFont(Font.font("Arial", 50));
        this.lbl_score.setTextFill(Color.WHITE);

        this.getChildren().add(bird);
    }
    void update(){
        bird.update();
        for (int i = 0; i < numOfGroups; i++) {
            if(bird.collided(groups[i]))
                FlappyScene.at.stop();
        }

        for (int i = 0; i < numOfGroups; i++) {
            if(bird.pass(groups[i])){
                {
                    score++;
                    lbl_score.setText("" + score);
                }
            }
        }

        for (int i = 0; i < numOfGroups; i++) {
            groups[i].update();
        }
        for (int i = 0; i < numOfGroups; i++) {
            if(groups[i].topPipe.x < -80){

            }
        }
    }
    void show(){
        bird.show();

        for (int i = 0; i < numOfGroups; i++) {
            groups[i].show();
        }
    }
    void createGroup(){
        for (int i = 0; i < numOfGroups; i++) {
            this.getChildren().add(groups[i] = new SubGroup());
            SubGroup.xpos += 250;
        }
    }
}
