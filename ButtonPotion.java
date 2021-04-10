import greenfoot.*;
public class ButtonPotion extends ButtonsObjects
{
    GreenfootImage image1 = new GreenfootImage("Buttons/ObjectButtons/Potion.png");
    GreenfootImage image2 = new GreenfootImage("Buttons/ObjectButtons/Potion1.png");
    public String object = "potion";
    public int healing = 20;
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
            getWorld().showText("20 hp", 524, 460);
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
            datainventory.usedObject("potion", 1);
            canuse = false;
        }
    }
    public void setUseTime()
    {
        time = 10;
        canuse = false;
    }
}
