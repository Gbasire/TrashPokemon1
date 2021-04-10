import greenfoot.*;
public class ObjectText extends WorldObjects
{
    static GreenfootImage sign = new GreenfootImage("Objects/Text/Sign.png");
    static GreenfootImage houseTV = new GreenfootImage("Objects/Text/HouseTV.png");
    static GreenfootImage housePC = new GreenfootImage("Objects/Text/HousePC.png");
    static GreenfootImage centerPC = new GreenfootImage("Objects/Text/CenterPC.png");
    public String text1;
    public String text2;
    public String text3;
    public String text4;
    public String text5;
    public int textNumber;
    public ObjectText(GreenfootImage object, String text1)
    {
        this.text1 = text1;
        textNumber = 1;
        setImage(object);
        if(object == sign)
            objectCenter = 20;
        else if(object == houseTV)
            objectCenter = 25;
        else if(object == housePC)
            objectCenter = 25;
        else if(object == centerPC)
            objectCenter = 30;
    }
    public ObjectText(
        GreenfootImage object, 
        int textNumber, 
        String text1, 
        String text2, 
        String text3, 
        String text4, 
        String text5)
    {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.textNumber = textNumber;
        setImage(object);
        if(object == sign)
            objectCenter = 20;
        else if(object == houseTV)
            objectCenter = 25;
        else if(object == housePC)
            objectCenter = 25;
        else if(object == centerPC)
            objectCenter = 30;
    }
    public void act()
    {
        checkPlayer();
        collide();
        interact();
    }
    public void interact()
    {
        if(isInRange() == true && Boy.canInteract == true && Greenfoot.isKeyDown("enter"))
        {
            overlayText();
            OverlayText overlaytext = (OverlayText)getWorld().getObjects(OverlayText.class).get(0);
            overlaytext.texttime = textNumber * 100 - 1;
            overlaytext.text = text1;
            overlaytext.text2 = text2;
            overlaytext.text3 = text3;
            overlaytext.text4 = text4;
            overlaytext.text5 = text5;
            overlaytext.isThereObject = false;
        }
    }
    public boolean isInRange()
    {
        if(playery - getY() < 40 && playery - getY() > -40 && playerx - getX() > -40 && playerx - getX() < 40)
            return true;
        else
            return false;
    }
}
