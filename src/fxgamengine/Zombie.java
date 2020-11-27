/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 *
 * @author Leem
 */
public class Zombie extends Agent{
    private GameObject target;
    public Zombie(Node view,double health, double speed) {
        super(view, health, speed);
        this.target = null;
    }
    
    
    public Zombie(Node view,double health, double speed, GameObject target) {
        super(view, health, speed);
        this.target = target;
    }
    @Override
    public void start(){
    }
    
    @Override
    public void update(){
        //chase();
        this.move();
        //System.out.println(this.getVelX() + " " + this.getVelY());
    }
    
    
    
    public void chase(){
        if(target != null){
            this.setVel(GameObject.normalise(target.getX() - this.getX(), target.getY() - this.getY()));
            double x = this.angle(target.getX(), target.getY());
            //System.out.println("angle " + x);
            //System.out.println(this.getCenterX() + " " + this.getCenterY());
            this.view.setRotate(x);
            //System.out.println(this.view.getRotate());
        }else{
            this.setVel(0,0);
        }
    }

    public GameObject getTarget()               {return this.target;}
    public void setTarget(GameObject go)        {this.target = go;}
    
    
    @Override
    protected void deathListner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
