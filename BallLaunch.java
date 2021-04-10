import greenfoot.*;
public class BallLaunch extends Battle
{
    static GreenfootImage image1 = new GreenfootImage("BattleStartBall/Ball1.png"); 
    static GreenfootImage image2 = new GreenfootImage("BattleStartBall/Ball2.png");
    static GreenfootImage image3 = new GreenfootImage("BattleStartBall/Ball3.png");
    static GreenfootImage image4 = new GreenfootImage("BattleStartBall/Ball4.png");
    private int timer = 125;
    private int time = 25;
    public BallLaunch()
    {
        setImage(image1);
        setRotation(-160);
        getImage().setTransparency(0);
    }
    public void act() 
    {
        appear();
    }
    public void appear()
    {
        timer--;
        if(timer < 0)
        {
            if(getX()<120)
            {
                getImage().setTransparency(250);
                setLocation(getX()+4,getY()+2);
                turn(-26);
            }
            else if(getX()<155)
            {
                setLocation(getX()+3,getY()+3);
                turn(-26);
            }
            else if(getX()<200)
            {
                setLocation(getX()+2,getY()+5);
                turn(-25);
            }
            else
            {
                time--;
                if(time == 9)
                    setImage(image2);
                else if(time == 6)
                    setImage(image3);
                else if(time == 3)
                {
                    setImage(image4);
                    ((WorldWildBattle)getWorld()).ballExplosion();
                }
                else if(time == 0)
                    getWorld().removeObject(this);
            }
        }
    }
}
