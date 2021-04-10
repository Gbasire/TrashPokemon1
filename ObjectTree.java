public class ObjectTree extends ObjectSimple
{
    public ObjectTree()
    {
        objectCenter = 50;
    }
    public void act()
    {
        checkPlayer();
        collide();
    }
}
