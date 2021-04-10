import greenfoot.*;
public class WorldMenuOptions extends World
{
    TransitionFade tf = new TransitionFade();
    public WorldMenuOptions()
    {    
        super(755, 570, 1);
        prepare();
    }
    public void prepare()
    {
        addObject(new MenuMusic(), 305, 240);
        addObject(new MenuSoundEffects(), 305, 325);
        addObject(new MenuMusicIcon(), 600, 240);
        addObject(new MenuSoundIcon(), 600, 325);
        addObject(new MenuCursor(), 305, 240);
        addObject(new DataSound(), 0, 0);
    }
}
