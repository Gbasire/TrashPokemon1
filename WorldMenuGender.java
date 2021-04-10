import greenfoot.*;
public class WorldMenuGender extends World
{
    TransitionFade tf = new TransitionFade();
    public WorldMenuGender()
    {    
        super(755, 570, 1);
        prepare();
    }
    public void prepare()
    {
        addObject(new MenuCursorGender(), 200, 250);
        addObject(new MenuGenderText(), 378, 500);
        addObject(new MenuBoy(), 200, 250);
        addObject(new MenuGirl(), 555, 250);
        addObject(new DataSound(), 0, 0);
    }
    public void transition()
    {
        addObject(tf, 377, 280);
    }
}
