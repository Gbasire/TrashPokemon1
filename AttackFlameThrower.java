import greenfoot.*;
public class AttackFlameThrower extends Attacks
{
    private static final GreenfootImage[] IMAGES = new GreenfootImage[17];
    static
    {
        for(int i = 0; i < IMAGES.length; i++)
        {
            IMAGES[i] = new GreenfootImage("Attacks/Flamethrower/attack" + (i + 1) + ".png");
        }
    }

    public AttackFlameThrower()
    {
        super("FlameThrower", 15, 95, 100, "PHYSICAL", "FIRE");
    }

    @Override
    public GreenfootImage getImage(int i)
    {
        return IMAGES[i];
    }

    @Override
    public int getImageCount()
    {
        return IMAGES.length;
    }

    @Override
    public double checkEnemyPokemonAndGetEffectiveness()
    {
        if(DataWildPokemon.type == "ROCK" || DataWildPokemon.type == "WATER" || DataWildPokemon.type == "FIRE" || DataWildPokemon.type == "DRAGON")
            return 0.5;
        else if(DataWildPokemon.type == "GRASS" || DataWildPokemon.type == "BUG" || DataWildPokemon.type == "ICE" || DataWildPokemon.type == "STEEL")
            return 2;
        else 
            return 1;
    }
}
