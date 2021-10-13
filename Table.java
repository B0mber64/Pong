import greenfoot.*;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Table extends World
{
    private Player player1;
    private Player player2;
    private Ball ball;
    /**
     * Constructor for objects of class Table.
     * s
     */
    public Table()
    {    
// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        ball=new Ball();
        player1=new Player("w", "s");
        player2=new Player("up", "down");
        addObject(ball, getWidth()/2, getHeight()/2);
        addObject(player1, getWidth()-560, getHeight()/2);
        addObject(player2, getWidth()-40, getHeight()/2);
               
        getBackground().drawLine(getWidth()/2,0,getWidth()/2,getHeight());
    }

    
//  ball bounce when hit players
    public int bounce(int direction){
//  player1 bounce:
//      top:
        if(ball.getX()<=player1.getX()+35 && ball.getX()>=player1.getX()+25 && ball.getY()>=player1.getY()-66 && ball.getY()<=player1.getY()-21){
           switch(direction){
                case 13: direction=0; break;
                case 12: direction=0; break;
                case 11: direction=1; break;
                case 10: direction=2; break;
                case 9: direction=3; break;
                case 8: direction=4; break;
                case 7: direction=5; break;
           }
        }
//      middle:
        if(ball.getX()<=player1.getX()+35 && ball.getX()>=player1.getX()+25 && ball.getY()>=player1.getY()-20 && ball.getY()<=player1.getY()+20){
           switch(direction){
                case 13: direction=0; break;
                case 12: direction=1; break;
                case 11: direction=2; break;
                case 10: direction=3; break;
                case 9: direction=4; break;
                case 8: direction=5; break;
                case 7: direction=6; break;
           }
        }
//      bottom:        
        if(ball.getX()<=player1.getX()+35 && ball.getX()>=player1.getX()+25 && ball.getY()>=player1.getY()+21 && ball.getY()<=player1.getY()+66){
           switch(direction){
                case 13: direction=1; break;
                case 12: direction=2; break;
                case 11: direction=3; break;
                case 10: direction=4; break;
                case 9: direction=5; break;
                case 8: direction=6; break;
                case 7: direction=6; break;
           }
        }
//  player2 bounce:
//      top:        
        if(ball.getX()>=player2.getX()-35 && ball.getX()<=player2.getX()-25 && ball.getY()>=player2.getY()-66 && ball.getY()<=player2.getY()-21){
           switch(direction){
                case 0: direction=13; break;
                case 1: direction=13; break;
                case 2: direction=12; break;
                case 3: direction=11; break;
                case 4: direction=10; break;
                case 5: direction=9; break;
                case 6: direction=8; break;
           }
        }
//      middle:
        if(ball.getX()>=player2.getX()-35 && ball.getX()<=player2.getX()-25 && ball.getY()>=player2.getY()-20 && ball.getY()<=player2.getY()+20){
           switch(direction){
                case 0: direction=13; break;
                case 1: direction=12; break;
                case 2: direction=11; break;
                case 3: direction=10; break;
                case 4: direction=9; break;
                case 5: direction=8; break;
                case 6: direction=7; break;
           }
        }
//      bottom:        
        if(ball.getX()>=player2.getX()-35 && ball.getX()<=player2.getX()-25 && ball.getY()>=player2.getY()+21 && ball.getY()<=player2.getY()+66){
           switch(direction){
                case 0: direction=12; break;
                case 1: direction=11; break;
                case 2: direction=10; break;
                case 3: direction=9; break;
                case 4: direction=8; break;
                case 5: direction=7; break;
                case 6: direction=7; break;
           }
        }
        
        
        return direction;
    }
}
