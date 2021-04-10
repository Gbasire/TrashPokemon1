import greenfoot.*;
public class PokemonEnemy extends Battle
{
    private int appeartime = 30;
    public int time;
    public String name;
    GreenfootImage geodude = new GreenfootImage("Pokemons/GeodudeFront.png");
    public void act()
    {
        appear();
        if(name == "GEODUDE")
            setImage(geodude);
        if(time > 0)
            pokemonDead();
    }
    public void appear()
    {
        appeartime--;
        if(appeartime > 0)
            setLocation(getX()-1,getY()+1);
    }
    public void pokemonDead()
    {
        time++;
        if(time == 75)
        {
            ((WorldWildBattle)getWorld()).overlayFightText();
            OverlayFightText oft = (OverlayFightText)getWorld().getObjects(OverlayFightText.class).get(0);
            oft.enemydeadtime = 75;
        }
        if(time == 150)
            getImage().setTransparency(0);
    }
}
