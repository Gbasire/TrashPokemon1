import greenfoot.*;
public class DataSound extends Data
{
    public static final GreenfootSound musicCenter = new GreenfootSound("Center.mp3");
    public static final GreenfootSound musicRoute = new GreenfootSound("Route.mp3");
    public static final GreenfootSound musicTown = new GreenfootSound("Town.mp3");
    public static final GreenfootSound musicWildBattle = new GreenfootSound("WildBattle.mp3");
    public static final GreenfootSound musicTitleScreen = new GreenfootSound("TitleScreen.mp3");
    public static final GreenfootSound effectAttackFlameThrower = new GreenfootSound("Attacks/FlameThrower.mp3");
    public static final GreenfootSound effectAttackLowSweep = new GreenfootSound("Attacks/LowSweep.mp3");
    public static final GreenfootSound effectAttackRockTomb = new GreenfootSound("Attacks/RockTomb.mp3");
    public static final GreenfootSound effectAttackTackle = new GreenfootSound("Attacks/Tackle.mp3");
    public static final GreenfootSound effectDamageNormal = new GreenfootSound("Hits/Normal.mp3");
    public static final GreenfootSound effectDamageWeak = new GreenfootSound("Hits/Weak.mp3");
    public static final GreenfootSound effectDamageSuper = new GreenfootSound("Hits/Super.mp3");
    public static final GreenfootSound effectBattleRun = new GreenfootSound("BattleRun.mp3");
    public static final GreenfootSound effectCursorMove = new GreenfootSound("CursorMove.mp3");
    public static final GreenfootSound effectCursorMove1 = new GreenfootSound("CursorMove.mp3");
    public static final GreenfootSound effectCursorMove2 = new GreenfootSound("CursorMove.mp3");
    public static final GreenfootSound effectMenuChoose = new GreenfootSound("MenuChoose.mp3");
    public static final GreenfootSound effectLaunchBall = new GreenfootSound("PokeballLaunch.mp3");
    public static boolean battlelaunched = false;
    public void act()
    {
        checkWorld();
    }
    public void checkWorld()
    {
        if(getWorld().getClass() == WorldCenter.class)
        {
            if(musicCenter.isPlaying() == false) 
            {
                musicCenter.play();
                musicRoute.stop();
                musicTown.stop();
                musicTitleScreen.stop();
                musicWildBattle.stop();
            }
        }
        if(getWorld().getClass() == WorldRoute.class)
        {
            if(musicRoute.isPlaying() == false && battlelaunched == false) 
            {
                musicRoute.play();
                musicCenter.stop();
                musicTown.stop();
                musicTitleScreen.stop();
                musicWildBattle.stop();
            }
        }
        if(getWorld().getClass() == WorldTown.class)
        {
            if(musicTown.isPlaying() == false) 
            {
                musicTown.play();
                musicCenter.stop();
                musicRoute.stop();
                musicTitleScreen.stop();
                musicWildBattle.stop();
            }
        }
        if(getWorld().getClass() == WorldMenuGame.class)
        {
            if(musicTitleScreen.isPlaying() == false) 
            {
                musicTitleScreen.play();
                musicCenter.stop();
                musicRoute.stop();
                musicTown.stop();
                musicWildBattle.stop();
            }
        }
        if(getWorld().getClass() == WorldMenuMain.class)
            musicTitleScreen.stop();
        if(getWorld().getClass() == WorldWildBattle.class)
        {
            battlelaunched = false;
            wildBattle();
        }
    }
    public void wildBattle()
    {
        if(musicWildBattle.isPlaying() == false)
        {
            musicWildBattle.play();
            musicCenter.stop();
            musicRoute.stop();
            musicTown.stop();
            musicTitleScreen.stop();
        }
    }
    public static void setMusicVolume(int volume)
    {
        musicWildBattle.setVolume(volume);
        musicCenter.setVolume(volume);
        musicRoute.setVolume(volume);
        musicTown.setVolume(volume);
        musicTitleScreen.setVolume(volume);
        musicWildBattle.setVolume(volume);
    }
    public static void setSoundEffectsVolume(int volume)
    {
        effectAttackFlameThrower.setVolume(volume);
        effectAttackLowSweep.setVolume(volume);
        effectAttackRockTomb.setVolume(volume);
        effectAttackTackle.setVolume(volume);
        effectDamageNormal.setVolume(volume);
        effectDamageWeak.setVolume(volume);
        effectDamageSuper.setVolume(volume);
        effectBattleRun.setVolume(volume);
        effectCursorMove.setVolume(volume);
        effectCursorMove1.setVolume(volume);
        effectCursorMove2.setVolume(volume);
        effectMenuChoose.setVolume(volume);
        effectLaunchBall.setVolume(volume);
    }
}
