package app;

import javafx.application.Application;
import javafx.stage.Stage;


public class Run extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {

        FlappyScene flappyScene;

        try
        {
            flappyScene = new FlappyScene();
            //stage.setResizable(false);
            stage.setScene(flappyScene.getScene());
            stage.show();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
