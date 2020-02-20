package tetris.enity;

public class Board
{
    private Cell[][] map;
    private int width;
    private int height;

    public Board()
    {
        width = 10;
        height = 20;
        map = new Cell[height][width];
    }

    public boolean fullLine(int row)
    //判断地图某一行是否呗方块填满
    {
        for(int i = 0;i < 10;i++)
        {
            if(map[row][i] == null)
                return false;
        }
        return true;
    }

    public void moveLine(int row)
    //将第row行以上的每一行往下移一行
    {
        for(int i = row;i > 1;i--)
        {
            for(int j = 0;j < 10;j++)
            {
                map[i][j] = map[i - 1][j];
            }
        }
        for(int j = 0;j < 10;j++)
        {
            map[0][j] = null;
        }
    }

    public void resetMap()
    {
        map = new Cell[height][width];
    }

    public Cell[][] getMap()
    {
        return map;
    }

    public void setMap(Cell[][] map)
    {
        this.map = map;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
}
