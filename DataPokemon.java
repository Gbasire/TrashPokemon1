import greenfoot.*;
public class DataPokemon extends Data
{
    public static String name = "EMBOAR";
    public static int basehp;
    public static int hp;
    public static int attack;
    public static int specialattack;
    public static int defense;
    public static int specialdefense;
    public static int speed;
    public static String type;
    public static String attack1;
    public static String attack2;
    public static int attackpp;
    public static int attackpower;
    public static int attackaccuracy;
    public static String attackcategory;
    public static String attacktype;
    public static double attackeffectiveness;
    public static int objecthealing;
    public void act()
    {
        sendData();
        if(hp < 1)
            hp = 0;
    }
    public void getPokemonData()
    {
        if(name == "EMBOAR")
        {
            PokemonEmboar emboar = (PokemonEmboar)getWorld().getObjects(PokemonEmboar.class).get(0);
            basehp = emboar.basehp;
            hp = emboar.hp;
            attack = emboar.attack;
            specialattack = emboar.specialattack;
            defense = emboar.defense;
            specialdefense = emboar.specialdefense;
            speed = emboar.speed;
            type = emboar.type;
            attack1 = emboar.attack1;
            attack2 = emboar.attack2;
        }
    }
    public void sendData()
    {
        if(getWorld().getObjects(PokemonPlayer.class).size() > 0)
        {
            PokemonPlayer pokemonplayer = (PokemonPlayer)getWorld().getObjects(PokemonPlayer.class).get(0);
            pokemonplayer.name = name;
        }
    }
    public void attack()
    {
        int damage = attackpower;
        if(attackcategory == "PHYSICAL")
            damage = damage * attack/DataWildPokemon.defense;
        else if(attackcategory == "SPECIAL")
            damage = damage * specialattack/DataWildPokemon.specialdefense;
        if(attackeffectiveness == 2)
            damage *= 2;
        else if(attackeffectiveness == 0.5)
            damage /= 2;
        damage += (Greenfoot.getRandomNumber(damage / 3) - (damage / 6));
        damage = damage * (Greenfoot.getRandomNumber(38)+217);
        damage = damage / 255;
        if(damage < 1)
            damage = 1;
        if(damage > 0)
        {
            DataWildPokemon.hp = DataWildPokemon.hp - damage;
            HPEnemyBar hpbar = (HPEnemyBar)getWorld().getObjects(HPEnemyBar.class).get(0);
            hpbar.damage = damage;
        }
        if(DataWildPokemon.hp < 1)
        {
            PokemonEnemy pokemonenemy = (PokemonEnemy)getWorld().getObjects(PokemonEnemy.class).get(0);
            pokemonenemy.time = 1;
        }
    }
    public void useHealing()
    {
        int healing = objecthealing;
        hp += objecthealing;
        HPPlayerBar hpbar = (HPPlayerBar)getWorld().getObjects(HPPlayerBar.class).get(0);
        if(hp >= basehp)
            hp = basehp;
        hpbar.damage = -healing;
    }
    public void endTurn()
    {
        DataWildPokemon wildpokemon = (DataWildPokemon)getWorld().getObjects(DataWildPokemon.class).get(0);
        wildpokemon.chooseAttack();
    }
}
