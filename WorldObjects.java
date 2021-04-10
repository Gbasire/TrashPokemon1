import greenfoot.*;
public class WorldObjects extends Actor
{
    public int playerx;
    public int playery;
    public int objectCenter;
    public WorldObjects()
    {

    }

    public void checkPlayer()
    {
        Boy boy = (Boy)getWorld().getObjects(Boy.class).get(0);
        playerx = boy.getX();
        playery = boy.getY();
    }
    public void collide()
    {
        Boy boy = (Boy)getWorld().getObjects(Boy.class).get(0);
        if(isTouching(Boy.class) && playery < getY() + objectCenter)
        {
            boy.hitBox();
        }
    }
    public void overlayText()
    {
        if(getWorld() instanceof OverlayWorld)
            ((OverlayWorld)getWorld()).overlayText();
    }
}
