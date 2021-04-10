import greenfoot.*;
public class ButtonBlank extends Overlay
{
    GreenfootImage image1 = new GreenfootImage("Buttons/AttackButtons/Blank.png");
    GreenfootImage image2 = new GreenfootImage("Buttons/AttackButtons/Blank1.png");
    public ButtonBlank()
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
