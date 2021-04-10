import greenfoot.*;
public class MenuGameText extends MenuGame
{
    private int time = 0;
    private int speed;
    public MenuGameText()
    {
        getImage().setTransparency(0);
    }
    public void act()
    {
        getImage().setTransparency(time);
        appear();
        checkStart();
    }
    public void appear()
    {
        time += speed;
        if(time == 252)
            speed = -3;
        if(time == 0)
            speed = 3;
    }
    public void checkStart()
    {
        if(Greenfoot.isKeyDown("enter"))
            ((WorldMenuGame)getWorld()).transition();
    }
}
