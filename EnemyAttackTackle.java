import greenfoot.*;
public class EnemyAttackTackle extends AttacksEnemy
{
    static GreenfootImage image1 = new GreenfootImage("Attacks/EnemyTackle/attack1.png");
    static GreenfootImage image2 = new GreenfootImage("Attacks/EnemyTackle/attack2.png");
    static GreenfootImage image3 = new GreenfootImage("Attacks/EnemyTackle/attack3.png");
    static GreenfootImage image4 = new GreenfootImage("Attacks/EnemyTackle/attack4.png");
    static GreenfootImage image5 = new GreenfootImage("Attacks/EnemyTackle/attack5.png");
    static GreenfootImage image6 = new GreenfootImage("Attacks/EnemyTackle/attack6.png");
    static GreenfootImage image7 = new GreenfootImage("Attacks/EnemyTackle/attack7.png");
    static GreenfootImage image8 = new GreenfootImage("Attacks/EnemyTackle/attack8.png");
    static GreenfootImage image9 = new GreenfootImage("Attacks/EnemyTackle/attack9.png");
    static GreenfootImage image10 = new GreenfootImage("FalseCursorFight.png");
    static GreenfootImage image11 = new GreenfootImage("FalseCursorFight.png");
    static GreenfootImage image12 = new GreenfootImage("FalseCursorFight.png");
    static GreenfootImage image13 = new GreenfootImage("FalseCursorFight.png");
    static GreenfootImage image14 = new GreenfootImage("FalseCursorFight.png");
    static GreenfootImage image15 = new GreenfootImage("FalseCursorFight.png");
    static GreenfootImage image16 = new GreenfootImage("FalseCursorFight.png");
    static GreenfootImage image17 = new GreenfootImage("FalseCursorFight.png");
    public final int pp = 35;
    public final int power = 40;
    public final int accuracy = 95;
    public final String category = "PHYSICAL";
    public final String type = "NORMAL";
    public static double effectiveness;
    public boolean isSurprise;
    private int time = 49;
    public void act()
    {
        checkEnemyPokemon();
        time--;
        if(isSurprise == false)
        {
            if(time == 48)
            {
                if(DataSound.effectAttackTackle.isPlaying() == false)
                    DataSound.effectAttackTackle.play();
                setImage(image2);
                ((WorldWildBattle)getWorld()).overlayFightText();
                OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
                oft.enemyattack = "Tackle";
                oft.enemyattacktime = 150;
                oft.enemyeffective = effectiveness;
                DataWildPokemon dwp = getWorld().getObjects(DataWildPokemon.class).get(0);
                dwp.attackpower = power;
                dwp.attackpp = pp;
                dwp.attackaccuracy = accuracy;
                dwp.attackcategory = category;
                dwp.attacktype = type;
                dwp.attackeffectiveness = effectiveness;
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
        else if(isSurprise == true)
        {
            if(time == 48)
            {
                if(DataSound.effectAttackTackle.isPlaying() == false)
                    DataSound.effectAttackTackle.play();
                setImage(image2);
                ((WorldWildBattle)getWorld()).overlayFightText();
                OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
                oft.enemyattack = "Tackle";
                oft.enemyattacktime = 150;
                DataWildPokemon dwp = getWorld().getObjects(DataWildPokemon.class).get(0);
                dwp.attackpower = power;
                dwp.attackpp = pp;
                dwp.attackaccuracy = accuracy;
                dwp.attackcategory = category;
                dwp.attacktype = type;
                dwp.attackeffectiveness = effectiveness;
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
    }
    public void checkEnemyPokemon()
    {
        DataPokemon dp = getWorld().getObjects(DataPokemon.class).get(0);
        if(dp.type == "ROCK" || dp.type == "STEEL")
            effectiveness = 0.5;
        else if(dp.type == null)
            effectiveness = 2;
        else
            effectiveness = 1;
    }
    public void getAttacksInfo()
    {
        isSurprise = CursorFight.isSurprise;
    }
}
