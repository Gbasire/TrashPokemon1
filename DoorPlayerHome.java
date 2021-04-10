import greenfoot.*;
public class DoorPlayerHome extends ObjectSpecial
{
    private int time;
    private int enterTime;
    public DoorPlayerHome()
    {
        objectCenter = 10;
    }
    public void act()
    {
        checkPlayer();
        interact();
        displace();
        if(enterTime > 0)
            enterHome();
    }
    public void interact()
    {
        if(isTouching(Boy.class) && playery < getY() + objectCenter)
        {
            time = 10;
            enterTime = 50;
            Boy.previousworld = "TOWN";
        }
    }
    public void displace()
    {
        time--;
        if(time > 0)
            move(2);
        else if(time < -40 && getX()<164)
            move(-2);
    }
    public void enterHome()
    {
        Boy boy = (Boy)getWorld().getObjects(Boy.class).get(0);
        boy.speed = 0;
        enterTime--;
        if(enterTime == 49)
            boy.setImage(Boy.up);
        else if(enterTime == 35)
            boy.setImage(Boy.uprun);
        else if(enterTime == 22)
            boy.setImage(Boy.up);
        else if(enterTime == 11)
            boy.setImage(Boy.uprun);
        else if(enterTime == 0)
        {
            Boy.originalX1 = 165;
            Boy.originalY1 = 524;
            boy.setBoyLocation();
            Greenfoot.setWorld(new WorldPlayerRoom());
        }
        if(enterTime > 10)
            boy.setLocation(boy.getX(), boy.getY()-1);
    }
}

