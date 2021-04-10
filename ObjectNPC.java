import greenfoot.*;
public class ObjectNPC extends WorldObjects
{
    GreenfootImage up;
    GreenfootImage down;
    GreenfootImage left;
    GreenfootImage right;
    public int time = 100;
    public boolean isTurning;
    public String text1;
    public String text2;
    public String text3;
    public String text4;
    public String text5;
    public int textNumber;
    public ObjectNPC(String NPC, boolean isTurning, String direction, String text1)
    {
        objectCenter = 20;
        this.isTurning = isTurning;
        this.text1 = text1;
        this.textNumber = 1;
        if(NPC == "oldMan")
        {
            up = new GreenfootImage("Objects/NPC/OldMan/UpOldMan.png");
            down = new GreenfootImage("Objects/NPC/OldMan/DownOldMan.png");
            left = new GreenfootImage("Objects/NPC/OldMan/LeftOldMan.png");
            right = new GreenfootImage("Objects/NPC/OldMan/RightOldMan.png");
        }
        else if(NPC == "youngGirl")
        {
            up = new GreenfootImage("Objects/NPC/YoungGirl/UpYoungGirl.png");
            down = new GreenfootImage("Objects/NPC/YoungGirl/DownYoungGirl.png");
            left = new GreenfootImage("Objects/NPC/YoungGirl/LeftYoungGirl.png");
            right = new GreenfootImage("Objects/NPC/YoungGirl/RightYoungGirl.png");
        }
        if(direction == "up")
            setImage(up);
        else if(direction == "down")
            setImage(down);
        else if(direction == "left")
            setImage(left);
        else if(direction == "right")
            setImage(right);
    }
    public ObjectNPC(
        String NPC, 
        boolean isTurning, 
        String direction, 
        int textNumber, 
        String text1, 
        String text2, 
        String text3, 
        String text4, 
        String text5)
    {
        objectCenter = 20;
        this.isTurning = isTurning;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.textNumber = textNumber;
        if(NPC == "oldMan")
        {
            up = new GreenfootImage("Objects/NPC/OldMan/UpOldMan.png");
            down = new GreenfootImage("Objects/NPC/OldMan/DownOldMan.png");
            left = new GreenfootImage("Objects/NPC/OldMan/LeftOldMan.png");
            right = new GreenfootImage("Objects/NPC/OldMan/RightOldMan.png");
        }
        else if(NPC == "youngGirl")
        {
            up = new GreenfootImage("Objects/NPC/YoungGirl/UpYoungGirl.png");
            down = new GreenfootImage("Objects/NPC/YoungGirl/DownYoungGirl.png");
            left = new GreenfootImage("Objects/NPC/YoungGirl/LeftYoungGirl.png");
            right = new GreenfootImage("Objects/NPC/YoungGirl/RightYoungGirl.png");
        }
        if(direction == "up")
            setImage(up);
        else if(direction == "down")
            setImage(down);
        else if(direction == "left")
            setImage(left);
        else if(direction == "right")
            setImage(right);
    }
    public void act()
    {
        checkPlayer();
        collide();
        interact();
        if(isTurning == true)
            turn();
    }
    public void turn()
    {
        time--;
        if(time == 0)
        {
            int image = Greenfoot.getRandomNumber(4);
            if(image == 0)
                setImage(down);
            else if(image == 1)
                setImage(left);
            else if(image == 2)
                setImage(right);
            else if(image == 3)
                setImage(up);
            time = 100;
        }
    }
    public void facePlayer()
    {
        time = textNumber * 100;
        if(playery - getY() > 10)
            setImage(down);
        else if(playery - getY() < -30)
            setImage(up);
        else if(playerx - getX() < -10)
            setImage(left);
        else if(playerx - getX() > 10)
            setImage(right);
    }
    public void interact()
    {
        if(isInRange() == true && Boy.canInteract == true && Greenfoot.isKeyDown("enter"))
        {
            facePlayer();
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
