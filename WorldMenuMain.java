import greenfoot.*;
public class WorldMenuMain extends World
{
    TransitionFade tf = new TransitionFade();
    public WorldMenuMain()
    {    
        super(755, 570, 1);
        prepare();
    }
    public void prepare()
    {
        addObject(new MenuNewGame(), 378, 240);
        addObject(new MenuGameOptions(), 378, 325);
        addObject(new MenuCursor(), 378, 240);
        addObject(new MenuControls(), 640, 525);
        addObject(new DataSound(), 0, 0);
    }
    public void transition()
    {
        addObject(tf, 377, 280);
    }
}
