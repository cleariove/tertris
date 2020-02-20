package tetris.enity;

import tetris.images.Img;

public class SShape extends Shape
{
    public SShape()
    {
        cells[0] = new Cell(1,0, Img.S);
        cells[1] = new Cell(2,0, Img.S);
        cells[2] = new Cell(0,1, Img.S);
        cells[3] = new Cell(1,1, Img.S);
    }
}
