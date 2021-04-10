import greenfoot.*;
public class DoorCenter extends ObjectSpecial
{
    private int time;
    private int enterTime;
    public DoorCenter()
    {
        objectCenter = 13;
    }
    public void act()
    {
        checkPlayer();
        interact();
        displace();
        if(enterTime > 0)
            enterCenter();
    }
    public void interact()
    {
        Boy boy = (Boy)getWorld().getObjects(Boy.class).get(0);
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
            move(-2);
        else if(time < -40 && getX()<199)
            move(2);
    }
    public void enterCenter()
    {
        Boy boy = (Boy)getWorld().getObjects(Boy.class).get(0);
        boy.speed = 0;
        enterTime--;
        if(enterTime == 49)
            boy.setImage(boy.up);
        else if(enterTime == 35)
            boy.setImage(boy.uprun);
        else if(enterTime == 22)
            boy.setImage(boy.up);
        else if(enterTime == 11)
            boy.setImage(boy.uprun);
        else if(enterTime == 0)
        {
            boy.originalX1 = 199;
            boy.originalY1 = 280;
            boy.setBoyLocation();
            Greenfoot.setWorld(new WorldCenter());
        }
        if(enterTime > 10)
            boy.setLocation(boy.getX(), boy.getY()-1);
    }
}
