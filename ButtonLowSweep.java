import greenfoot.*;
public class ButtonLowSweep extends ButtonsFight
{
    public static final GreenfootImage image1 = new GreenfootImage("Buttons/AttackButtons/LowSweep.png");
    public static final GreenfootImage image2 = new GreenfootImage("Buttons/AttackButtons/LowSweep1.png");

    public ButtonLowSweep()
    {
        // We basically pass a method as argument. This is called a "Lamda" (λ) statement.
        // This is the short form of what's written in "ButtonFlameThrower".
        //                                      > ↓------------------------↓ <
        super(image1, image2, "FIGHTING", 65, 20, () -> new AttackLowSweep());
    }
}
