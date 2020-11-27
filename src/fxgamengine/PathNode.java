/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

/**
 *
 * @author Leem
 */
public class PathNode {
    
    private boolean blocked, target;
    
    public PathNode(){
        this.blocked = false;
        this.target = false;
    }
    public PathNode(boolean blocked){
        this.blocked = blocked;
        this.target = false;
    }
    public PathNode(boolean blocked, boolean target){
        this.blocked = blocked;
        this.target = target;
    }
    
    
    public void setBlocked(boolean b)           {this.blocked = b;}
    public boolean isBlocked()                  {return this.blocked;}
    public void flipBlocked(boolean b)          {this.blocked = !this.blocked;}
    
    public void setTarget(boolean b)            {this.target = b;}
    public boolean isTarget()                   {return this.target;}
    public void flipTarget(boolean b)           {this.target = !this.target;}
    
    
}
