package tetris.enity;

import tetris.images.Img;

public class IShape extends Shape
{
    public IShape()
    {
        cells[0] = new Cell(0,1, Img.I);
        cells[1] = new Cell(0,0, Img.I);
        cells[2] = new Cell(0,2, Img.I);
        cells[3] = new Cell(0,3, Img.I);
    }
}
