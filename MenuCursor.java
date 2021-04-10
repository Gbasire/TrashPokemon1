import greenfoot.*;
public class MenuCursor extends Menu
{
    private int time = 7;
    public void act() 
    {
        checkWorld();
        checkMove();
        checkButton();
    }
    public void checkMove()
    {
        if(Greenfoot.isKeyDown("up") && getY() > 240)
        {
            setLocation(getX(), getY() - 85);
            cursorMoveSound();
        }
        if(Greenfoot.isKeyDown("down") && getY() < 325)
        {
            setLocation(getX(), getY() + 85);
            cursorMoveSound();
        }
    }
    public void checkButton()
    {
        if(isTouching(MenuNewGame.class) && Greenfoot.isKeyDown("enter"))
        {
            ((WorldMenuMain)getWorld()).transition();
            cursorSelectSound();
        }
        if(isTouching(MenuGameOptions.class) && Greenfoot.isKeyDown("enter"))
        {
            cursorSelectSound();
            Greenfoot.setWorld(new WorldMenuOptions());
        }
        if(isTouching(MenuMusic.class) && Greenfoot.isKeyDown("right"))
        {
            time--;
            if(time == 0 && MenuMusicIcon.state < 3)
            {
                MenuMusicIcon.state += 1;
                cursorMoveSound();
                time = 7;
            }
            else if(time == 0)
                time = 7;
        }
        if(isTouching(MenuMusic.class) && Greenfoot.isKeyDown("left"))
        {
            time--;
            if(time == 0 && MenuMusicIcon.state > 0)
            {
                MenuMusicIcon.state -= 1;
                cursorMoveSound();
                time = 7;
            }
            else if(time == 0)
                time = 7;
        }
        if(isTouching(MenuSoundEffects.class) && Greenfoot.isKeyDown("right"))
        {
            time = time - 1;
            if(time == 0 && MenuSoundIcon.state < 3)
            {
                MenuSoundIcon.state += 1;
                cursorMoveSound();
                time = 7;
            }
            else if(time == 0)
                time = 7;
        }
        if(isTouching(MenuSoundEffects.class) && Greenfoot.isKeyDown("left"))
        {
            time--;
            if(time == 0 && MenuSoundIcon.state > 0)
            {
                MenuSoundIcon.state -= 1;
                cursorMoveSound();
                time = 7;
            }
            else if(time == 0)
                time = 7;
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
    public void checkWorld()
    {
        if(getWorld().getClass() == WorldMenuMain.class)
        {
            GreenfootImage image = getImage();
            image.scale(564, 70);
            setImage(image);
        }
        if(getWorld().getClass() == WorldMenuOptions.class)
        {
            GreenfootImage image = getImage();
            image.scale(410, 70);
            setImage(image);
        }
        if(getWorld().getClass() == WorldMenuOptions.class && Greenfoot.isKeyDown("escape"))
            Greenfoot.setWorld(new WorldMenuMain());
    }
}
