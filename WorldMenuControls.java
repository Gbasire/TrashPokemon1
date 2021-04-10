import greenfoot.*;
public class WorldMenuControls extends World
{
    public WorldMenuControls()
    {
        super(755, 570, 1);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("escape"))
            Greenfoot.setWorld(new WorldMenuMain());
    }
}
