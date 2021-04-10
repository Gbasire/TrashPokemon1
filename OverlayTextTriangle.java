import greenfoot.*;
public class OverlayTextTriangle extends Actor
{
    private int time = 20;
    public void act()
    {
        if(time > 0)
        {
            time--;
            if(time == 2)
                setLocation(getX(), getY() - 3);
            if(time == 1)
                time = -20;
        }
        if(time < 0)
        {
            time++;
            if(time == -2)
                setLocation(getX(), getY() + 3);
            if(time == -1)
                time = 20;
        }
        if(Greenfoot.isKeyDown("enter"))
            getWorld().removeObject(this);
    }
}
