public class WorldTest extends OverlayWorld
{
    public static int originalXValue = 300;
    public static int originalYValue = 200;
    public static boolean object1WasTaken;
    public static boolean object2WasTaken;
    public static boolean npc1WasTaken;
    public static boolean npc2WasTaken;
    OverlayText overlaytext = new OverlayText();
    public WorldTest()
    {
        super(600, 400);
        setPaintOrder(OverlayTextTriangle.class, OverlayText.class, Boy.class, WorldObjects.class);
        prepareBoy();
        prepareData();
        preparePokemonData();
        prepareTests();
    }
    private void prepareBoy()
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
    public void prepareTests()
    {
        if(object1WasTaken == false)
            addObject(new ObjectItem("potion", 1, 1), 100, 100);
        if(object2WasTaken == false)
            addObject(new ObjectItem("super potion", 1, 2), 20, 100);
        addObject(new ObjectSimple(ObjectSimple.centerTable), 400, 100);
        addObject(new ObjectNPCItem(
            "oldMan", npc1WasTaken, true, "down", "potion", 2, 1, 4, 2, 
            "Use them when carefully", "Here are some potions", "My name is bruh", "Hey", null, 
            "Use them when a pokémon is low health", "These potions are useful in combat"
            ), 300, 100);
        addObject(new ObjectText(ObjectText.sign, 2, "World Test", "bruh", null, null, null), 200, 100);
    }

    @Override
    public void overlayText()
    {
        addObject(overlaytext, 300, 345);
    }
}
