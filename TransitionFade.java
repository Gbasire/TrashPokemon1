import greenfoot.*;
public class TransitionFade extends Transitions
{
    private int time;
    public TransitionFade()
    {
        getImage().setTransparency(0);
    }
    public void act()
    {
        if(this.getWorld().getClass() == WorldWildBattle.class)
        {
            GreenfootImage image = getImage();
            image.scale(600, 600);
            setImage(image);
        }
        if(this.getWorld().getClass() == WorldMenuGame.class 
        || this.getWorld().getClass() == WorldMenuMain.class
        || this.getWorld().getClass() == WorldMenuGender.class)
        {
            GreenfootImage image = getImage();
            image.scale(755, 575);
            setImage(image);
        }
        time += 3;
        getWorld().showText("", 523, 440);
        getWorld().showText("", 524, 460);
        getWorld().showText("", 160, 92);
        getWorld().showText("", 520, 280);
        getWorld().showText("", 300, 450);
        getImage().setTransparency(time);
        changeWorld();
    }
    public void changeWorld()
    {
        if(time == 3)
        {
            if(this.getWorld().getClass() == WorldWildBattle.class
            && DataPokemon.hp > 0 
            && Boy.previousworld == "ROUTE")
                DataSound.effectBattleRun.play();
            else if(this.getWorld().getClass() == WorldWildBattle.class
            && DataPokemon.hp < 1)
                DataSound.effectBattleRun.play();
        }
        else if(time == 252)
        {
            if(this.getWorld().getClass() == WorldWildBattle.class
            && DataPokemon.hp > 0 
            && Boy.previousworld == "ROUTE")
            {
                Boy.previousworld = "WILDBATTLE";
                Greenfoot.setWorld(new WorldRoute());
            }
            else if(this.getWorld().getClass() == WorldWildBattle.class
            && DataPokemon.hp < 1)
                Greenfoot.setWorld(new WorldCenter());
            else if(this.getWorld().getClass() == WorldMenuGame.class)
                Greenfoot.setWorld(new WorldMenuMain());
            else if(this.getWorld().getClass() == WorldMenuMain.class)
                Greenfoot.setWorld(new WorldMenuGender());
            else if(this.getWorld().getClass() == WorldMenuGender.class)
                Greenfoot.setWorld(new WorldTown());
        }
    }
}

