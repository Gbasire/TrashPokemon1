import greenfoot.*;
public class BasePlayer extends Battle
{
    private int time = 30;
    public void act()
    {
        appear();
    }
    public void appear()
    {
        time--;
        if(time > 0)
            setLocation(getX()+1,getY()-1);
    }   
}
