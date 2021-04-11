import java.util.function.Supplier;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class ButtonsFight extends ButtonsMenu
{
    private int time = 10;
    public final String type;
    public final int power;
    public final int pp;
    public boolean canattack = false;
    private final Supplier<Attacks> attackCreator;

    public ButtonsFight(GreenfootImage image1, GreenfootImage image2, String type, int power, int pp, Supplier<Attacks> attackCreator)
    {
        super(image1, image2);
        this.type = type;
        this.power = power;
        this.pp = pp;
        this.attackCreator = attackCreator;
    }

    @Override
    public void act()
    {
        // This is needed because the super class has also code in the act method
        super.act();

        checkAction();
        time--;
        if(time == 0)
            canattack = true;
    }

    @Override
    public void checkCursor()
    {
        if(isTouching(CursorFight.class))
        {
            setImage(image2);
            getWorld().showText(type, 523, 440);
            getWorld().showText(power + " power", 524, 460);
        }
        else
            setImage(image1);
    }

    public void checkAction()
    {
        if(isTouching(CursorFight.class) && Greenfoot.isKeyDown("enter") && canattack == true)
        {
            CursorFight.cursorSelectSound();
            
            // Call the method on the attack creator -> create new attack object
            getWorld().addObject(attackCreator.get(), 300, 300);
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
