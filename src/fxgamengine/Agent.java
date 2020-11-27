/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import javafx.scene.Node;

/**
 *
 * @author Leem
 */
public abstract class Agent  extends GameObject{
    private double health;
    
    
    
    public Agent(Node view) {
        super(view);
        this.health = 1;
    }
    
    public Agent(Node view, double health){
        super(view);
        this.health = health;
    }
    
    public Agent(Node view, double health, double speed){
        super(view,speed);
        this.health = health;
    }
    
    

    @Override
    public void testingGizmos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected abstract void deathListner();
    
    
    
    public double getHealth(){return this.health;}
    
    
    public void setHealth(double health){this.health = health;}
    
    
    public void effectHealth(double health){this.health += health;}
    
}
