import greenfoot.*;
public class ButtonPoke extends ButtonsMenu
{
    GreenfootImage image1 = new GreenfootImage("Buttons/BattleButtons/ButtonPokemon.png"); 
    GreenfootImage image2 = new GreenfootImage("Buttons/BattleButtons/ButtonPokemon1.png");
    public ButtonPoke()
    {
        setImage(image1);
    }
    public void act()
    {
        checkCursor();
    }
    public void checkCursor()
    {
        if(isTouching(CursorFight.class))
            setImage(image2);
        else
            setImage(image1);
    }
}
