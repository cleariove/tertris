package tetris.enity;

import tetris.images.Img;

public class TShape extends Shape
{
    public TShape()
    {
        cells[0] = new Cell(1,0, Img.T);
        cells[1] = new Cell(0,0, Img.T);
        cells[2] = new Cell(2,0, Img.T);
        cells[3] = new Cell(1,1, Img.T);
    }
}
