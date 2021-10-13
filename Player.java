import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed=6;
    private String playerUp;
    private String playerDown;
    public Player(String playerUp, String playerDown){
//  For creating the Player objects and assigning different keys 
//      to differentiate them.
        this.playerUp=playerUp;
        this.playerDown=playerDown;
    }
    public void act()
    {
        move();
        hitEdge();
    }
    public void move(){
//  Key pressed for the right Player will move it up or down the amount
//      specified in the speed variable.    
        if(Greenfoot.isKeyDown(playerUp)){
            setLocation(getX(),(getY()-speed));
        }
        if(Greenfoot.isKeyDown(playerDown)){
            setLocation(getX(),(getY()+speed));
        }
    }
//  Keeps Players at the edge when going up or down.
//      puts them back to wear they were before they moved out of the edge.
    public void hitEdge(){
        if(Greenfoot.isKeyDown(playerUp)){
            if(getY()<=56){
                setLocation(getX(),getY()+speed);
            }
        }
        if(Greenfoot.isKeyDown(playerDown)){
            if(getY()>=340){
                setLocation(getX(),getY()-speed);
            }
        }
    }
}
