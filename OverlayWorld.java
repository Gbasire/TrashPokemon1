import greenfoot.World;

public abstract class OverlayWorld extends World {

    public static final int WIDTH = 755;
    public static final int HEIGHT = 570;

    OverlayText overlaytext = new OverlayText();

    public OverlayWorld() {
        this(WIDTH, HEIGHT);
    }

    public OverlayWorld(int width, int height) {
        super(width, height, 1);
    }

    public abstract void overlayText();

    public void removeOverlayText() {
        removeObject(overlaytext);
    }
}
