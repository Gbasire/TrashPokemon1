import greenfoot.*;
public class BallExplosion extends Battle
{
    static GreenfootImage image1 = new GreenfootImage("BattleStartExplode/Explode1.png"); 
    static GreenfootImage image2 = new GreenfootImage("BattleStartExplode/Explode2.png");
    static GreenfootImage image3 = new GreenfootImage("BattleStartExplode/Explode3.png");
    static GreenfootImage image4 = new GreenfootImage("BattleStartExplode/Explode4.png"); 
    static GreenfootImage image5 = new GreenfootImage("BattleStartExplode/Explode5.png");
    static GreenfootImage image6 = new GreenfootImage("BattleStartExplode/Explode6.png");
    static GreenfootImage image7 = new GreenfootImage("BattleStartExplode/Explode7.png");
    private int time = 15;
    public BallExplosion()
    {
        setImage(image1);
    }
    public void act() 
    {
        animate();
    }
    public void animate()
    {
        time--;
        if(time == 14)
            setImage(image2);
        else if(time == 12)
            setImage(image3);
        else if(time == 10)
            setImage(image4);
        else if(time == 8)
        {
            setImage(image5);
            ((WorldWildBattle)getWorld()).playerPokemon();
        }
        else if(time == 6)
            setImage(image6);
        else if(time == 3)
            setImage(image7);
        else if(time == 0)
        {
            ((WorldWildBattle)getWorld()).prepareHP();
            getWorld().removeObject(this);
        }
    }
}
