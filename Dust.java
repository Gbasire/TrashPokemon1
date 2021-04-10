import greenfoot.*;
public class Dust extends ObjectSpecial
{
    static GreenfootImage image1 = new GreenfootImage("DustCloud/Poussiere3.png");
    static GreenfootImage image2 = new GreenfootImage("DustCloud/Poussiere4.png");
    static GreenfootImage image3 = new GreenfootImage("DustCloud/Poussiere5.png");
    static GreenfootImage image4 = new GreenfootImage("DustCloud/Poussiere6.png");
    private int time = 12;
    public Dust()
    {
        setImage(image1);
    }
    public void act() 
    {
        time--;
        if(time == 9)
        {
            setImage(image2);
        }
        else if(time == 6)
        {
            setImage(image3);
        }
        else if(time == 3)
        {
            setImage(image4);
        }
        else if(time == 0)
        {
            getWorld().removeObject(this);
        }
    }  
}
