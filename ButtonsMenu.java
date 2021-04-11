import greenfoot.GreenfootImage;

public class ButtonsMenu extends Overlay
{
    final GreenfootImage image1, image2;

    public ButtonsMenu(GreenfootImage image1, GreenfootImage image2)
    {
        this.image1 = image1;
        this.image2 = image2;
        setImage(image1);
    }

    public void act()
    {
        checkCursor();
    }

    public void checkCursor()
    {
        setImage(isTouching(CursorFight.class) ? image1 : image2);
    }
}
