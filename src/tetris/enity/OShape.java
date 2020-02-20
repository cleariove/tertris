package tetris.enity;

import tetris.images.Img;

public class OShape extends Shape
{
    public OShape()
    {
        cells[0] = new Cell(0,0, Img.O);
        cells[1] = new Cell(0,1, Img.O);
        cells[2] = new Cell(1,0, Img.O);
        cells[3] = new Cell(1,1, Img.O);
    }
}
