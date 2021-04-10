import greenfoot.*;
public class WorldRoute extends World
{
    Dust poussiere = new Dust();
    OverlayText overlaytext = new OverlayText();
    public static int originalXValue = 330;
    public static int originalYValue = 390;
    public static boolean object1WasTaken;
    public static boolean object2WasTaken;
    public static boolean npc1WasTaken;
    public static boolean npc2WasTaken;
    private int timer = 0;
    public WorldRoute()
    {
        super(600, 400, 1);
        setPaintOrder(Transitions.class, ObjectBasicZone.class, OverlayTextTriangle.class, OverlayText.class, ObjectBasicOver.class, Boy.class, Dust.class);
        prepare();
        prepareTrees();
        prepareData();
        preparePokemonData();
    }
    public void act()
    {
        timer++;
        if(timer == 1)
            prepareBoy();
    }
    public void prepareTrees()
    {
        addObject(new ObjectTree(), 35, 30);
        addObject(new ObjectTree(), 35, 110);
        addObject(new ObjectTree(), 35, 190);
        addObject(new ObjectTree(), 35, 270);
        addObject(new ObjectTree(), 35, 350);
        addObject(new ObjectTree(), 570, 30);
        addObject(new ObjectTree(), 570, 110);
        addObject(new ObjectTree(), 570, 190);
        addObject(new ObjectTree(), 570, 270);
        addObject(new ObjectTree(), 570, 350);
        addObject(new ObjectSimple(ObjectSimple.treeLine6), 301, 30);
        addObject(new ObjectTreeBottom(), 493, 370);
        addObject(new ObjectTreeBottom(), 416, 370);
        addObject(new ObjectTreeBottom(), 259, 370);
        addObject(new ObjectTreeBottom(), 182, 370);
        addObject(new ObjectTreeBottom(), 105, 370);
        addObject(new ObjectTreeTop(), 493, 310);
        addObject(new ObjectTreeTop(), 416, 310);
        addObject(new ObjectTreeTop(), 259, 310);
        addObject(new ObjectTreeTop(), 182, 310);
        addObject(new ObjectTreeTop(), 105, 310);
    }
    public void prepare()
    {
        if(object1WasTaken == false)
            addObject(new ObjectItem("super potion", 1, 1), 85, 103);
        addObject(new ObjectBasicZone(ObjectBasicZone.route113), 300, 200);
        addObject(new TallGrass(), 470, 180);
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
    public void prepareBoy()
    {
        addObject(new Boy(), originalXValue, originalYValue);
    }
    public void overlayText()
    {
        addObject(overlaytext, 300, 345);
    }
    public void removeOverlayText()
    {
        removeObject(overlaytext);
    }
    public void prepareTransitionIn()
    {
        addObject(new TransitionIn(), 300, 200);
    }
}
