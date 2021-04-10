import greenfoot.*;
public class HPEnemy extends Battle
{
    public void act() 
    {
        if(getX()<128)
            move(2);
    }
}
