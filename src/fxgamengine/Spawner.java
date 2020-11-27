/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Leem
 */
public class Spawner extends GameObject{
    int mod;
    long maxTime;
    
    
    public Spawner(Rectangle view, int miliSeconds) {
        super(view);
        this.mod = miliSeconds;
        
    }

    
    @Override
    public void start() {
        this.maxTime = System.currentTimeMillis() + this.mod;
    }
    
    @Override
    public void update() {
        
        this.setX(this.getX() + this.getVelX());
        this.setY(this.getY() + this.getVelY());
        
        if(System.currentTimeMillis() >= this.maxTime ){
            this.spawn();
            this.maxTime = System.currentTimeMillis() + this.mod;
            System.out.println("Spawn");
        }
        
    }
    
    private void spawn(){
        Rectangle rec = new Rectangle(50,50);
        rec.setLayoutX(this.getX());
        rec.setLayoutY(this.getY());
        rec.setFill(Color.GREEN);
        Zombie z = new Zombie(rec,10,1);
        GameManager.addToPane(z);
    }

    @Override
    public void testingGizmos() {
      
    }


    
    
    
    
    
}
