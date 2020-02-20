package tetris;

import tetris.controller.GamePaneController;

public class DownThread implements Runnable
{

    private GamePaneController gPC;

    public DownThread()
    {
    }

    public DownThread(GamePaneController gPC)
    {
        this.gPC = gPC;
    }

    @Override
    public void run()
    {
        gPC.beginGame();
        while(!gPC.isGameOver())
        {
            gPC.down();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(!gPC.canMoveDown())
                //不能继续下落则表明着陆了
                gPC.landed();
        }
        gPC.gameOver();
    }
}
