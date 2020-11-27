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
public class Player extends Agent{
    
    
    public Player(Node view) {
        super(view);
    }

    public Player(Node view, double health) {
        super(view, health);
    }
    public Player(Node view, double health, double speed) {
        super(view, health, speed);
    }

    
    @Override
    public void start() {

    }

    @Override
    public void update() {
        deathListner();
        if(!this.isDead()){
            this.move();
        }
        
    }

    @Override
    public void testingGizmos() {
       
    }
   
    
    @Override
    protected void deathListner() {
        if(this.getHealth() <= 0){
            this.setDead(true);
        }
        
    }
    
}
