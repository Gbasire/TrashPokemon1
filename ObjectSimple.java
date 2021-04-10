import greenfoot.*;
public class ObjectSimple extends WorldObjects
{
    public static GreenfootImage centerTable = new GreenfootImage("Objects/Simple/CenterTable.png");
    public static GreenfootImage houseTable = new GreenfootImage("Objects/Simple/HouseTable.png");
    public static GreenfootImage flowerPot = new GreenfootImage("Objects/Simple/FlowerPot.png");
    public static GreenfootImage houseSink = new GreenfootImage("Objects/Simple/HouseSink.png");
    public static GreenfootImage chairLeft = new GreenfootImage("Objects/Simple/ChairLeft.png");
    public static GreenfootImage chairRight = new GreenfootImage("Objects/Simple/ChairRight.png");
    public static GreenfootImage bookShelf = new GreenfootImage("Objects/Simple/BookShelf.png");
    public static GreenfootImage wallBackHouse = new GreenfootImage("Objects/Simple/WallBackHouse.png");
    public static GreenfootImage wallBackCenter = new GreenfootImage("Objects/Simple/WallBackCenter.png");
    public static GreenfootImage treeLine6 = new GreenfootImage("Objects/Simple/TreeLine6.png");
    public static GreenfootImage buildCenterUp = new GreenfootImage("Objects/Builds/CenterPokemon/CenterUp.png");
    public static GreenfootImage buildCenterLeft = new GreenfootImage("Objects/Builds/CenterPokemon/CenterLeft.png");
    public static GreenfootImage buildCenterRight = new GreenfootImage("Objects/Builds/CenterPokemon/CenterRight.png");
    public static GreenfootImage buildHomePlayerUp = new GreenfootImage("Objects/Builds/HomePlayer/HomePlayerUp.png");
    public static GreenfootImage buildHomePlayerLeft = new GreenfootImage("Objects/Builds/HomePlayer/HomePlayerLeft.png");
    public static GreenfootImage buildHomePlayerRight = new GreenfootImage("Objects/Builds/HomePlayer/HomePlayerRight.png");
    public ObjectSimple()
    {

    }
    public ObjectSimple(GreenfootImage object)
    {
        setImage(object);
        if(object == centerTable)
            objectCenter = 25;
        else if(object == houseTable)
            objectCenter = 27;
        else if(object == flowerPot)
            objectCenter = 25;
        else if(object == houseSink)
            objectCenter = 20;
        else if(object == chairLeft)
            objectCenter = 15;
        else if(object == chairRight)
            objectCenter = 15;
        else if(object == bookShelf)
            objectCenter = 25;
        else if(object == treeLine6)
            objectCenter = 50;
        else if(object == wallBackHouse)
            objectCenter = 20;
        else if(object == wallBackCenter)
            objectCenter = 20;
        else if(object == buildCenterUp)
            objectCenter = 75;
        else if(object == buildCenterLeft)
            objectCenter = 75;
        else if(object == buildCenterRight)
            objectCenter = 75;
        else if(object == buildHomePlayerUp)
            objectCenter = 75;
        else if(object == buildHomePlayerLeft)
            objectCenter = 75;
        else if(object == buildHomePlayerRight)
            objectCenter = 75;
    }
    public void act()
    {
        checkPlayer();
        collide();
    }
}
