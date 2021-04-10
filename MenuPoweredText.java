import greenfoot.*;
public class MenuPoweredText extends MenuGame
{
    private int time = 0;
    public void act()
    {
        time++;
        if(time > 100 && getY()>284)
            setLocation(getX(),getY()-3);
    }    
}
