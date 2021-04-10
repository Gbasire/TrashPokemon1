import greenfoot.*;
public class PokemonPlayer extends Battle
{
    public int time;
    public String name;
    GreenfootImage emboar = new GreenfootImage("Pokemons/EmboarBack.png");
    public void act()
    {
        if(name == "EMBOAR")
            setImage(emboar);
        if(time > 0)
            pokemonDead();
    }
    public void pokemonDead()
    {
        time++;
        if(time == 75)
        {
            ((WorldWildBattle)getWorld()).overlayFightText();
            OverlayFightText oft = (OverlayFightText)getWorld().getObjects(OverlayFightText.class).get(0);
            oft.playerdeadtime = 75;
        }
        if(time == 150)
            getImage().setTransparency(0);
    }
}
