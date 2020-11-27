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
public interface Collidable {
    public enum CollideBoxType{
        BOX,
        CIRCLE,
        RIGID
    }
    
    public CollideBoxType cbt = CollideBoxType.BOX; 
    
    
    
}
