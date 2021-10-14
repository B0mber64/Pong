import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int score1=0;
    private int score2=0;
    private GreenfootImage win1 = new GreenfootImage("Win2.png");
    private GreenfootImage win2 = new GreenfootImage("Win1.png");
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Table myTable=(Table) getWorld();
        if(score1==8){
            getWorld().getBackground().drawImage(win1, getWorld().getWidth()/4, getWorld().getHeight()/4);
            myTable.killBall();
        }
        if(score2==8){
            getWorld().getBackground().drawImage(win2, (getWorld().getWidth()/4), getWorld().getHeight()/4);
            myTable.killBall();
        }
    }
    /**
     * Add's score to Player 1 and updates Image.
     */
    public void addPoint1(){
        score1++;
        setImage(score1+".png");
    }
    /**
     * Adds point to Player 2 and updates Image.
     */
    public void addPoint2(){
        score2++;
        setImage(score2+".png");
    }
}
