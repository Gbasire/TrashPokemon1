public class WorldPlayerRoom extends OverlayWorld
{
    public static int originalXValue = 250;
    public static int originalYValue = 270;
    private int timer = 0;
    public static String previousworld;
    OverlayText overlaytext = new OverlayText();
    public WorldPlayerRoom()
    {
        super(500, 300);
        setPaintOrder(OverlayTextTriangle.class, OverlayText.class, Boy.class);
        prepare();
        prepareData();
        preparePokemonData();
    }
    public void act()
    {
        timer++;
        if(timer == 1)
            prepareBoy();
    }
    public void prepare()
    {
        addObject(new ObjectBasic(ObjectBasic.carpetBig), 230, 163);
        addObject(new ObjectSimple(ObjectSimple.wallBackHouse), 250, 20);
        addObject(new ObjectSimple(ObjectSimple.flowerPot), 17, 270);
        addObject(new ObjectSimple(ObjectSimple.flowerPot), 482, 270);
        addObject(new ObjectSimple(ObjectSimple.houseTable), 230, 163);
        addObject(new ObjectSimple(ObjectSimple.houseSink), 35, 50);
        addObject(new ObjectSimple(ObjectSimple.bookShelf), 105, 45);
        addObject(new ObjectSimple(ObjectSimple.chairLeft), 170, 148);
        addObject(new ObjectSimple(ObjectSimple.chairLeft), 170, 175);
        addObject(new ObjectSimple(ObjectSimple.chairRight), 287, 148);
        addObject(new ObjectSimple(ObjectSimple.chairRight), 287, 175);
        addObject(new ObjectText(ObjectText.houseTV, 2, "New Pokémons have arrived to the region !", "Trash News :", null, null, null), 160, 45);
        addObject(new Carpet(), 250, 307);
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

    @Override
    public void overlayText()
    {
        addObject(overlaytext, 250, 250);
    }
}
