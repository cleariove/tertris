package tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tetris.controller.GamePaneController;
import tetris.enity.Board;
import tetris.enity.Shape;
import tetris.views.GamePane;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Board board = new Board();
        Shape currentShape = (new Shape()).createRandomShape();
        Shape nextShape = (new Shape()).createRandomShape();
        GamePane pane = new GamePane(board,currentShape,nextShape);
        Scene scene = new Scene(pane,800,800);
        GamePaneController gPC = new GamePaneController(pane,board,currentShape,nextShape);
        scene.setOnKeyPressed(gPC);
        DownThread downThread = new DownThread(gPC);
        Thread thread = new Thread(downThread);
        thread.start();
        primaryStage.setTitle("俄罗斯方块");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
