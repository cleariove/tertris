package tetris.enity;

import tetris.images.Img;

public class JShape extends Shape
{
    public JShape()
    {
        cells[0] = new Cell(1,1, Img.J);
        cells[1] = new Cell(1,0, Img.J);
        cells[2] = new Cell(1,2, Img.J);
        cells[3] = new Cell(0,2, Img.J);
    }
}
