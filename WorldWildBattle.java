import greenfoot.*;
public class WorldWildBattle extends World
{
    ButtonFight buttonfight = new ButtonFight();
    ButtonRun buttonrun = new ButtonRun();
    ButtonBag buttonbag = new ButtonBag();
    ButtonPoke buttonpoke = new ButtonPoke();
    ButtonPotion buttonpotion = new ButtonPotion();
    ButtonSuperPotion buttonsuperpotion = new ButtonSuperPotion();
    ButtonBlank buttonblank0 = new ButtonBlank();
    ButtonBlank buttonblank1 = new ButtonBlank();
    ButtonBlank buttonblank2 = new ButtonBlank();
    ButtonBlank buttonblank3 = new ButtonBlank();
    ButtonFlameThrower buttonflamethrower = new ButtonFlameThrower();
    ButtonLowSweep buttonlowsweep = new ButtonLowSweep();
    OverlayFightText overlayfighttext = new OverlayFightText();
    private int time = 0;
    public int potionnumber;
    public int superpotionnumber;
    public WorldWildBattle()
    {
        super(600, 500, 1);
        prepareScene();
        preparePokemonData();
        prepareData();
        setPaintOrder(Transitions.class, Overlay.class, BallExplosion.class, AttacksEnemy.class, 
        PokemonPlayer.class, Attacks.class, PokemonEnemy.class);
    }
    public void act()
    {
        time++;
        if(time == 270)
            setMenu();
        else if(time == 1)
        {
            OverlayFightText overlayfighttext = getObjects(OverlayFightText.class).get(0);
            overlayfighttext.appeartime = 269;
        }
    }
    public void prepareScene()
    {
        addObject(new OverlayFight(), 300, 450);
        addObject(new OverlayFightText(), 300, 450);
        addObject(new BasePlayer(), 159, 410);
        addObject(new BaseEnemy(), 490, 89);
        addObject(new PokemonEnemy(), 479, 50);
        addObject(new BattlePlayer(), 330, 250);
        addObject(new BallLaunch(), 0, 180);
        addObject(new CursorFight(), 100, 400);
        addObject(new TransitionOut(),300,200);
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
    public void ballExplosion()
    {
        addObject(new BallExplosion(), 205, 380);
    }
    public void prepareHP()
    {
        addObject(new HPPlayer(), 535, 300);
        addObject(new HPEnemy(), 65, 100);
        if(HPPlayerBar.hpPercentage > 0)
            addObject(new HPPlayerBar(), 591 + ((HPPlayerBar.hpPercentage - 101) / 2), 301);
        else if(HPPlayerBar.hpPercentage <= 0)
            addObject(new HPPlayerBar(), 591 + ((-1) / 2), 301);
        addObject(new HPEnemyBar(), 103, 113);
    }
    public void removeMenu()
    {
        removeObject(buttonfight);
        removeObject(buttonpoke);
        removeObject(buttonbag);
        removeObject(buttonrun);
    }
    public void setMenu()
    {
        removeObject(buttonblank0);
        removeObject(buttonblank1);
        removeObject(buttonblank2);
        removeObject(buttonblank3);
        removeObject(buttonlowsweep);
        removeObject(buttonflamethrower);
        removeObject(buttonpotion);
        removeObject(buttonsuperpotion);
        addObject(buttonfight, 115, 430);
        addObject(buttonpoke, 115, 473);
        addObject(buttonbag, 337, 430);
        addObject(buttonrun, 337, 474);
    }
    public void setFightMenu()
    {
        removeObject(buttonfight);
        removeObject(buttonpoke);
        removeObject(buttonbag);
        removeObject(buttonrun);
        addObject(buttonflamethrower, 115, 430);
        addObject(buttonblank0, 115, 473);
        addObject(buttonlowsweep, 337, 430);
        addObject(buttonblank2, 337, 474);
    }
    public void setBagMenu()
    {
        removeObject(buttonfight);
        removeObject(buttonpoke);
        removeObject(buttonbag);
        removeObject(buttonrun);
        if(potionnumber > 0)
        {
            addObject(buttonpotion, 115, 430);
            buttonpotion.setUseTime();
        }
        else
            addObject(buttonblank3, 115, 430);
        addObject(buttonblank0, 115, 473);
        if(superpotionnumber > 0)
        {
            addObject(buttonsuperpotion, 337, 430);
            buttonsuperpotion.setUseTime();
        }
        else
            addObject(buttonblank1, 337, 430);
        addObject(buttonblank2, 337, 474);
    }
    public void overlayFightText()
    {
        addObject(overlayfighttext, 300, 450);
    }
    public void removeOverlayFightText()
    {
        removeObject(overlayfighttext);
    }
    public void playerPokemon()
    {
        addObject(new PokemonPlayer(), 180, 245);
    }
    public void transitionFade()
    {
        addObject(new TransitionFade(), 300, 200);
    }
}