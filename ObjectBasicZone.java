import greenfoot.*;
public class ObjectBasicZone extends WorldObjects
{
    static GreenfootImage center = new GreenfootImage("Objects/Basic/ZoneCenter.png");
    static GreenfootImage townTrash = new GreenfootImage("Objects/Basic/ZoneTownTrash.png");
    static GreenfootImage route113 = new GreenfootImage("Objects/Basic/ZoneRoute113.png");
    private int time = 200;
    public ObjectBasicZone(GreenfootImage object)
    {
        setImage(object);
    }
    public void act()
    {
        time--;
        if(time == 0)
            getWorld().removeObject(this);
    }
}
