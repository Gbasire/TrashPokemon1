import greenfoot.*;
public class Boy extends Actor
{
    public static int originalX = 300;
    public static int originalY = 300;
    public static int originalX1 = 300;
    public static int originalY1 = 300;
    public static int originalX2 = 250;
    public static int originalY2 = 270;
    public static int originalX3 = 221;
    public static int originalY3 = 270;
    public static int originalX9 = 300;
    public static int originalY9 = 200;
    public static String previousworld;
    public static boolean isGirl = true;
    public static boolean canInteract = true;
    public int interactTime;
    static GreenfootImage down;
    static GreenfootImage downrun;
    static GreenfootImage up;
    static GreenfootImage uprun;
    static GreenfootImage left;
    static GreenfootImage leftrun;
    static GreenfootImage right;
    static GreenfootImage rightrun;
    public static GreenfootImage lastimage;
    public int launchBattle;
    public int speed = 2;
    private int time = 4;
    private int startTime = 1;
    public Boy()
    {
        if(lastimage == null && isGirl == true)
            lastimage = new GreenfootImage("girlDown.png");
        if(lastimage == null && isGirl == false)
            lastimage = new GreenfootImage("boyDown.png");
        setImage(lastimage);
    }
    public void act() 
    {
        setVariables();
        canInteract();
        checkMove();
        checkImage();
        checkImageType();
        setBoyLocation();
        checkBorder();
    }
    public void checkMove()
    {
        if(speed > 0)
        {
            if(Greenfoot.isKeyDown("left"))
            {
                time--;
                move(-speed);
                if(getImage() == left && time == 0)
                {
                    time = 5;
                    setImage(leftrun);
                }
                else if(time == 0)
                {
                    time = 5;
                    setImage(left);
                }
                checkGrass();
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                time--;
                move(speed);
                if(getImage() == right && time == 0)
                {
                    time = 5;
                    setImage(rightrun);
                }
                else if(time == 0)
                {
                    time = 5;
                    setImage(right);
                }
                checkGrass();
            }
            else if(Greenfoot.isKeyDown("up"))
            {
                time--;
                setLocation(getX(), getY()-speed);
                if(getImage() == up && time == 0)
                {
                    time = 5;
                    setImage(uprun);
                }
                else if(time == 0)
                {
                    time = 5;
                    setImage(up);
                }
                checkGrass();
            }
            else if(Greenfoot.isKeyDown("down"))
            {
                time--;
                setLocation(getX(), getY()+speed);
                if(getImage() == down && time == 0)
                {
                    time = 5;
                    setImage(downrun);
                }
                else if(time == 0)
                {
                    time = 5;
                    setImage(down);
                }
                checkGrass();
            }
        }
    }
    public void checkGrass()
    {
        if(isTouching(TallGrass.class))
        {
            launchBattle = Greenfoot.getRandomNumber(200);
            if(launchBattle < 1)
                startBattle();
            //if(Greenfoot.getRandomNumber(5) < 1)
                //getWorld().addObject(new Dust(),getX(),getY());
        }
    }
    public void startBattle()
    {
        getWorld().addObject(new TransitionIn(), 300, 200);
        previousworld = "ROUTE";
        speed = 0;
    }
    public void canInteract()
    {
        interactTime--;
        if(interactTime == 1)
            canInteract = true;
    }
    public void checkImage()
    {
        if(getImage() == down || getImage() == downrun)
            lastimage = down;
        else if(getImage() == up || getImage() == uprun)
            lastimage = up;
        else if(getImage() == left || getImage() == leftrun)
            lastimage = left;
        else if(getImage() == rightrun || getImage() == right)
            lastimage = right;
    }
    public void checkImageType()
    {
        startTime--;
        if(startTime == 0)
        {
            if(isGirl == false)
            {
                down = new GreenfootImage("boyDown.png");
                downrun = new GreenfootImage("boyDownRun.png");
                up = new GreenfootImage("boyUp.png");
                uprun = new GreenfootImage("boyUpRun.png");
                left = new GreenfootImage("boyLeft.png");
                leftrun = new GreenfootImage("boyLeftRun.png");
                right = new GreenfootImage("boyRight.png");
                rightrun = new GreenfootImage("boyRightRun.png");
            }
            else
            {
                down = new GreenfootImage("girlDown.png");
                downrun = new GreenfootImage("girlDownRun.png");
                up = new GreenfootImage("girlUp.png");
                uprun = new GreenfootImage("girlUpRun.png");
                left = new GreenfootImage("girlLeft.png");
                leftrun = new GreenfootImage("girlLeftRun.png");
                right = new GreenfootImage("girlRight.png");
                rightrun = new GreenfootImage("girlRightRun.png");
            }
        }
    }
    public void setFixedImage()
    {
        if(lastimage == down)
            setImage(down);
        else if(lastimage == up)
            setImage(up);
        else if(lastimage == left)
            setImage(left);
        else if(lastimage == right)
            setImage(right);
    }
    public void setVariables()
    {
        if(this.getWorld().getClass() == WorldRoute.class)
        {
            originalX = getX();
            originalY = getY();
        }
        if(this.getWorld().getClass() == WorldTown.class)
        {
            originalX1 = getX();
            originalY1 = getY();
        }
        if(this.getWorld().getClass() == WorldCenter.class)
        {
            originalX2 = getX();
            originalY2 = getY();
        }
        if(this.getWorld().getClass() == WorldPlayerRoom.class)
        {
            originalX3 = getX();
            originalY3 = getY();
        }
        if(this.getWorld().getClass() == WorldTest.class)
        {
            originalX9 = getX();
            originalY9 = getY();
        }
    }
    public void checkBorder()
    {
        if(this.getWorld().getClass() == WorldRoute.class)
        {
            if(getY() > 390)
            {
                Greenfoot.setWorld(new WorldTown());
                previousworld = "ROUTE";
            }
        }
        if(this.getWorld().getClass() == WorldTown.class)
        {
            if(getY() < 10)
            {
                Greenfoot.setWorld(new WorldRoute());
                previousworld = "TOWN";
            }
        }
    }
    public void hitBox()
    {
        if(this.getWorld().getClass() == WorldRoute.class)
            setLocation(originalX, originalY);
        else if(this.getWorld().getClass() == WorldTown.class)
            setLocation(originalX1, originalY1);
        else if(this.getWorld().getClass() == WorldCenter.class)
            setLocation(originalX2, originalY2);
        else if(this.getWorld().getClass() == WorldPlayerRoom.class)
            setLocation(originalX3, originalY3);
        else if(this.getWorld().getClass() == WorldTest.class)
            setLocation(originalX9, originalY9);
    }
    public void setBoyLocation()
    {
        if(this.getWorld().getClass() == WorldRoute.class)
        {
            ((WorldRoute)getWorld()).originalXValue = originalX;
            ((WorldRoute)getWorld()).originalYValue = originalY;
        }
        if(this.getWorld().getClass() == WorldTown.class)
        {
            ((WorldTown)getWorld()).originalXValue = originalX1;
            ((WorldTown)getWorld()).originalYValue = originalY1;
        }
        if(this.getWorld().getClass() == WorldCenter.class)
        {
            ((WorldCenter)getWorld()).originalXValue = originalX2;
            ((WorldCenter)getWorld()).originalYValue = originalY2;
        }
        if(this.getWorld().getClass() == WorldPlayerRoom.class)
        {
            ((WorldPlayerRoom)getWorld()).originalXValue = originalX3;
            ((WorldPlayerRoom)getWorld()).originalYValue = originalY3;
        }
        if(this.getWorld().getClass() == WorldTest.class)
        {
            ((WorldTest)getWorld()).originalXValue = originalX9;
            ((WorldTest)getWorld()).originalYValue = originalY9;
        }
    }
}
