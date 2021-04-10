import greenfoot.*;
public class MenuCursorGender extends MenuGender
{
    public void act()
    {
        checkMove();
        checkButtons();
    }
    public void checkMove()
    {
        if(Greenfoot.isKeyDown("left") && getX() > 200)
        {
            move(-355);
            cursorMoveSound();
        }
        if(Greenfoot.isKeyDown("right") && getX() < 555)
        {
            move(355);
            cursorMoveSound();
        }
    }
    public void checkButtons()
    {
        if(isTouching(MenuBoy.class) && Greenfoot.isKeyDown("enter"))
        {
            cursorSelectSound();
            Boy.isGirl = false;
            ((WorldMenuGender)getWorld()).transition();
        }
        if(isTouching(MenuGirl.class) && Greenfoot.isKeyDown("enter"))
        {
            cursorSelectSound();
            Boy.isGirl = true;
            ((WorldMenuGender)getWorld()).transition();
        }
    }
    public void cursorMoveSound()
    {
        if(DataSound.effectCursorMove.isPlaying() == false)
            DataSound.effectCursorMove.play();
        else if(DataSound.effectCursorMove1.isPlaying() == false)
            DataSound.effectCursorMove1.play();
        else if(DataSound.effectCursorMove2.isPlaying() == false)
            DataSound.effectCursorMove2.play();
    }
    public void cursorSelectSound()
    {
        if(DataSound.effectMenuChoose.isPlaying() == false)
            DataSound.effectMenuChoose.play();
    }
}
