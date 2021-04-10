import greenfoot.*;
public class HPPlayerBar extends Battle
{
    GreenfootImage full = new GreenfootImage("hpBar.png");
    GreenfootImage half = new GreenfootImage("hpBar1.png");
    GreenfootImage low = new GreenfootImage("hpBar2.png");
    public int damage;
    private int time = 2;
    private boolean animFinished;
    public static int hp = DataPokemon.hp;
    public static int basehp = DataPokemon.basehp;
    public static int hpPercentage = hp * 100 / basehp;
    public HPPlayerBar()
    {
        setImage(full);
        animFinished = false;
    }
    public void act()
    {
        time--;
        if(time == 1)
            checkHP();
        animate();
        switchImage();
        hpPercentage = hp * 100 / basehp;
        if(getX() > 527 + ((hpPercentage - 101) / 2) && animFinished == false)
            move(-2);
        else
        {
            animFinished = true;
            showHP();
            setLocation(527 + ((hpPercentage - 101) / 2), 301);
        }
    }
    public void checkHP()
    {
        basehp = DataPokemon.basehp;
        hp = DataPokemon.hp;
    }
    public void animate()
    {
        if(damage > 0)
        {
            hp--;
            damage--;
        }
        if(damage < 0)
        {
            hp++;
            damage++;
        }
    }
    public void showHP()
    {
        if(hp < 0)
            hp = 0;
        if(hp > basehp)
            hp = basehp;
        getWorld().showText(hp + "/" + basehp, 520, 280);
    }
    public void switchImage()
    {
        if(hpPercentage >= 50)
            setImage(full);
        else if(hpPercentage >= 20)
            setImage(half);
        else
            setImage(low);
        if(hpPercentage > 0)
        {
            if(getImage() == full)
            {
                full.scale(hpPercentage, 4);
                setImage(full);
            }
            else if(getImage() == half)
            {
                half.scale(hpPercentage, 4);
                setImage(half);
            }
            else if(getImage() == low)
            {
                low.scale(hpPercentage, 4);
                setImage(low);
            }
        }
        else
        {
            if(getImage() == full)
            {
                full.scale(1, 4);
                setImage(full);
            }
            else if(getImage() == half)
            {
                half.scale(1, 4);
                setImage(half);
            }
            else if(getImage() == low)
            {
                low.scale(1, 4);
                setImage(low);
            }
        }
    }
}
