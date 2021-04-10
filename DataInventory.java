public class DataInventory extends Data
{
    public static int potionnumber;
    public static int superpotionnumber;
    public void act()
    {
        sendData();
    }
    public static void foundObject(String object, int number)
    {
        if(object == "potion")
            potionnumber += number;
        if(object == "super potion")
            superpotionnumber += number;
    }
    public static void usedObject(String object, int number)
    {
        if(object == "potion")
            potionnumber -= number;
        if(object == "super potion")
            superpotionnumber -= number;
    }
    public void sendData()
    {
        if(this.getWorld().getClass() == WorldWildBattle.class)
            ((WorldWildBattle)getWorld()).potionnumber = potionnumber;
        if(this.getWorld().getClass() == WorldWildBattle.class)
            ((WorldWildBattle)getWorld()).superpotionnumber = superpotionnumber;
    }
}
