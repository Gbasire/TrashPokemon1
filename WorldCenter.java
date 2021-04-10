import greenfoot.*;
public class WorldCenter extends World
{
    public static int originalXValue = 250;
    public static int originalYValue = 270;
    public static boolean npc1WasTaken;
    public static boolean npc2WasTaken;
    private int timer = 0;
    public static String previousworld;
    OverlayText overlaytext = new OverlayText();
    public WorldCenter()
    {
        super(500, 300, 1);
        setPaintOrder(ObjectBasicZone.class, OverlayTextTriangle.class, OverlayText.class, Boy.class);
        prepare();
        preparePokemonData();
        prepareData();
    }
    public void act()
    {
        timer++;
        if(timer == 1)
            prepareBoy();
    }
    public void prepare()
    {
        addObject(new ObjectSimple(ObjectSimple.wallBackCenter), 250, 20);
        addObject(new ObjectSimple(ObjectSimple.bookShelf), 85, 45);
        addObject(new ObjectSimple(ObjectSimple.flowerPot), 30, 45);
        addObject(new ObjectSimple(ObjectSimple.centerTable), 420, 220);
        addObject(new ObjectBasic(ObjectBasic.centerMap), 450, 25);
        addObject(new ObjectBasic(ObjectBasic.couch), 365, 205);
        addObject(new ObjectBasic(ObjectBasic.couch), 365, 235);
        addObject(new ObjectBasic(ObjectBasic.couch), 402, 265);
        addObject(new ObjectBasic(ObjectBasic.couch), 438, 265);
        addObject(new ObjectBasic(ObjectBasic.couch), 30, 95);
        addObject(new ObjectBasic(ObjectBasic.couch), 65, 95);
        addObject(new NPCCenterNurse(), 249, 70);
        addObject(new CenterMain(), 233, 60);
        addObject(new ObjectNPCItem(
            "youngGirl", npc1WasTaken, false, "down", "potion", 2, 1, 3, 1,  
            "Here is a potion !", "I'm in a good day today !", "Hello !", null, null, 
            "I already gave you some potions !", null), 30, 85);
        addObject(new ObjectText(ObjectText.centerPC, "the PC isn't available yet !"), 400, 40);addObject(new Carpet(), 250, 300);
        addObject(new ObjectBasicZone(ObjectBasicZone.center), 250, 150);
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
        if(DataPokemon.hp > 1)
            addObject(new Boy(), originalXValue, originalYValue);
        else
        {
            Boy boy = new Boy();
            addObject(boy, 250, 105);
            Boy.originalX = 330;
            Boy.originalY = 390;
            Boy.originalX1 = 200;
            Boy.originalY1 = 275;
            Boy.originalX2 = 250;
            Boy.originalY2 = 95;
            WorldRoute.originalXValue = 330;
            WorldRoute.originalYValue = 390;
            WorldTown.originalXValue = 200;
            WorldTown.originalYValue = 275;
            boy.setImage(Boy.up);
            Boy.previousworld = "WILDBATTLE";
            overlayText();
            overlaytext.nursetime = 150;
        }
    }
    public void overlayText()
    {
        addObject(overlaytext, 250, 250);
    }
    public void removeOverlayText()
    {
        removeObject(overlaytext);
    }
}
