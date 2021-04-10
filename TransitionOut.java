import greenfoot.*;
public class TransitionOut extends Transitions
{
    static GreenfootImage image1 = new GreenfootImage("TransitionOut/transition1.png"); 
    static GreenfootImage image2 = new GreenfootImage("TransitionOut/transition2.png");
    static GreenfootImage image3 = new GreenfootImage("TransitionOut/transition3.png");
    static GreenfootImage image4 = new GreenfootImage("TransitionOut/transition4.png"); 
    static GreenfootImage image5 = new GreenfootImage("TransitionOut/transition5.png");
    static GreenfootImage image6 = new GreenfootImage("TransitionOut/transition6.png");
    static GreenfootImage image7 = new GreenfootImage("TransitionOut/transition7.png");
    static GreenfootImage image8 = new GreenfootImage("TransitionOut/transition8.png"); 
    static GreenfootImage image9 = new GreenfootImage("TransitionOut/transition9.png");
    static GreenfootImage image10 = new GreenfootImage("TransitionOut/transition10.png");
    static GreenfootImage image11 = new GreenfootImage("TransitionOut/transition11.png"); 
    static GreenfootImage image12 = new GreenfootImage("TransitionOut/transition12.png");
    static GreenfootImage image13 = new GreenfootImage("TransitionOut/transition13.png");
    static GreenfootImage image14 = new GreenfootImage("TransitionOut/transition14.png");
    static GreenfootImage image15 = new GreenfootImage("TransitionOut/transition15.png");
    static GreenfootImage image16 = new GreenfootImage("TransitionOut/transition16.png");
    static GreenfootImage image17 = new GreenfootImage("TransitionOut/transition17.png");
    static GreenfootImage image18 = new GreenfootImage("TransitionOut/transition18.png");
    static GreenfootImage image19 = new GreenfootImage("TransitionOut/transition19.png");
    static GreenfootImage image20 = new GreenfootImage("TransitionOut/transition20.png");
    public int time = 60;
    public TransitionOut()
    {
        setImage(image1);
    }
    public void act()
    {
        time--;
        if(time == 57)
            setImage(image2);
        else if(time == 54)
            setImage(image3);
        else if(time == 51)
            setImage(image4);
        else if(time == 48)
            setImage(image5);
        else if(time == 45)
            setImage(image6);
        else if(time == 42)
            setImage(image7);
        else if(time == 39)
            setImage(image8);
        else if(time == 36)
            setImage(image9);
        else if(time == 33)
            setImage(image10);
        else if(time == 30)
            setImage(image11);
        else if(time == 27)
            setImage(image12);
        else if(time == 24)
            setImage(image13);
        else if(time == 21)
            setImage(image14);
        else if(time == 18)
            setImage(image15);
        else if(time == 15)
            setImage(image16);
        else if(time == 12)
            setImage(image17);
        else if(time == 9)
            setImage(image18);
        else if(time == 6)
            setImage(image19);
        else if(time == 3)
            setImage(image20);
        else if(time == 0)
            getWorld().removeObject(this);
    }    
}
