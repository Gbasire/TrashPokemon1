import greenfoot.*;
public class MenuControls extends MenuMain
{
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new WorldMenuControls());
    }
}
