public class WorldTown extends OverlayWorld
{
    public static int originalXValue = 350;
    public static int originalYValue = 380;
    public static boolean object1WasTaken;
    public static boolean object2WasTaken;
    public static boolean npc1WasTaken;
    public static boolean npc2WasTaken;
    private int timer = 0;
    OverlayText overlaytext = new OverlayText();
    public WorldTown()
    {
        prepareTrees();
        prepareCenter();
        prepareHomePlayer();
        preparePokemonData();
        prepareData();
        prepare();
        setPaintOrder(Transitions.class, ObjectBasicZone.class, OverlayTextTriangle.class, OverlayText.class, ObjectBasicOver.class, Boy.class);
    }
    public void act()
    {
        timer++;
        if(timer == 1)
            prepareBoy();
    }
    public void prepareTrees()
    {
        addObject(new ObjectSimple(ObjectSimple.treeLine6), 295, 30);
        addObject(new ObjectTree(), 32, 30);
        addObject(new ObjectTree(), 648, 30);
        addObject(new ObjectTree(), 722, 30);
        addObject(new ObjectTree(), 722, 110);
        addObject(new ObjectTree(), 722, 190);
        addObject(new ObjectTree(), 722, 270);
        addObject(new ObjectTree(), 722, 350);
        addObject(new ObjectTree(), 722, 430);
        addObject(new ObjectTree(), 722, 510);
        addObject(new ObjectTree(), 32, 110);
        addObject(new ObjectTree(), 32, 190);
        addObject(new ObjectTree(), 32, 270);
        addObject(new ObjectTree(), 32, 350);
        addObject(new ObjectTree(), 32, 430);
        addObject(new ObjectTree(), 32, 510);
        addObject(new ObjectTreeTop(), 722, 550);
        addObject(new ObjectTreeTop(), 32, 550);
        addObject(new ObjectTreeTop(), 332, 550);
        addObject(new ObjectTreeTop(), 256, 550);
        addObject(new ObjectTreeTop(), 181, 550);
        addObject(new ObjectTreeTop(), 108, 550);
        addObject(new ObjectTreeTop(), 645, 550);
        addObject(new ObjectTreeTop(), 256, 550);
        addObject(new ObjectTreeTop(), 407, 550);
        addObject(new ObjectTreeTop(), 566, 550);
        addObject(new ObjectTreeTop(), 486, 550);
    }
    public void prepare()
    {
        if(object1WasTaken == false)
            addObject(new ObjectItem("potion", 1, 1), 90, 110);
        addObject(new ObjectBasicZone(ObjectBasicZone.townTrash), 377, 280);
        addObject(new ObjectBasic(ObjectBasic.groundPath), 377, 280);
        addObject(new ObjectText(ObjectText.sign, "Route 113"), 514, 105);
        addObject(new ObjectNPC(
            "oldMan", true, "down", 
            "I was a trash pokémon trainer when I was young."), 
            350, 200);
        addObject(new Flower(), 610, 400);
        addObject(new Flower(), 610, 370);
        addObject(new Flower(), 610, 340);
        addObject(new Flower(), 513, 340);
        addObject(new Flower(), 513, 400);
        addObject(new Flower(), 513, 370);
        addObject(new Flower(), 610, 260);
        addObject(new Flower(), 513, 260);
        addObject(new Flower(), 610, 230);
        addObject(new Flower(), 513, 230);
        addObject(new Flower(), 610, 200);
        addObject(new Flower(), 513, 200);
    }
    public void prepareCenter()
    {
        addObject(new DoorCenter(), 199, 241);
        addObject(new ObjectSimple(ObjectSimple.buildCenterLeft), 145, 180);
        addObject(new ObjectSimple(ObjectSimple.buildCenterRight), 253, 180);
        addObject(new ObjectSimple(ObjectSimple.buildCenterUp), 199, 140);
        addObject(new ObjectBasicOver(ObjectBasicOver.buildCenterMiddle), 199, 202);
    }
    public void prepareHomePlayer()
    {
        addObject(new DoorPlayerHome(), 164, 486);
        addObject(new ObjectSimple(ObjectSimple.buildHomePlayerLeft), 129, 425);
        addObject(new ObjectSimple(ObjectSimple.buildHomePlayerRight), 235, 425);
        addObject(new ObjectSimple(ObjectSimple.buildHomePlayerUp), 164, 384);
        addObject(new ObjectBasicOver(ObjectBasicOver.buildHomePlayerMiddle), 164, 446);
    }
    public void prepareBoy()
    {
        addObject(new Boy(), originalXValue, originalYValue);
    }
    public void prepareData()
    {
        addObject(new DataPokemon(), 0, 0);
        addObject(new DataInventory(), 0, 0);
        addObject(new DataWildPokemon(), 0, 0);
        addObject(new DataSound(), 0, 0);
    }
    public void preparePokemonData()
    {
        addObject(new PokemonEmboar(), 0, 0);
        addObject(new PokemonGeodude(), 0, 0);
    }
    @Override
    public void overlayText()
    {
        addObject(overlaytext, 378, 515);
    }
}