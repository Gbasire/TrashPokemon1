import greenfoot.GreenfootImage;

public abstract class Attacks extends Battle
{
    public final String name;
    public final int pp;
    public final int power;
    public final int accuracy;
    public final String category;
    public final String type;
    public double effectiveness;

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
        checkEnemyPokemonAndGetEffectiveness();
        time--;
        if(time >= 48)
        {
            if(DataSound.effectAttackFlameThrower.isPlaying() == false) 
                DataSound.effectAttackFlameThrower.play();
            setImage(getImage(1));
            ((WorldWildBattle)getWorld()).overlayFightText();
            OverlayFightText oft = getWorld().getObjects(OverlayFightText.class).get(0);
            oft.playerattack = "FlameThrower";
            oft.playerattacktime = 150;
            oft.playereffective = effectiveness;
            DataPokemon.attackpower = power;
            DataPokemon.attackpp = pp;
            DataPokemon.attackaccuracy = accuracy;
            DataPokemon.attackcategory = category;
            DataPokemon.attacktype = type;
            DataPokemon.attackeffectiveness = effectiveness;
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

    public abstract double checkEnemyPokemonAndGetEffectiveness();

    public abstract GreenfootImage getImage(int i);

    public abstract int getImageCount();
}
