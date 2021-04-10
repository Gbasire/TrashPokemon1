
import greenfoot.*;
public class DataWildPokemon extends Data
{
    public int pokemon = Greenfoot.getRandomNumber(10);
    private int time = 1;
    public static String name;
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
    public int randomAttack;
    public void act()
    {
        getPokemon();
        time--;
        if(hp < 1)
            hp = 0;
        if(time == 0)
            getPokemonData();
        sendData();
    }
    public void chooseAttack()
    {
        randomAttack = Greenfoot.getRandomNumber(10);
        if(randomAttack < 6)
        {
            if(attack1 == "ROCKTOMB" || attack2 == "ROCKTOMB")
            {
                getWorld().addObject(new EnemyAttackRockTomb(), 200, 300);
                EnemyAttackRockTomb rocktomb = (EnemyAttackRockTomb)getWorld().getObjects(EnemyAttackRockTomb.class).get(0);
                rocktomb.isSurprise = false;
            }
        }
        else if(randomAttack > 5)
        {
            if(attack1 == "TACKLE" || attack2 == "TACKLE")
            {
                getWorld().addObject(new EnemyAttackTackle(), 200, 300);
                EnemyAttackTackle tackle = (EnemyAttackTackle)getWorld().getObjects(EnemyAttackTackle.class).get(0);
                tackle.isSurprise = false;
            }
        }
    }
    public void chooseSurpriseAttack()
    {
        randomAttack = Greenfoot.getRandomNumber(10);
        if(randomAttack < 6)
        {
            if(attack1 == "ROCKTOMB")
            {
                getWorld().addObject(new EnemyAttackRockTomb(), 200, 300);
                EnemyAttackRockTomb rocktomb = (EnemyAttackRockTomb)getWorld().getObjects(EnemyAttackRockTomb.class).get(0);
                rocktomb.isSurprise = true;
            }
        }
        else if(randomAttack > 5)
        {
            if(attack1 == "TACKLE" || attack2 == "TACKLE")
            {
                getWorld().addObject(new EnemyAttackTackle(), 200, 300);
                EnemyAttackTackle tackle = (EnemyAttackTackle)getWorld().getObjects(EnemyAttackTackle.class).get(0);
                tackle.isSurprise = false;
            }
        }
    }
    public void attack()
    {
        int damage = attackpower;
        if(attackcategory == "PHYSICAL")
            damage = damage * attack/DataPokemon.defense;
        else if(attackcategory == "SPECIAL")
            damage = damage * specialattack/DataPokemon.specialdefense;
        if(attackeffectiveness == 2)
            damage *= 2;
        else if(attackeffectiveness == 0.5)
            damage /= 2;
        if(damage < 1)
            damage = 1;
        damage += (Greenfoot.getRandomNumber(damage / 3) - (damage / 6));
        damage = damage * (Greenfoot.getRandomNumber(38)+217);
        damage = damage / 255;
        if(damage > 0)
        {
            DataPokemon.hp -= damage;
            HPPlayerBar hpbar = (HPPlayerBar)getWorld().getObjects(HPPlayerBar.class).get(0);
            hpbar.damage = damage;
        }
        if(DataPokemon.hp < 1)
        {
            PokemonPlayer pokemonplayer = (PokemonPlayer)getWorld().getObjects(PokemonPlayer.class).get(0);
            pokemonplayer.time = 1;
        }
    }
    public void endTurn()
    {
        CursorFight.isFighting = false;
    }
    public void getPokemon()
    {
        if(pokemon < 11)
            name = "GEODUDE";
    }
    public void getPokemonData()
    {
        if(name == "GEODUDE")
        {
            PokemonGeodude geodude = (PokemonGeodude)getWorld().getObjects(PokemonGeodude.class).get(0);
            basehp = geodude.basehp;
            hp = geodude.hp;
            attack = geodude.attack;
            specialattack = geodude.specialattack;
            defense = geodude.defense;
            specialdefense = geodude.specialdefense;
            speed = geodude.speed;
            type = geodude.type;
            attack1 = geodude.attack1;
            attack2 = geodude.attack2;
        }
    }
    public void sendData()
    {
        if(getWorld().getObjects(PokemonEnemy.class).size() > 0)
        {
            PokemonEnemy pokemonenemy = (PokemonEnemy)getWorld().getObjects(PokemonEnemy.class).get(0);
            pokemonenemy.name = name;
        }
    }
}
