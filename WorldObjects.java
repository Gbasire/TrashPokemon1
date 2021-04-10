import greenfoot.*;
public class WorldObjects extends Actor
{
    public int playerx;
    public int playery;
    public int objectCenter;
    public WorldObjects()
    {
        
    }
    public void act()
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
        if(this.getWorld().getClass() == WorldTest.class)
        {
            ((WorldTest)getWorld()).overlayText();
        }
        else if(this.getWorld().getClass() == WorldRoute.class)
        {
            ((WorldRoute)getWorld()).overlayText();
        }
        else if(this.getWorld().getClass() == WorldTown.class)
        {
            ((WorldTown)getWorld()).overlayText();
        }
        else if(this.getWorld().getClass() == WorldCenter.class)
        {
            ((WorldCenter)getWorld()).overlayText();
        }
        else if(this.getWorld().getClass() == WorldPlayerRoom.class)
        {
            ((WorldPlayerRoom)getWorld()).overlayText();
        }
    }
}
