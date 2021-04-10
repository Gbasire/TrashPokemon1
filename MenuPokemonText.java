import greenfoot.*;
public class MenuPokemonText extends MenuGame
{
    MenuPoweredText menupoweredtext = new MenuPoweredText();
    public void act()
    {
        if(getX()<710)
        {
            move(5);
        }
        else
        {
            getWorld().addObject(menupoweredtext, 377, 350);
        }
    }    
}
