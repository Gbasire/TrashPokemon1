import greenfoot.*;
public class AttackLowSweep extends Attacks
{
    static GreenfootImage image1 = new GreenfootImage("Attacks/LowSweep/attack1.png");
    static GreenfootImage image2 = new GreenfootImage("Attacks/LowSweep/attack2.png");
    static GreenfootImage image3 = new GreenfootImage("Attacks/LowSweep/attack3.png");
    static GreenfootImage image4 = new GreenfootImage("Attacks/LowSweep/attack4.png");
    static GreenfootImage image5 = new GreenfootImage("Attacks/LowSweep/attack5.png");
    static GreenfootImage image6 = new GreenfootImage("Attacks/LowSweep/attack6.png");
    static GreenfootImage image7 = new GreenfootImage("Attacks/LowSweep/attack7.png");
    static GreenfootImage image8 = new GreenfootImage("Attacks/LowSweep/attack8.png");
    static GreenfootImage image9 = new GreenfootImage("Attacks/LowSweep/attack9.png");
    static GreenfootImage image10 = new GreenfootImage("Attacks/LowSweep/attack10.png");
    static GreenfootImage image11 = new GreenfootImage("Attacks/LowSweep/attack11.png");
    static GreenfootImage image12 = new GreenfootImage("Attacks/LowSweep/attack12.png");
    static GreenfootImage image13 = new GreenfootImage("Attacks/LowSweep/attack13.png");
    static GreenfootImage image14 = new GreenfootImage("Attacks/LowSweep/attack14.png");
    static GreenfootImage image15 = new GreenfootImage("Attacks/LowSweep/attack15.png");
    static GreenfootImage image16 = new GreenfootImage("Attacks/LowSweep/attack16.png");
    static GreenfootImage image17 = new GreenfootImage("Attacks/LowSweep/attack17.png");
    public final int pp = 20;
    public final int power = 70;
    public final int accuracy = 100;
    public final String category = "PHYSICAL";
    public final String type = "FIGHTING";
    public static double effectiveness;
    private int time = 49;
    public void act()
    {
        checkEnemyPokemon();
        time--;
        if(time == 48)
        {
            if(DataSound.effectAttackLowSweep.isPlaying() == false)
                DataSound.effectAttackLowSweep.play();
            setImage(image2);
            ((WorldWildBattle)getWorld()).overlayFightText();
            OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
            oft.playerattack = "LowSweep";
            oft.playerattacktime = 150;
            oft.playereffective = effectiveness;
            DataPokemon.attackpower = power;
            DataPokemon.attackpp = pp;
            DataPokemon.attackaccuracy = accuracy;
            DataPokemon.attackcategory = category;
            DataPokemon.attacktype = type;
            DataPokemon.attackeffectiveness = effectiveness;
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
        if(DataWildPokemon.type == "POISON" || DataWildPokemon.type == "FLYING" || DataWildPokemon.type == "BUG" || DataWildPokemon.type == "PSYCHIC")
            effectiveness = 0.5;
        else if(DataWildPokemon.type == "NORMAL" || DataWildPokemon.type == "DARK" || DataWildPokemon.type == "ICE" || DataWildPokemon.type == "STEEL" || DataWildPokemon.type == "ROCK")
            effectiveness = 2;
        else
            effectiveness = 1;
    }
}
