import greenfoot.*;
public class AttackFlameThrower extends Attacks
{
    static GreenfootImage image1 = new GreenfootImage("Attacks/FlameThrower/attack1.png");
    static GreenfootImage image2 = new GreenfootImage("Attacks/FlameThrower/attack2.png");
    static GreenfootImage image3 = new GreenfootImage("Attacks/FlameThrower/attack3.png");
    static GreenfootImage image4 = new GreenfootImage("Attacks/FlameThrower/attack4.png");
    static GreenfootImage image5 = new GreenfootImage("Attacks/FlameThrower/attack5.png");
    static GreenfootImage image6 = new GreenfootImage("Attacks/FlameThrower/attack6.png");
    static GreenfootImage image7 = new GreenfootImage("Attacks/FlameThrower/attack7.png");
    static GreenfootImage image8 = new GreenfootImage("Attacks/FlameThrower/attack8.png");
    static GreenfootImage image9 = new GreenfootImage("Attacks/FlameThrower/attack9.png");
    static GreenfootImage image10 = new GreenfootImage("Attacks/FlameThrower/attack10.png");
    static GreenfootImage image11 = new GreenfootImage("Attacks/FlameThrower/attack11.png");
    static GreenfootImage image12 = new GreenfootImage("Attacks/FlameThrower/attack12.png");
    static GreenfootImage image13 = new GreenfootImage("Attacks/FlameThrower/attack13.png");
    static GreenfootImage image14 = new GreenfootImage("Attacks/FlameThrower/attack14.png");
    static GreenfootImage image15 = new GreenfootImage("Attacks/FlameThrower/attack15.png");
    static GreenfootImage image16 = new GreenfootImage("Attacks/FlameThrower/attack16.png");
    static GreenfootImage image17 = new GreenfootImage("Attacks/FlameThrower/attack17.png");
    public final int pp = 15;
    public final int power = 95;
    public final int accuracy = 100;
    public final String category = "PHYSICAL";
    public final String type = "FIRE";
    public static double effectiveness;
    private int time = 49;
    public void act()
    {
        checkEnemyPokemon();
        time--;
        if(time == 48)
        {
            if(DataSound.effectAttackFlameThrower.isPlaying() == false) 
                DataSound.effectAttackFlameThrower.play();
            setImage(image2);
            ((WorldWildBattle)getWorld()).overlayFightText();
            OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
            oft.playerattack = "FlameThrower";
            oft.playerattacktime = 150;
            oft.playereffective = effectiveness;
            DataPokemon dp = getWorld().getObjects(DataPokemon.class).get(0);
            dp.attackpower = power;
            dp.attackpp = pp;
            dp.attackaccuracy = accuracy;
            dp.attackcategory = category;
            dp.attacktype = type;
            dp.attackeffectiveness = effectiveness;
        }
        else if(time == 45)
        {
            setImage(image3);
        }
        else if(time == 42)
        {
            setImage(image4);
        }
        else if(time == 39)
        {
            setImage(image5);
        }
        else if(time == 36)
        {
            setImage(image6);
        }
        else if(time == 33)
        {
            setImage(image7);
        }
        else if(time == 30)
        {
            setImage(image8);
        }
        else if(time == 27)
        {
            setImage(image9);
        }
        else if(time == 24)
        {
            setImage(image10);
        }
        else if(time == 21)
        {
            setImage(image11);
        }
        else if(time == 18)
        {
            setImage(image12);
        }
        else if(time == 15)
        {
            setImage(image13);
        }
        else if(time == 12)
        {
            setImage(image14);
        }
        else if(time == 9)
        {
            setImage(image15);
        }
        else if(time == 6)
        {
            setImage(image16);
        }
        else if(time == 3)
        {
            setImage(image17);
        }
        else if(time == 0)
        {
            getWorld().removeObject(this);
        }
    }
    public void checkEnemyPokemon()
    {
        DataWildPokemon dwp = getWorld().getObjects(DataWildPokemon.class).get(0);
        if(dwp.type == "ROCK" || dwp.type == "WATER" || dwp.type == "FIRE" || dwp.type == "DRAGON")
            effectiveness = 0.5;
        else if(dwp.type == "GRASS" || dwp.type == "BUG" || dwp.type == "ICE" || dwp.type == "STEEL")
            effectiveness = 2;
        else
            effectiveness = 1;
    }
}
