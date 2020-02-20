package tetris.enity;

import tetris.images.Img;

public class LShape extends Shape
{
    public LShape()
    {
        cells[0] = new Cell(0,1, Img.L);
        cells[1] = new Cell(0,0, Img.L);
        cells[2] = new Cell(0,2, Img.L);
        cells[3] = new Cell(1,2, Img.L);
    }
}
