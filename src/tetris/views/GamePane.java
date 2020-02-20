package tetris.views;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import tetris.enity.Board;
import tetris.enity.Cell;
import tetris.enity.Shape;



public class GamePane extends Pane
{
    private Board board;
    private Shape currentShape;
    private Shape nextShape;
    private Canvas canvas;
    private GraphicsContext gc;
    private ImageView imageView;
    private Label scoreLabel;
    private Label tipLabel1;
    private Label tipLabel2;

    public GamePane()
    {
        canvas = new Canvas(800,800);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.setFont((Font.font("FangSong",45)));
        imageView = new ImageView(new Image("tetris/images/tetris.png"));
        imageView.setFitHeight(800);
        imageView.setFitWidth(800);
        scoreLabel = new Label("得分");
        scoreLabel.setFont(Font.font("FangSong",45));
        scoreLabel.setLayoutX(550);
        scoreLabel.setLayoutY(300);
        tipLabel1 = new Label("方向键以及ZX操作");
        tipLabel1.setFont(Font.font("FangSong",40));
        tipLabel1.setLayoutX(450);
        tipLabel1.setLayoutY(220);
        tipLabel2 = new Label("下一个");
        tipLabel2.setFont(Font.font("FangSong",25));
        tipLabel2.setLayoutX(450);
        tipLabel2.setLayoutY(20);
        this.getChildren().add(imageView);
        this.getChildren().add(scoreLabel);
        this.getChildren().add(tipLabel1);
        this.getChildren().add(tipLabel2);
        this.getChildren().add(canvas);
    }

    public GamePane(Board board, Shape currentShape, Shape nextShape)
    {
        this();
        this.board = board;
        this.currentShape = currentShape;
        this.nextShape = nextShape;
    }

    public void beginGame()
    //初始化棋盘
    {
        gc.clearRect(0,0,800,800);
        for(int i = 0;i < board.getHeight() + 1;i++)
            gc.strokeLine(0,i * Cell.getLength(),board.getWidth() * Cell.getLength(),i * Cell.getLength());
        for(int j = 0;j < board.getWidth() + 1;j++)
            gc.strokeLine(j * Cell.getLength(),0,j * Cell.getLength(),board.getHeight() * Cell.getLength());
        this.paintNextShape();
        this.paintNewImage();
    }

    public void deleteOldImage()
    //删除旧的图像
    {
        for(Cell c:currentShape.getCells())
        {
            gc.clearRect(c.getX() * 40 + 2,c.getY() * 40 + 2,36,36);
        }
    }

    public void paintNewImage()
    //更新新的图像
    {
        for(Cell c:currentShape.getCells())
        {
            gc.drawImage(c.getImage(),c.getX() * 40,c.getY() * 40,40,40);
        }
    }

    public void paintNextShape()
    {
        gc.clearRect(500, 0, 160, 160);
        for(Cell c:nextShape.getCells())
        {
            gc.drawImage(c.getImage(), c.getX() * 40 + 550, c.getY() * 40 + 20, 40, 40);
        }
    }

    public void destroyLine()
    {
        this.beginGame();
        for(int i = 0;i < board.getHeight();i++)
            for(int j = 0; j < board.getWidth();j++)
            {
                if((board.getMap())[i][j] != null)
                {
                    gc.drawImage((board.getMap())[i][j].getImage(), j * 40, i * 40, 40, 40);
                }
            }
    }

    public void paintScore(int score)
    {
        gc.fillText(String.valueOf(score),580,420);
    }

    public void gameOver()
    {
        gc.drawImage(new Image("tetris/images/game-over.png"),0,0,800,800);
    }

    public Shape getCurrentShape()
    {
        return currentShape;
    }

    public void setCurrentShape(Shape currentShape)
    {
        this.currentShape = currentShape;
    }

    public Shape getNextShape()
    {
        return nextShape;
    }

    public void setNextShape(Shape nextShape)
    {
        this.nextShape = nextShape;
    }

    public Board getBoard()
    {
        return board;
    }

    public void setBoard(Board board)
    {
        this.board = board;
    }
}
