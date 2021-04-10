import greenfoot.*;
public class WorldMenuGame extends World
{
    MenuPoweredText menupoweredtext = new MenuPoweredText();
    TransitionFade tf = new TransitionFade();
    public WorldMenuGame()
    {    
        super(755, 570, 1);
        prepare();
        Greenfoot.start();
    }
    public void prepare()
    {
        addObject(new MenuGameText(), 377, 280);
        addObject(new MenuTrashText(), 755, 280);
        addObject(new MenuPokemonText(), 0, 280);
        addObject(new PokemonEmboar(), 0, 0);
        addObject(new PokemonGeodude(), 0, 0);
        addObject(new DataSound(), 0, 0);
        DataPokemon datapokemon = new DataPokemon();
        addObject(datapokemon, 0, 0);
        datapokemon.getPokemonData();
    }
    public void transition()
    {
        addObject(tf, 377, 280);
    }
}
