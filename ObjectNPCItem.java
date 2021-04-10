import greenfoot.*;
public class ObjectNPCItem extends WorldObjects
{
    GreenfootImage up;
    GreenfootImage down;
    GreenfootImage left;
    GreenfootImage right;
    public int time = 100;
    public int interactTime;
    public boolean hasInteracted;
    public boolean isTurning;
    public String text1;
    public String text2;
    public String text3;
    public String text4;
    public String text5;
    public String nextText1;
    public String nextText2;
    public int textNumber;
    public int nextTextNumber;
    public String object;
    public int number;
    public int place;
    public ObjectNPCItem(
        String NPC, 
        boolean hasInteracted, 
        boolean isTurning, 
        String direction, 
        String object, 
        int place, 
        int number, 
        String text1, 
        String nextText1)
    {
        objectCenter = 20;
        this.hasInteracted = hasInteracted;
        this.isTurning = isTurning;
        this.object = object;
        this.number = number;
        this.place = place;
        this.text1 = text1;
        this.nextText1 = nextText1;
        this.textNumber = 1;
        this.nextTextNumber = 1;
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
    public ObjectNPCItem(
        String NPC, 
        boolean hasInteracted, 
        boolean isTurning, 
        String direction, 
        String object, 
        int number, 
        int place, 
        int textNumber, 
        int nextTextNumber, 
        String text1, 
        String text2, 
        String text3, 
        String text4, 
        String text5, 
        String nextText1, 
        String nextText2)
    {
        objectCenter = 20;
        this.hasInteracted = hasInteracted;
        this.isTurning = isTurning;
        this.object = object;
        this.number = number;
        this.place = place;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.nextText1 = nextText1;
        this.nextText2 = nextText2;
        this.textNumber = textNumber;
        this.nextTextNumber = nextTextNumber;
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
        interactTime--;
        if(interactTime == 0)
            hasInteracted = true;
        if(isInRange() == true && Boy.canInteract == true && Greenfoot.isKeyDown("enter") && hasInteracted == false)
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
            overlaytext.isThereObject = true;
            overlaytext.object = object;
            overlaytext.number = number;
            interactTime = textNumber * 100 - 1;
            sendWorldPlace();
        }
        else if(isInRange() == true && Boy.canInteract == true && Greenfoot.isKeyDown("enter") && hasInteracted == true)
        {
            facePlayer();
            overlayText();
            OverlayText overlaytext = (OverlayText)getWorld().getObjects(OverlayText.class).get(0);
            overlaytext.texttime = nextTextNumber * 100 - 1;
            overlaytext.text = nextText1;
            overlaytext.text2 = nextText2;
            overlaytext.isThereObject = false;
        }
    }
    public void sendWorldPlace()
    {
        if(this.getWorld().getClass() == WorldTest.class)
        {
            if(place == 1)
                WorldTest.npc1WasTaken = true;
            else if(place == 2)
                WorldTest.npc2WasTaken = true;
        }
        else if(this.getWorld().getClass() == WorldTown.class)
        {
            if(place == 1)
                WorldTown.npc1WasTaken = true;
            else if(place == 2)
                WorldTown.npc2WasTaken = true;
        }
        else if(this.getWorld().getClass() == WorldRoute.class)
        {
            if(place == 1)
                WorldRoute.npc1WasTaken = true;
            else if(place == 2)
                WorldRoute.npc2WasTaken = true;
        }
        else if(this.getWorld().getClass() == WorldCenter.class)
        {
            if(place == 1)
                WorldCenter.npc1WasTaken = true;
            else if(place == 2)
                WorldCenter.npc2WasTaken = true;
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
