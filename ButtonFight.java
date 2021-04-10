import greenfoot.*;
public class ButtonFight extends ButtonsMenu
{
    GreenfootImage image1 = new GreenfootImage("Buttons/BattleButtons/ButtonFight.png"); 
    GreenfootImage image2 = new GreenfootImage("Buttons/BattleButtons/ButtonFight1.png");
    public ButtonFight()
    {
        setImage(image1);
    }
    public void act()
    {
        checkCursor();
    }
    public void checkCursor()
    {
        if(isTouching(CursorFight.class))
            setImage(image2);
        else
            setImage(image1);
    }
}
