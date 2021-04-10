import greenfoot.*;
public class OverlayText extends Actor
{
    OverlayTextTriangle triangle = new OverlayTextTriangle();
    public int objecttime;
    public String object;
    public int number;
    String objectText = "You obtained "+number+" "+object +"(s)";
    String nurseText;
    public int texttime;
    public String text;
    public String text2;
    public String text3;
    public String text4;
    public String text5;
    public String writing = "";
    public int texti = 0;
    public int nursetime;
    public boolean isThereObject = false;
    public void act()
    {
        Boy.canInteract = false;
        checkWorld();
        checkTimes();
    }
    public void displayObjectText()
    {
        objectText = "You obtained "+number+" "+object +"(s)";
        objecttime--;
        stopPlayer();
        if(objecttime > 0 && objecttime < 50)
            animateText(objectText);
        if(objecttime == 0 && Greenfoot.isKeyDown("enter"))
        {
            objectText = "";
            resetAnimation();
            DataInventory.foundObject(object, number);
            getWorld().showText("", getX(), getY());
            resumePlayer();
            removeThis();
        }
        else if(objecttime == 0)
        {
            addTriangle();
            objecttime++;
        }
    }
    public void displayText()
    {
        texttime--;
        stopPlayer();
        if(texttime > 399 && texttime < 499)
            animateText(text5);
        if(texttime == 399 && Greenfoot.isKeyDown("enter"))
            resetAnimation();
        else if(texttime == 399)
        {
            addTriangle();
            texttime++;
        }
        if(texttime > 299 && texttime < 399)
            animateText(text4);
        if(texttime == 299 && Greenfoot.isKeyDown("enter"))
            resetAnimation();
        else if(texttime == 299)
        {
            addTriangle();
            texttime++;
        }
        if(texttime > 199 && texttime < 299)
            animateText(text3);
        if(texttime == 199 && Greenfoot.isKeyDown("enter"))
            resetAnimation();
        else if(texttime == 199)
        {
            addTriangle();
            texttime++;
        }
        if(texttime > 99 && texttime < 199)
            animateText(text2);
        if(texttime == 99 && Greenfoot.isKeyDown("enter"))
        {
            resetAnimation();
        }
        else if(texttime == 99)
        {
            addTriangle();
            texttime++;
        }
        if(texttime > 0 && texttime < 99)
            animateText(text);
        if(texttime == 0 && Greenfoot.isKeyDown("enter"))
        {
            if(isThereObject == true)
            {
                resetAnimation();
                objecttime = 50;
            }
            else
            {
                resetAnimation();
                getWorld().showText("", getX(), getY());
                resumePlayer();
                removeThis();
            }
        }
        else if(texttime == 0)
        {
            addTriangle();
            texttime++;
        }
    }
    public void displayNurseText()
    {
        nursetime--;
        stopPlayer();
        if(nursetime == 149)
        {
            NPCCenterNurse nurse = getWorld().getObjects(NPCCenterNurse.class).get(0);
            nurse.nursetime = 150;
            CenterMain main = getWorld().getObjects(CenterMain.class).get(0);
            main.time = 150;
        }
        if(nursetime > 74 && nursetime < 150)
        {
            nurseText = "Welcome to the Trash Pokemon Center !";
            animateText(nurseText);
        }
        if(nursetime == 74 && Greenfoot.isKeyDown("enter"))
            resetAnimation();
        else if(nursetime == 74)
        {
            addTriangle();
            nursetime++;
        }
        if(nursetime > 0 && nursetime < 75)
        {
            nurseText = "Your Pokemon has been healed !";
            animateText(nurseText);
            DataPokemon.hp = DataPokemon.basehp;
        }
        if(nursetime == 00 && Greenfoot.isKeyDown("enter"))
        {
            nurseText = "";
            resetAnimation();
            getWorld().showText("", getX(), getY());
            resumePlayer();
            removeThis();
        }
        else if(nursetime == 00)
        {
            addTriangle();
            nursetime++;
        }
    }
    public void animateText(String animation)
    {
        char[] letters = animation.toCharArray();
        int length = animation.length();
        if(texti < length)
        {
            writing += letters[texti];
            texti++;
        }
        getWorld().showText(writing, getX(), getY());
    }
    public void resetAnimation()
    {
        writing = "";
        texti = 0;
    }
    public void checkTimes()
    {
        if(objecttime > 0)
            displayObjectText();
        if(texttime > 0)
            displayText();
        if(nursetime > 0)
            displayNurseText();
    }
    public void removeThis()
    {
        if(getWorld() instanceof OverlayWorld)
            ((OverlayWorld)getWorld()).removeOverlayText();
    }
    public void checkWorld()
    {
        if(getWorld().getClass() == WorldTest.class || getWorld().getClass() == WorldRoute.class)
        {
            GreenfootImage image = getImage();
            image.scale(600, 100);
            setImage(image);
        }
        if(getWorld().getClass() == WorldTown.class)
        {
            GreenfootImage image = getImage();
            image.scale(700, 115);
            setImage(image);
        }
        if(getWorld().getClass() == WorldCenter.class || getWorld().getClass() == WorldPlayerRoom.class)
        {
            GreenfootImage image = getImage();
            image.scale(480, 78);
            setImage(image);
        }
    }
    public void addTriangle()
    {
        if(getWorld().getClass() == WorldTest.class || getWorld().getClass() == WorldRoute.class)
            getWorld().addObject(triangle, 560, 370);
        if(getWorld().getClass() == WorldTown.class)
            getWorld().addObject(triangle, 685, 545);
        if(getWorld().getClass() == WorldCenter.class || getWorld().getClass() == WorldPlayerRoom.class)
            getWorld().addObject(triangle, 460, 270);
    }
    public void stopPlayer()
    {
        Boy boy = getWorld().getObjects(Boy.class).get(0);
        boy.speed = 0;
        boy.setImage(Boy.lastimage);
    }
    public void resumePlayer()
    {
        Boy boy = getWorld().getObjects(Boy.class).get(0);
        boy.speed = 2;
        boy.interactTime = 10;
    }
}
