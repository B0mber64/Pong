import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private int directionX=4;
    private int directionY=4;
//  Sets directionX and directionY through an array.
    private int direction=10;
    private int score1=0;
    private int score2=0;
    private int timer=50;
    public Ball(){
        
    }
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timer++;
//  line 13
        int array[]=directionArray(directionX, directionY, direction);
        directionX=array[0];
        directionY=array[1];
        move();
// detect wall hit and reset the ball to the middle.
        direction=loss(direction);
        direction=ballHit(direction);
//  get scores
        int scoreArray[]=score(score1, score2);
        score1=scoreArray[0];
        score2=scoreArray[1];
        scoreDisplay(score1,score2);
    }
//  moves set X and Y
    public void move(){
        if(timer>=40){
        setLocation(getX()+(directionX),getY()+(directionY));
    }
    }
//  bounces the ball in the direction for the case. case = int direction
    public int ballHit(int direction){
//  Ball hit world top.
        if(getY()<=20){
           switch (direction){
                case 0: direction=6; break;
                case 1: direction=5; break;
                case 2: direction=4; break;
                
                case 11: direction=9; break;
                case 12: direction=8; break;
                case 13: direction=7; break;
           }
        }
        
//  Ball hit world bottom.
        if(getY()>=getWorld().getHeight()-21){
            switch (direction){
                case 4: direction=2; break;
                case 5: direction=1; break;
                case 6: direction=0; break;
                
                case 7: direction=13; break;
                case 8: direction=12; break;
                case 9: direction=11; break;
           }
        }
//  Ball hit world right.
        if(getX()>=getWorld().getWidth()-20){
            switch (direction){
                case 0: direction=13; break;
                case 1: direction=12; break;
                case 2: direction=11; break;
                case 3: direction=10; break;
                case 4: direction=9; break;
                case 5: direction=8; break;
                case 6: direction=7; break;
           }    
        }
//  Ball hit world left.   
        if(getX()<=20){
            switch (direction){
                case 13: direction=0; break;
                case 12: direction=1; break;
                case 11: direction=2; break;
                case 10: direction=3; break;
                case 9: direction=4; break;
                case 8: direction=5; break;
                case 7: direction=6; break;
           }   
        }
        Table myTable = (Table) getWorld();
        direction=myTable.bounce(direction);
        return direction;
    }
//  display scores
    public void scoreDisplay(int score1, int score2){
        
    }
//  The int for the direction variable will always 
//  corrolate with it's case, sending back the x and y for that case.
    public static int[] directionArray(int x, int y, int direction){
        switch(direction) {
            case 0: x=4; y=-6; break;
            case 1: x=5; y=-5; break;
            case 2: x=6; y=-4; break;
            case 3: x=8; y=0; break;
            case 4: x=6; y=4; break;
            case 5: x=5; y=5; break;
            case 6: x=4; y=6; break;
            
            case 7: x=-4; y=6; break;
            case 8: x=-5; y=5; break;
            case 9: x=-6; y=3; break;
            case 10: x=-8; y=0; break;
            case 11: x=-6; y=-4; break;
            case 12: x=-5; y=-5; break;
            case 13: x=-4; y=-6; break;
        }
        int array[]={x, y};
            return array;
   }
   //  check for loss if ball is at either edge
    public int loss(int direction){
//      ball at left or right edge
        if(getX()>=580 || getX()<=20){
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
            direction=(int)(Math.random()*2);
            if(direction==1){
                direction=10;
            }
            else{
                direction=3;
            }
            timer=0;
        }
        return direction;
    }
    //  when ball hits left add a point to player 1, hit right add a point to player 2
    public int[] score(int score1, int score2){
        if(getX()<=20){
            score1++;
        }
        if(getX()>=580){
            score2++;
        }
        int score[]={score1,score2};
        return score;
    }

    }
