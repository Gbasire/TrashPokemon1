import greenfoot.*;
public class ButtonSuperPotion extends ButtonsObjects
{
    GreenfootImage image1 = new GreenfootImage("Buttons/ObjectButtons/SuperPotion.png");
    GreenfootImage image2 = new GreenfootImage("Buttons/ObjectButtons/SuperPotion1.png");
    public String object = "super potion";
    public int healing = 50;
    public boolean canuse = false;
    private int time = 10;
    public void act()
    {
        checkCursor();
        checkAction();
        time--;
        if(time == 0)
            canuse = true;
    }
    public void checkCursor()
    {
        if(isTouching(CursorFight.class))
            setImage(image2);
        else
            setImage(image1);
        if(isTouching(CursorFight.class))
        {
            getWorld().showText("heal", 523, 440);
            getWorld().showText("50 hp", 524, 460);
        }
    }
    public void checkAction()
    {
        if(isTouching(CursorFight.class) && Greenfoot.isKeyDown("enter") && canuse == true)
        {
            CursorFight.cursorSelectSound();
            ((WorldWildBattle)getWorld()).overlayFightText();
            OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
            oft.healingobject = object;
            oft.healingamount = healing;
            oft.healingtime = 150;
            CursorFight.isFighting = true;
            DataInventory datainventory = getWorld().getObjects(DataInventory.class).get(0);
            datainventory.usedObject("super potion", 1);
            canuse = false;
        }
    }
    public void setUseTime()
    {
        time = 10;
        canuse = false;
    }
}
