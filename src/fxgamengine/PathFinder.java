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
public class PathFinder {
   
   private double mapWidth,mapHeight;
   
   private GameObject current, target;
   
   public PathFinder(double mapWidth, double mapHeight, GameObject current, GameObject target){
       this.mapWidth = mapWidth; this.mapHeight = mapHeight;
       this.current = current;   this.target = target;
   }
   
   
   public PathNode[][] generatePathMap(){
       PathNode[][] pathMap = new PathNode[10][10];
       
       
       
       return pathMap;
   }
   
   
    
}
