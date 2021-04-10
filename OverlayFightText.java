import greenfoot.*;
public class OverlayFightText extends Overlay
{
    public int appeartime;
    public int playerattacktime;
    public int enemyattacktime;
    public int healingtime;
    public int launchsurprisetime;
    public int surprisetime;
    public int runtime;
    public int playerdeadtime;
    public int enemydeadtime;
    public String healingobject;
    public int healingamount;
    public double playereffective = 1;
    public double enemyeffective = 2;
    public String playerpokemon = "Emboar";
    public String playerpokemontype;
    public String playerattack;
    public String playerattacktype;
    public String enemypokemon = "Geodude";
    public String enemypokemontype;
    public String enemyattack;
    public String enemyattacktype;
    public String appearText = "";
    public String playerAttackText = "";
    public String enemyAttackText = "";
    public String playerHealingText = "";
    public String writing = "";
    public int texti = 0;
    public void act()
    {
        getWorld().showText("", 523, 440);
        getWorld().showText("", 524, 460);
        checkButtons();
        checkTimes();
    }
    public void appear()
    {
        appeartime--;
        if(appeartime > 134 && appeartime < 268)
        {
            appearText = "A " + enemypokemon + " appeared";
            animateText(appearText);
        }
        if(appeartime == 134)
            resetAnimation();
        if(appeartime > 10 && appeartime < 134)
        {
            appearText = playerpokemon + ", go !";
            animateText(appearText);
        }
        else if(appeartime == 10)
        {
            resetAnimation();
            getWorld().showText("", getX(), getY());
            ((WorldWildBattle)getWorld()).setMenu();
        }
    }
    public void playerAttack()
    {
        playerattacktime--;
        if(playerattacktime == 149)
            CursorFight.isFighting = true;
        if(playerattacktime > 50 && playerattacktime < 149)
        {
            playerAttackText = playerpokemon + " uses " + playerattack;
            animateText(playerAttackText);
        }
        if(playerattacktime == 50)
        {
            DataPokemon dp = getWorld().getObjects(DataPokemon.class).get(0);
            dp.attack();
            resetAnimation();
            if(playereffective == 2)
                DataSound.effectDamageSuper.play();
            else if(playereffective == 0.5)
                DataSound.effectDamageWeak.play();
            else if(playereffective == 1)
                DataSound.effectDamageNormal.play();
        }
        if(playerattacktime > 0 && playerattacktime < 50)
        {
            if(playereffective == 2)
                animateText("it's super effective !");
            else if(playereffective == 0.5)
                animateText("it's not very effective...");
        }
        else if(playerattacktime == 0 && DataWildPokemon.hp > 0)
        {
            DataPokemon dp = getWorld().getObjects(DataPokemon.class).get(0);
            dp.endTurn();
            resetAnimation();
            getWorld().showText("", 300, 450);
            CursorFight.isFighting = false;
        }
        else if(playerattacktime == 0)
            resetAnimation();
    }
    public void enemyAttack()
    {
        enemyattacktime--;
        if(enemyattacktime == 149)
            CursorFight.isFighting = true;
        if(enemyattacktime > 50 && enemyattacktime < 149)
        {
            enemyAttackText = "the foe" + enemypokemon + " uses " + enemyattack;
            animateText(enemyAttackText);
        }
        if(enemyattacktime == 50)
        {
            DataWildPokemon dwp = getWorld().getObjects(DataWildPokemon.class).get(0);
            dwp.attack();
            resetAnimation();
            if(enemyeffective == 2)
                DataSound.effectDamageSuper.play();
            else if(enemyeffective == 0.5)
                DataSound.effectDamageWeak.play();
            else if(enemyeffective == 1)
                DataSound.effectDamageNormal.play();
        }
        if(enemyattacktime > 0 && enemyattacktime < 50)
        {
            if(enemyeffective == 2)
                animateText("it's super effective !");
            else if(enemyeffective == 0.5)
                animateText("it's not very effective...");
        }
        else if(enemyattacktime == 0 && DataPokemon.hp > 0)
        {
            DataWildPokemon dwp = getWorld().getObjects(DataWildPokemon.class).get(0);
            dwp.endTurn();
            resetAnimation();
            getWorld().showText("", 300, 450);
            CursorFight.isFighting = false;
            ((WorldWildBattle)getWorld()).setMenu();
        }
        else if(enemyattacktime == 0)
            resetAnimation();
    }
    public void enemySurpriseAttack()
    {
        surprisetime--;
        String surpriseText = "You didn't manage to escape !";
        if(surprisetime > 0 && surprisetime < 99)
        {
            animateText(surpriseText);
            getWorld().showText("", 523, 440);
            getWorld().showText("", 524, 460);
        }
        else if(surprisetime == 0)
        {
            resetAnimation();
            DataWildPokemon dwp = getWorld().getObjects(DataWildPokemon.class).get(0);
            dwp.chooseSurpriseAttack();
        }
    }
    public void run()
    {
        runtime--;
        String runText = "You managed to escape";
        if(runtime > 0 && runtime < 50)
            animateText(runText);
        else if(runtime == 0)
        {
            resetAnimation();
            getWorld().showText("", 300, 450);
            ((WorldWildBattle)getWorld()).transitionFade();
            CursorFight.isFighting = false;
            CursorFight.isSurprise = false;
            getWorld().removeObject(this);
        }
    }
    public void playerHealing()
    {
        healingtime--;
        if(healingtime == 149)
        {
            playerHealingText = "You use a " + healingobject;
            CursorFight.isFighting = true;
        }
        if(healingtime > 50 && healingtime < 149)
            animateText(playerHealingText);
        if(healingtime == 50)
        {
            DataPokemon dp = getWorld().getObjects(DataPokemon.class).get(0);
            DataPokemon.objecthealing = healingamount;
            dp.useHealing();
            resetAnimation();
            playerHealingText = playerpokemon + " gains " + healingamount + " hp !";
        }
        if(healingtime > 0 && healingtime < 50)
            animateText(playerHealingText);
        else if(healingtime == 0)
        {
            CursorFight.isFighting = false;
            playerHealingText = "";
            resetAnimation();
            DataPokemon dp = getWorld().getObjects(DataPokemon.class).get(0);
            dp.endTurn();
        }
    }
    public void playerDead()
    {
        playerdeadtime--;
        String playerDeadText = playerpokemon + " is KO !";
        if(playerdeadtime > 0 && playerdeadtime < 75)
            animateText(playerDeadText);
        else if(playerdeadtime == 0)
        {
            resetAnimation();
            ((WorldWildBattle)getWorld()).transitionFade();
        }
    }
    public void enemyDead()
    {
        enemydeadtime--;
        String enemyDeadTime = "the foe " + enemypokemon + " is KO !";
        if(enemydeadtime > 0 && enemydeadtime < 75)
            animateText(enemyDeadTime);
        else if(enemydeadtime == 0)
        {
            resetAnimation();
            ((WorldWildBattle)getWorld()).transitionFade();
        }
    }
    public void animateText(String animation)
    {
        char[] letters = animation.toCharArray();
        int length = animation.length();
        if(texti < length)
        {
            writing += letters[texti];
            texti++;
        }
        getWorld().showText(writing, getX(), getY());
    }
    public void resetAnimation()
    {
        writing = "";
        texti = 0;
    }
    public void checkButtons()
    {
        if(isTouching(ButtonFight.class))
            getWorld().removeObject(this);
    }
    public void checkTimes()
    {
        if(appeartime > 0)
            appear();
        if(playerattacktime > 0)
            playerAttack();
        if(enemyattacktime > 0)
            enemyAttack();
        if(runtime > 0)
            run();
        if(surprisetime > 0)
            enemySurpriseAttack();
        if(healingtime > 0)
            playerHealing();
        if(playerdeadtime > 0)
            playerDead();
        if(enemydeadtime > 0)
            enemyDead();
    }
}
