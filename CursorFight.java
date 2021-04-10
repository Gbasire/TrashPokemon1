import greenfoot.*;
public class CursorFight extends Overlay
{
    public static boolean isFighting;
    public int randomrun = Greenfoot.getRandomNumber(10);
    public static boolean isSurprise;
    public CursorFight()
    {
        isFighting = false;
    }
    public void act()
    {
        checkMove();
        checkAction();
        setMenu();
        infoTextMenu();
    }
    public void checkMove()
    {
        if(Greenfoot.isKeyDown("right") && isFighting == false && getX()<300)
        {
            move(250);
            cursorMoveSound();
        }
        if(Greenfoot.isKeyDown("left") && isFighting == false && getX()>300)
        {
            move(-250);
            cursorMoveSound();
        }
        if(Greenfoot.isKeyDown("up") && isFighting == false && getY()>450)
        {
            setLocation(getX(), getY()-100);
            cursorMoveSound();
        }
        if(Greenfoot.isKeyDown("down") && isFighting == false && getY()<450)
        {
            setLocation(getX(), getY()+100);
            cursorMoveSound();
        }
    }
    public void checkAction()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            if(isTouching(ButtonFight.class))
            {
                cursorSelectSound();
                ((WorldWildBattle)getWorld()).setFightMenu();
                getWorld().getObjects(ButtonFlameThrower.class).get(0).setAttackTime();
                getWorld().getObjects(ButtonLowSweep.class).get(0).setAttackTime();
            }
            if(isTouching(ButtonBag.class))
            {
                cursorSelectSound();
                ((WorldWildBattle)getWorld()).setBagMenu();
                if(getWorld().getObjects(ButtonPotion.class).size() > 0)
                    getWorld().getObjects(ButtonPotion.class).get(0).setUseTime();
            }
            if(isTouching(ButtonRun.class))
            {
                if(randomrun < 7)
                {
                    cursorSelectSound();
                    ((WorldWildBattle)getWorld()).removeMenu();
                    ((WorldWildBattle)getWorld()).overlayFightText();
                    OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
                    oft.runtime = 50;
                }
                else
                {
                    cursorSelectSound();
                    isSurprise = true;
                    ((WorldWildBattle)getWorld()).removeMenu();
                    ((WorldWildBattle)getWorld()).overlayFightText();
                    OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
                    oft.surprisetime = 100;
                    setSurpriseRun();
                }
            }
        }
    }
    public void setMenu()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            if(isTouching(ButtonRun.class) || isTouching(ButtonBag.class) || isTouching(ButtonPoke.class) || isTouching(ButtonPoke.class))
            {
            }
            else if(getWorld().getObjects(OverlayFightText.class).size()>0)
            {
            }
            else if(isFighting == false)
            {
                ((WorldWildBattle)getWorld()).setMenu();
            }
        }
    }
    public void infoTextMenu()
    {
        if(isTouching(ButtonRun.class))
        {
            getWorld().showText("run from", 523, 440);
            getWorld().showText(" battle", 524, 460);
        }
        if(isTouching(ButtonFight.class))
        {
            getWorld().showText("attack", 523, 440);
            getWorld().showText("the enemy", 524, 460);
        }
        if(isTouching(ButtonPoke.class))
        {
            getWorld().showText("change", 523, 440);
            getWorld().showText("pokemon", 524, 460);
        }
        if(isTouching(ButtonBag.class))
        {
            getWorld().showText("use an", 523, 440);
            getWorld().showText("object", 524, 460);
        }
        if(isTouching(ButtonBlank.class))
        {
            getWorld().showText("", 523, 440);
            getWorld().showText("", 524, 460);
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
    public static void cursorSelectSound()
    {
        if(DataSound.effectMenuChoose.isPlaying() == false)
            DataSound.effectMenuChoose.play();
    }
    public void setSurpriseRun()
    {
        randomrun = Greenfoot.getRandomNumber(10);
    }
}
