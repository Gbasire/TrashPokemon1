import greenfoot.*;
public class BattlePlayer extends Battle
{
    GreenfootImage image1 = new GreenfootImage("PlayerBattle/player1.png"); 
    GreenfootImage image2 = new GreenfootImage("PlayerBattle/player2.png");
    GreenfootImage image3 = new GreenfootImage("PlayerBattle/player3.png");
    GreenfootImage image4 = new GreenfootImage("PlayerBattle/player4.png");
    GreenfootImage image5 = new GreenfootImage("PlayerBattle/player5.png");
    private int time = 145;
    public BattlePlayer()
    {
        if(Boy.isGirl == true)
        {
            image1 = new GreenfootImage("PlayerBattle/player1girl.png");
            image2 = new GreenfootImage("PlayerBattle/player2girl.png");
            image3 = new GreenfootImage("PlayerBattle/player3girl.png");
            image4 = new GreenfootImage("PlayerBattle/player4girl.png");
            image5 = new GreenfootImage("PlayerBattle/player5girl.png");
        }
        else
        {
            image1 = new GreenfootImage("PlayerBattle/player1.png");
            image2 = new GreenfootImage("PlayerBattle/player2.png");
            image3 = new GreenfootImage("PlayerBattle/player3.png");
            image4 = new GreenfootImage("PlayerBattle/player4.png");
            image5 = new GreenfootImage("PlayerBattle/player5.png");
        }
        setImage(image1);
    }
    public void act() 
    {
        time--;
        if(time == 50)
            setImage(image2);
        else if(time == 30)
            setImage(image2);
        else if(time == 26)
            setImage(image3);
        else if(time == 21)
            setImage(image4);
        else if(time == 18)
        {
            setImage(image5);
            DataSound.effectLaunchBall.play();
        }
        else if(time == 00)
            getWorld().removeObject(this);
        if(time < 50)
            move(-5);
    }    
}
