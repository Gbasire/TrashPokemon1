import greenfoot.*;
public class MenuMusicIcon extends MenuOptions
{
    GreenfootImage sound0 = new GreenfootImage("menuson0.png");
    GreenfootImage sound1 = new GreenfootImage("menuson1.png");
    GreenfootImage sound2 = new GreenfootImage("menuson2.png");
    GreenfootImage sound3 = new GreenfootImage("menuson3.png");
    public static int state = 3;
    public MenuMusicIcon()
    {
        setImage(sound3);
    }
    public void act()
    {
        checkState();
    }
    public void checkState()
    {
        if(state == 3)
        {
            setImage(sound3);
            DataSound.setMusicVolume(100);
        }
        else if(state == 2)
        {
            setImage(sound2);
            DataSound.setMusicVolume(66);
        }
        else if(state == 1)
        {
            setImage(sound1);
            DataSound.setMusicVolume(33);
        }
        else if(state == 0)
        {
            setImage(sound0);
            DataSound.setMusicVolume(0);
        }
    }
}
