import greenfoot.*;
public class Flower extends ObjectSpecial
{
    public static GreenfootImage image1 = new GreenfootImage("Objects/Special/Flower/Flower1.png");
    public static GreenfootImage image2 = new GreenfootImage("Objects/Special/Flower/Flower2.png");
    public static GreenfootImage image3 = new GreenfootImage("Objects/Special/Flower/Flower3.png");
    public static GreenfootImage image4 = new GreenfootImage("Objects/Special/Flower/Flower4.png");
    public static GreenfootImage image5 = new GreenfootImage("Objects/Special/Flower/Flower5.png");
    private int time = 100;
    public Flower()
    {
        setImage(image1);
    }
    public void act() 
    {
        time--;
        if(time == 99)
            setImage(image1);
        else if(time == 79)
            setImage(image2);
        else if(time == 59)
            setImage(image3);
        else if(time == 39)
            setImage(image4);
        else if(time == 19)
            setImage(image5);
        else if(time == 0)
            time = 100;
    }    
}
