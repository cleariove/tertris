package tetris.enity;

import java.util.HashSet;
import java.util.Random;

public class Shape
{
    protected Cell[] cells =  new Cell[4];

    public Shape()
    {

    }

    public void moveLeft()
    {
        for(Cell c:cells)
        {
            c.setX(c.getX() - 1);
        }
    }

    public void moveRight()
    {
        for(Cell c:cells)
        {
            c.setX(c.getX() + 1);
        }
    }

    public void moveDown()
    {
        for(Cell c : cells)
        {
            c.setY(c.getY() + 1);
        }
    }

    private void turn(String s)
    {
        //cells[0]为旋转中心点
        //对其余三个点，找到每个点相对中心点的x和y的距离
        //将这两个距离数值对调，即为新的cell相对中心点的位置
        for(int i = 1;i < cells.length;i++)
        {
            int distanceX = cells[i].getX() - cells[0].getX();
            int distanceY = cells[i].getY() - cells[0].getY();
            if(s.equals("right"))
            {
                cells[i].setX(cells[0].getX() + distanceY);
                cells[i].setY(cells[0].getY() - distanceX);
            }
            else
            {
                cells[i].setX(cells[0].getX() - distanceY);
                cells[i].setY(cells[0].getY() + distanceX);
            }
        }
    }

    public void turnRight()
    {
        turn("right");
    }

    public void turnLeft()
    {
        turn("left");
    }

    public Shape createRandomShape()
            //随机生成一个形状
    {
        switch (new Random().nextInt(7))
        {
            case 0:
                return new IShape();
            case 1:
                return new JShape();
            case 2:
                return new LShape();
            case 3:
                return new OShape();
            case 4:
                return new SShape();
            case 5:
                return new TShape();
            case 6:
                return new ZShape();
        }
        return null;
    }

    public HashSet<Integer> getShapeRow()
            //得到一个形状所占的行号
    {
        HashSet<Integer> rowSets = new HashSet<>();
        for(Cell c : cells)
        {
            rowSets.add(c.getY());
        }
        return rowSets;
    }

    public Cell[] getCells()
    {
        return cells;
    }

    public void setCells(Cell[] cells)
    {
        this.cells = cells;
    }
}
