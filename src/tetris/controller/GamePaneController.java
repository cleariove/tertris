package tetris.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import tetris.enity.Board;
import tetris.enity.Cell;
import tetris.enity.Shape;
import tetris.views.GamePane;
import java.util.Iterator;

public class GamePaneController implements EventHandler<KeyEvent>
{
    private static int score;
    private GamePane gamePane;
    private Board board;
    private Shape shape;
    private Shape nextShape;

    public GamePaneController()
    {

    }

    public GamePaneController(GamePane gamePane, Board board, Shape shape,Shape nextShape)
    {
        this.gamePane = gamePane;
        this.board = board;
        this.shape = shape;
        this.nextShape = nextShape;
    }

    @Override
    public void handle(KeyEvent e)
    {
        if(!this.isGameOver())
        {
            switch (e.getCode())
            {
                case LEFT:
                    this.left();
                    break;
                case RIGHT:
                    this.right();
                    break;
                case DOWN:
                    this.down();
                    break;
                case Z:
                    this.turnLeft();
                    break;
                case X:
                    this.turnRight();
                    break;
                case UP:
                    this.turnRight();
                    break;
            }
        }
    }

    public void left()
    {
        if(this.canMoveLeft())
        {
            gamePane.deleteOldImage();
            shape.moveLeft();
            gamePane.paintNewImage();
        }
    }

    public void right()
    {
        if(this.canMoveRight())
        {
            gamePane.deleteOldImage();
            shape.moveRight();
            gamePane.paintNewImage();
        }
    }

    public void down()
    {
        if(this.canMoveDown())
        {
            gamePane.deleteOldImage();
            shape.moveDown();
            gamePane.paintNewImage();
        }
    }

    public void turnLeft()
    {
        gamePane.deleteOldImage();
        shape.turnLeft();
        if(isNotOverBound(0,0))
            gamePane.paintNewImage();
        else
        {
            shape.turnRight();
            gamePane.paintNewImage();
        }
    }

    public void turnRight()
    {
        gamePane.deleteOldImage();
        shape.turnRight();
        if(isNotOverBound(0,0))
            gamePane.paintNewImage();
        else
        {
            shape.turnLeft();
            gamePane.paintNewImage();
        }
    }

    public boolean isGameOver()
    {
        if(isNotOverBound(0,0))
            return false;
        return true;
    }

    public boolean canMoveLeft()
    {
        return isNotOverBound(-1,0);
    }

    public boolean canMoveRight()
    {
        return isNotOverBound(1,0);
    }

    public boolean canMoveDown()
    {
        return isNotOverBound(0,1);
    }

    public void beginGame()
    {
        gamePane.beginGame();
    }

    private boolean isNotOverBound(int i, int j)
    //判断是否越界,越界了返回假,i,j分别代表水平方向和垂直方向的位移
    {
        for(Cell c:shape.getCells())
        {
            if((c.getX() + i) < 0 || (c.getX() + i) > 9)
                return false;
            if(c.getY() + j > 19 || c.getY() + j < 0)
                return false;
            if((board.getMap())[c.getY() + j][c.getX() + i] != null)
                return false;
        }
        return true;
    }

    public void destroyLine()
    //满行则消除消除行
    {
        Iterator<Integer> it = shape.getShapeRow().iterator();
        while(it.hasNext())
        {
            int row = it.next();
            if(board.fullLine(row))
            {
                for(Cell c : (board.getMap())[row])
                {
                    c = null;
                }
                board.moveLine(row);
                score ++;
            }
        }
    }

    public void landed()
    //着陆后的操作
    {
        this.addToMap();//把方块加入墙
        this.destroyLine();//消行操作
        this.creatNewShape();//创建下一个图形
        gamePane.destroyLine();
        gamePane.paintNextShape();
        gamePane.paintNewImage();
        gamePane.paintScore(score);
        if (this.isGameOver())
            gamePane.gameOver();
    }

    public void addToMap()
    //将该方块变成墙
    {
        for(Cell c:shape.getCells())
        {
            (board.getMap())[c.getY()][c.getX()] = c;
        }
    }

    public void gameOver()
    {
        gamePane.gameOver();
    }

    public void creatNewShape()
    //随机生成一组新的形状
    {
        shape = nextShape;
        nextShape = (new Shape()).createRandomShape();
        gamePane.setCurrentShape(shape);
        gamePane.setNextShape(nextShape);
        gamePane.setBoard(board);
    }
}
