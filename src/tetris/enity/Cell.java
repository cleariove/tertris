package tetris.enity;

import javafx.scene.image.Image;

public class Cell
{
    private int x;
    private int y;
    private Image image;
    private static int length = 40;

    public Cell()
    {
    }

    public Cell(int x, int y, Image image)
    {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public static int getLength()
    {
        return length;
    }

    public static void setLength(int length)
    {
        Cell.length = length;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}
