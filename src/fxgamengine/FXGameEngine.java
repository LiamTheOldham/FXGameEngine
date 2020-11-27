/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import java.util.Collections;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Leem
 */
public class FXGameEngine extends Application {
    
    static GameManager gm;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        gm = new GameManager(root,stage);
        /*Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.W){
                System.out.println("event: " + e.getCode());
            }
        
        });
        stage.setScene(scene);
        stage.show();*/
        setupController();
        gm.finalConfigure();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public static void setupController(){
        
        ControllerInterface ci_keyPressed = (event, go) -> {
            
            if(event.getCode().equals(KeyCode.UP)){
                //System.out.println("w");
                ControllerInterface.heldDown[0] = 1;
                go.setVelY(-1);
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                //System.out.println("s");
                ControllerInterface.heldDown[1] = 1;
                go.setVelY(1);
            }
            if(event.getCode().equals(KeyCode.LEFT)){
                //System.out.println("a");
                ControllerInterface.heldDown[2] = 1;
                go.setVelX(-1);
            }
            if(event.getCode().equals(KeyCode.RIGHT)){
                //System.out.println("d");
                ControllerInterface.heldDown[3] = 1;
                go.setVelX(1);
            }
        };
        
        ControllerInterface ci_keyReleased = (event,go) ->{
            if(event.getCode().equals(KeyCode.UP)){
                ControllerInterface.heldDown[0] = 0;
                if(ControllerInterface.heldDown[0] == 0 && ControllerInterface.heldDown[1] == 0){
                    go.setVelY(0);
                }
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                ControllerInterface.heldDown[1] = 0;
                if(ControllerInterface.heldDown[0] == 0 && ControllerInterface.heldDown[1] == 0){
                    go.setVelY(0);
                }
            }
            
            if(event.getCode().equals(KeyCode.LEFT)){
                ControllerInterface.heldDown[2] = 0;
                if(ControllerInterface.heldDown[2] == 0 && ControllerInterface.heldDown[3] == 0){
                    go.setVelX(0);
                }
            }
            if(event.getCode().equals(KeyCode.RIGHT)){
                ControllerInterface.heldDown[3] = 0;
                if(ControllerInterface.heldDown[2] == 0 && ControllerInterface.heldDown[3] == 0){
                    go.setVelX(0);
                }
            }
        };
        
        gm.setControllerOnKeyPressed(ci_keyPressed);
        gm.setControllerOnKeyReleased(ci_keyReleased);
    }
    
}
