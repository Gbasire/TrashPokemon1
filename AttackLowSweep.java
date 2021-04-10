import greenfoot.*;
public class AttackLowSweep extends Attacks
{
    private static final GreenfootImage[] IMAGES = new GreenfootImage[17];
    static
    {
        for(int i=0; i<IMAGES.length; i++)
        {
            IMAGES[i] = new GreenfootImage("Attacks/LowSweep/attack" + (i+1) + ".png");
        }
    }

    public AttackLowSweep()
    {
        super("LowSweep", 20, 70, 100, "PHYSICAL", "FIGHTING");
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

    public double checkEnemyPokemonAndGetEffectiveness()
    {
        if(DataWildPokemon.type == "POISON" || DataWildPokemon.type == "FLYING" || DataWildPokemon.type == "BUG" || DataWildPokemon.type == "PSYCHIC")
            return 0.5;
        else if(DataWildPokemon.type == "NORMAL" || DataWildPokemon.type == "DARK" || DataWildPokemon.type == "ICE" || DataWildPokemon.type == "STEEL" || DataWildPokemon.type == "ROCK")
            return 2;
        else return 1;
    }
}
