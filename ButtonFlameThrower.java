import java.util.function.Supplier;

import greenfoot.*;
public class ButtonFlameThrower extends ButtonsFight
{
    public static final GreenfootImage image1 = new GreenfootImage("Buttons/AttackButtons/FlameThrower.png");
    public static final GreenfootImage image2 = new GreenfootImage("Buttons/AttackButtons/FlameThrower1.png");

    public ButtonFlameThrower()
    {
        // This is the long version of "passing a method as argument". As you can see we
        // actually pass an object, a "Supplier". Supplier is an interface that has just
        // a single method, "get()". (Hold CTRL and click onto Supplier to see the source)
        //
        // When we create a new Supplier we have to specify an implementation for that
        // method because it is abstract, so that's what is inside the curly brackets.
        //
        // This is obviously a lot harder to read and also simply a lot longer than a lamda
        // statement.
        super(image1, image2, "FIRE", 95, 15, new Supplier<>()
        {
            public Attacks get() {
                return new AttackFlameThrower();
            };
        });
    }
}
