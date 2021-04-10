import greenfoot.*;
public class ButtonFlameThrower extends ButtonsFight
{
    GreenfootImage image1 = new GreenfootImage("Buttons/AttackButtons/FlameThrower.png");
    GreenfootImage image2 = new GreenfootImage("Buttons/AttackButtons/FlameThrower1.png");
    private int time = 10;
    public String type = "FIRE";
    public int power = 95;
    public int pp = 15;
    public boolean canattack = false;
    public void act()
    {
        checkCursor();
        checkAction();
        time--;
        if(time == 0)
            canattack = true;
    }
    public void checkCursor()
    {
        if(isTouching(CursorFight.class))
            setImage(image2);
        else
            setImage(image1);
        if(isTouching(CursorFight.class))
        {
            getWorld().showText(type, 523, 440);
            getWorld().showText(power + " power", 524, 460);
        }
    }
    public void checkAction()
    {
        if(isTouching(CursorFight.class) && Greenfoot.isKeyDown("enter") && canattack == true)
        {
            CursorFight.cursorSelectSound();
            getWorld().addObject(new AttackFlameThrower(), 300, 300);
            CursorFight.isFighting = true;
            canattack = false;
        }
    }
    public void setAttackTime()
    {
        time = 10;
        canattack = false;
    }
}
