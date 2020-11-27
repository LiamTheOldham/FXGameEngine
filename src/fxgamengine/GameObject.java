/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 *
 * @author Leem
 */
abstract class GameObject {
    public Node view;
    private double[] vel;
    private double speed;
    private boolean isDead, testing;
    private ArrayList<GameObject> addList;
    public GameObject(Node view){
        this.view = view;
        this.vel = new double[2];
        this.isDead = false;
        this.testing = false;
        this.speed = 1;
        this.addList = new ArrayList();
    }
    
    public GameObject(Node view, double speed){
        this.view = view;
        this.vel = new double[2];
        this.isDead = false;
        this.testing = false;
        this.speed = speed;
        this.addList = new ArrayList();
    }
    
    public GameObject(Node view, double[] vel){
        this.view = view;
        if(vel.length > 1){this.vel = new double [] {vel[0],vel[1]};}
        else{this.vel = new double [2];}
        this.isDead = false;
        this.testing = false;
        this.speed = 1;
        this.addList = new ArrayList();
    }
    
    public GameObject(Node view, double[] vel, double speed){
        this.view = view;
        if(vel.length > 1){this.vel = new double [] {vel[0],vel[1]};}
        else{this.vel = new double [2];}
        this.isDead = false;
        this.testing = false;
        this.speed = speed;
        this.addList = new ArrayList();
    }
    
    public abstract void testingGizmos();
    
    public abstract void start();
    
    public abstract void update();
    
    public final void finalUpdate(){
        if(this.testing){this.testingGizmos();}
        this.update();
    }
    
    protected void move(){
        this.setX(this.getX() + this.getVelX());
        this.setY(this.getY() + this.getVelY());
    }
    
    
    
    
    public double getSpeed()                          {return this.speed;}
    public double getX()                              {return this.view.getLayoutX();}
    public double getY()                              {return this.view.getLayoutY();}
    public double getCenterX()                        {return this.view.getLayoutX() + (this.view.getBoundsInLocal().getWidth()/2);}
    public double getCenterY()                        {return this.view.getLayoutY() + (this.view.getBoundsInLocal().getHeight()/2);}
    public double getVelX()                           {return this.vel[0];}
    public double getVelY()                           {return this.vel[1];}
    public double[] getVel()                          {return this.vel;}
    public boolean isDead()                           {return this.isDead;}
    public ArrayList<GameObject> getAddList()         {return this.addList;}
    public int getAddListSize()                       {return this.addList.size();}
    
    public void setSpeed(double d)                    {this.speed = d;}
    public void setDead(boolean b)                    {this.isDead = b;}
    public void setTesting(boolean b)                 {this.testing = b;}
    public void setX(double x)                        {this.view.setLayoutX(x);}
    public void setY(double y)                        {this.view.setLayoutY(y);}
    public void setVel(double x, double y)            {this.vel = new double [] {x*this.speed,y*this.speed};}
    public void setVel(double[] d)                    {this.vel = d;}
    public void setVelX(double x)                     {this.vel[0] = x*this.speed;}
    public void setVelY(double y)                     {this.vel[1] = y*this.speed;}
    public void setVelScaler(double x)                {this.setVel(this.getVelX() * x, this.getVelY() * x );}
    public void setVelScaler(double x, double y)      {this.setVel(this.getVelX() * x, this.getVelY() * y );}
    
    public void clearAddList()                        {this.addList.clear();}
    
    public void addGameObject(GameObject go){this.addList.add(go);} 
    
    public double angle(double x, double y) {
        final double ax = this.getCenterX();
        final double ay = this.getCenterY();
        System.out.println(ax + " " + ay + " : " + x + " " + y);
        final double delta = (ax * x + ay * y) / Math.sqrt(
                (ax * ax + ay * ay) * (x * x + y * y));

        if (delta > 1.0) {
            return 0.0;
        }
        if (delta < -1.0) {
            return 180.0;
        }

        return Math.toDegrees(Math.acos(delta));
    }

    
    
    public void moveFixedPosition(double x, double y){this.setX(x); this.setY(y);}
    public void moveVel(Point2D p){this.setX(p.getX() + this.getX());this.setY(p.getY() + this.getY());}
    
    
    public static double[] normalise(double x, double y){ 
        
        final double mag = magnitude(x,y);

        if (mag == 0.0) {
            return new double[] {0.0,0.0};
        }
        x = x / mag; y = y/mag;
        return new double[] {x,y};
    }
    

    public static double invSqrt(double x) {
        double number = x;
        double xhalf = 0.5d*x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i>>1);
        x = Double.longBitsToDouble(i);
        for(int it = 0; it < 4; it++){
            x = x*(1.5d - xhalf*x*x);
        }
        x *= number;
        return x;
        }
    
    public static double magnitude(double x, double y){
        return Math.sqrt(x * x + y * y);
    }
    
}
