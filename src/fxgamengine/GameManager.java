/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Leem
 */
public class GameManager {
    
    private static GameObject controllerTarget;
    private final Stage stage;
    private Scene scene;
    private ArrayList<Parent> sceneList;
    private ControllerInterface ci_keyPressed,ci_keyReleased;
    public static AnchorPane panePointer = null;
    public static ArrayList<GameObject> objects= new ArrayList();
    public GameManager(Stage s){
        this.scene = new Scene(new Parent() {});
        this.sceneList = new ArrayList();
        this.stage = s;
        this.stage.setScene(this.scene);
        this.ci_keyPressed = null;
        this.ci_keyReleased = null;
   
    }
    
    public GameManager(Parent p, Stage s){
        this.scene = new Scene(p);   
        this.sceneList = new ArrayList();
        this.sceneList.add(p);
        this.stage = s;
        this.stage.setScene(this.scene);
        this.ci_keyPressed = null;
        this.ci_keyReleased = null;
    }
    
    
    public void finalConfigure(){
        if(controllerTarget != null){
           if(this.ci_keyPressed != null){
             this.scene.setOnKeyPressed(event -> { this.ci_keyPressed.controllerConfig(event,controllerTarget);});
           }
           if(this.ci_keyReleased != null){
             this.scene.setOnKeyReleased(event -> { this.ci_keyReleased.controllerConfig(event,controllerTarget);});
           }
        }else{
        }
        
        this.stageShow();
    }
    
    public static void addToPane(GameObject ob){
        if(panePointer != null){
            objects.add(ob);
            panePointer.getChildren().add(ob.view);
        }
    }
    
    
    public static void addToPane(GameObject ... ob){
        if(panePointer != null){
            
            int i;
            for(i = 0; i < ob.length; i++){
                objects.add(ob[i]);
                panePointer.getChildren().add((ob[i]).view);
            }
        }
    }
    
    public static void setPanePointer(AnchorPane ap){panePointer = ap;}
    public static void setControllerTarget(GameObject go){ controllerTarget = go;}
    public void setControllerOnKeyPressed(ControllerInterface ci){this.ci_keyPressed = ci;}
    public void setControllerOnKeyReleased(ControllerInterface ci){this.ci_keyReleased = ci;}
    
    public static void releasePanePointer(){panePointer = null;}
    public static void clearObjectList(){objects.clear();}
    
    public void setScene(){
        
    }
    
    public void stageShow(){this.stage.show();}
    
   
}
