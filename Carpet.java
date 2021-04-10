import greenfoot.*;
public class Carpet extends ObjectSpecial
{
    public void act()
    {
        checkPlayer();
        if(getWorld().getClass() == WorldCenter.class)
            leaveCenter();
        else if(getWorld().getClass() == WorldPlayerRoom.class)
            leavePlayerHouse();
    }
    public void leaveCenter()
    {
        if(isTouching(Boy.class))
        {
            Boy.previousworld = "CENTER";
            Greenfoot.setWorld(new WorldTown());
        }
    }
    public void leavePlayerHouse()
    {
        if(isTouching(Boy.class))
        {
            Boy.previousworld = "PLAYERHOUSE";
            Greenfoot.setWorld(new WorldTown());
        }
    }
}
