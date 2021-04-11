import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

public abstract class Attacks extends Battle
{
    public final String name;
    public final int pp;
    public final int power;
    public final int accuracy;
    public final String category;
    public final String type;

    private static final int MAX_TIME = 49;
    private int time = MAX_TIME;

    public Attacks(String name, int pp, int power, int accuracy, String category, String type)
    {
        this.name = name;
        this.pp = pp;
        this.power = power;
        this.accuracy = accuracy;
        this.category = category;
        this.type = type;

        setImage(getImage(0));
    }

    public void act()
    {
        time--;
        if(time >= 48)
        {
            getAttackSound().play();
            setImage(getImage(1));
            ((WorldWildBattle)getWorld()).overlayFightText();
            OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
            oft.playerattack = name;
            oft.playerattacktime = 150;
            oft.playereffective = checkEnemyPokemonAndGetEffectiveness();
            DataPokemon.attackpower = power;
            DataPokemon.attackpp = pp;
            DataPokemon.attackaccuracy = accuracy;
            DataPokemon.attackcategory = category;
            DataPokemon.attacktype = type;
            DataPokemon.attackeffectiveness = checkEnemyPokemonAndGetEffectiveness();
        }
        else if(time <= 0)
            getWorld().removeObject(this);
        else
        {
            int imageCount = getImageCount();
            int imageNr = (MAX_TIME - time) * imageCount / MAX_TIME;
            setImage(getImage(Math.min(imageNr, imageCount - 1)));
        }
    }

    public abstract GreenfootSound getAttackSound();

    public abstract double checkEnemyPokemonAndGetEffectiveness();

    public abstract GreenfootImage getImage(int i);

    public abstract int getImageCount();
}
