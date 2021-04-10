import greenfoot.*;
public class ObjectItem extends WorldObjects
{
    static GreenfootImage potion = new GreenfootImage("Objects/Item/ItemPotion.png");
    static GreenfootImage superPotion = new GreenfootImage("Objects/Item/ItemSuperPotion.png");
    static GreenfootImage pokeBall = new GreenfootImage("Objects/Item/ItemPokeBall.png");
    public String object;
    public int number;
    public int place;
    public ObjectItem(String object, int number, int place)
    {
        objectCenter = 15;
        this.object = object;
        this.number = number;
        this.place = place;
        if(object == "potion")
            setImage(potion);
        else if(object == "super potion")
            setImage(superPotion);
        else if(object == "pokeball")
            setImage(pokeBall);
    }
    public void act()
    {
        checkPlayer();
        collide();
        obtainItem();
    }
    public void obtainItem()
    {
        if(isInRange() == true && Boy.canInteract == true && Greenfoot.isKeyDown("enter"))
        {
            overlayText();
            OverlayText overlaytext = (OverlayText)getWorld().getObjects(OverlayText.class).get(0);
            overlaytext.object = object;
            overlaytext.number = number;
            overlaytext.objecttime = 50;
            sendWorldPlace();
            getWorld().removeObject(this);
        }
    }
    public void sendWorldPlace()
    {
        if(this.getWorld().getClass() == WorldTest.class)
        {
            if(place == 1)
                WorldTest.object1WasTaken = true;
            else if(place == 2)
                WorldTest.object2WasTaken = true;
        }
        else if(this.getWorld().getClass() == WorldTown.class)
        {
            if(place == 1)
                WorldTown.object1WasTaken = true;
            else if(place == 2)
                WorldTown.object2WasTaken = true;
        }
        else if(this.getWorld().getClass() == WorldRoute.class)
        {
            if(place == 1)
                WorldRoute.object1WasTaken = true;
            else if(place == 2)
                WorldRoute.object2WasTaken = true;
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
