import greenfoot.*;
public class NPCCenterNurse extends ObjectNPCSpecial
{
    static GreenfootImage down = new GreenfootImage("Objects/NPC/CenterNurse/DownNurse.png");
    static GreenfootImage left = new GreenfootImage("Objects/NPC/CenterNurse/LeftNurse.png");
    public int nursetime;
    public NPCCenterNurse()
    {
        setImage(down);
    }
    public void act()
    {
        interact();
        animate();
    }
    public void interact()
    {
        if(isTouching(Boy.class) && Boy.canInteract == true && Greenfoot.isKeyDown("enter"))
        {
            overlayText();
            OverlayText overlaytext = (OverlayText)getWorld().getObjects(OverlayText.class).get(0);
            overlaytext.nursetime = 150;
        }
    }
    public void animate()
    {
        if(nursetime > 0)
        {
            nursetime--;
            if(nursetime == 149)
                setImage(left);
            else if(nursetime == 1)
                setImage(down);
        }
    }
}
