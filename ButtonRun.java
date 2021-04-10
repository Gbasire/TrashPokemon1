import greenfoot.*;
public class ButtonRun extends ButtonsMenu
{
    GreenfootImage image1 = new GreenfootImage("Buttons/BattleButtons/ButtonRun.png"); 
    GreenfootImage image2 = new GreenfootImage("Buttons/BattleButtons/ButtonRun1.png");
    public ButtonRun()
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
