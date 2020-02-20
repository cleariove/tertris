package tetris.enity;

import tetris.images.Img;

public class ZShape extends Shape
{
    public ZShape()
    {
        cells[0] = new Cell(1,0, Img.Z);
        cells[1] = new Cell(0,0, Img.Z);
        cells[2] = new Cell(1,1, Img.Z);
        cells[3] = new Cell(2,1, Img.Z);
    }
}
