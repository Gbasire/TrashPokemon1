import greenfoot.*;
public class CenterMain extends ObjectSpecial
{
    GreenfootImage base = new GreenfootImage("PokeCenterMain.png");
    GreenfootImage one = new GreenfootImage("PokeCenterMain-1.png");
    GreenfootImage onelight = new GreenfootImage("PokeCenterMain-2.png");
    public int time;
    public CenterMain()
    {
        objectCenter = 45;
    }
    public void act()
    {
        checkPlayer();
        collide();
        animate();
    }
    public void animate()
    {
        if(time > 0)
        {
            time--;
            if(time == 149)
                setImage(one);
            else if(time == 129)
                setImage(onelight);
            else if(time == 104)
                setImage(one);
            else if(time == 79)
                setImage(onelight);
            else if(time == 54)
                setImage(one);
            else if(time == 29)
                setImage(onelight);
            else if(time == 1)
                setImage(base);
        }
    }
}
