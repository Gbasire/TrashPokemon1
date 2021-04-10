import greenfoot.*;
public class ButtonBag extends ButtonsMenu
{
    GreenfootImage image1 = new GreenfootImage("Buttons/BattleButtons/ButtonBag.png"); 
    GreenfootImage image2 = new GreenfootImage("Buttons/BattleButtons/ButtonBag1.png");
    public ButtonBag()
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
