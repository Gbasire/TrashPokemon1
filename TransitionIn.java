import greenfoot.*; 
public class TransitionIn extends Transitions
{
    static GreenfootImage image1 = new GreenfootImage("TransitionIn/transition1.png");
    static GreenfootImage image2 = new GreenfootImage("TransitionIn/transition2.png");
    static GreenfootImage image3 = new GreenfootImage("TransitionIn/transition3.png");
    static GreenfootImage image4 = new GreenfootImage("TransitionIn/transition4.png");
    static GreenfootImage image5 = new GreenfootImage("TransitionIn/transition5.png");
    static GreenfootImage image6 = new GreenfootImage("TransitionIn/transition6.png");
    static GreenfootImage image7 = new GreenfootImage("TransitionIn/transition7.png");
    static GreenfootImage image8 = new GreenfootImage("TransitionIn/transition8.png");
    static GreenfootImage image9 = new GreenfootImage("TransitionIn/transition9.png");
    static GreenfootImage image10 = new GreenfootImage("TransitionIn/transition10.png");
    static GreenfootImage image11 = new GreenfootImage("TransitionIn/transition11.png");
    static GreenfootImage image12 = new GreenfootImage("TransitionIn/transition12.png");
    static GreenfootImage image13 = new GreenfootImage("TransitionIn/transition13.png");
    static GreenfootImage image14 = new GreenfootImage("TransitionIn/transition14.png");
    static GreenfootImage image15 = new GreenfootImage("TransitionIn/transition15.png");
    static GreenfootImage image16 = new GreenfootImage("TransitionIn/transition16.png");
    private int time = 64;
    public TransitionIn()
    {
        setImage(image1);
    }
    public void act() 
    {
        DataSound datasound = (DataSound)getWorld().getObjects(DataSound.class).get(0);
        datasound.wildBattle();
        time--;
        if(time == 60)
        {
            setImage(image2);
            datasound.battlelaunched = true;
        }
        else if(time == 56)
            setImage(image3);
        else if(time == 52)
            setImage(image4);
        else if(time == 48)
            setImage(image5);
        else if(time == 44)
            setImage(image6);
        else if(time == 40)
            setImage(image7);
        else if(time == 36)
            setImage(image8);
        else if(time == 32)
            setImage(image9);
        else if(time == 28)
            setImage(image10);
        else if(time == 24)
            setImage(image11);
        else if(time == 20)
            setImage(image12);
        else if(time == 16)
            setImage(image13);
        else if(time == 12)
            setImage(image14);
        else if(time == 8)
            setImage(image15);
        else if(time == 4)
            setImage(image16);
        else if(time == 0)
            Greenfoot.setWorld(new WorldWildBattle());
    }
}
