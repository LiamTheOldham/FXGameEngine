/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Leem
 */
public class FXMLDocumentController implements Initializable {
    
  
    @FXML
    private AnchorPane mainPane;
    
    
    private ArrayList<GameObject> objects;
    
    private AnimationTimer updater;
    
    long time;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        init();
        test();
        start();
        time = System.nanoTime();
        updater.start();
    }   
    
    private void init(){
        mainPane.setPrefSize(500,500);
        GameManager.panePointer = mainPane;
        updater = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        
    }
    
    private void test(){
        Rectangle rec = new Rectangle(50,50);
        Rectangle rec1 = new Rectangle(50,50, Color.RED);
        Rectangle rec2 = new Rectangle(50,50, Color.GREEN);
        rec1.setLayoutX(50);rec1.setLayoutY(50);
        rec2.setLayoutX(50);rec2.setLayoutY(50);
        rec.setOnMouseEntered(value -> {System.out.println("hello");});
        Spawner go = new Spawner(rec,5000);
        Player p = new Player(rec1,10,10);
        Zombie z = new Zombie(rec2,10,1);
        z.setTarget(p);
        GameManager.setControllerTarget(p);
        GameManager.addToPane(go,p,z);
    }
    
    
    private void start(){
        GameManager.objects.forEach(x -> x.start());
    }
    
    int frameCounter = 0;
    private void update(){
        if(System.nanoTime() >= time){
            GameManager.objects.forEach(x -> {
                x.finalUpdate();
                if(x.isDead()){objects.remove(x);}
            });
            
            //System.out.println(frameCounter + " fps");
            frameCounter++;
            time = System.nanoTime() + 16666666;
        }
        
    }
    
    
    
    
    private void add(Node ... n){mainPane.getChildren().addAll(n);}
    private void addGO(GameObject ... go){
        int i;
        for(i=0;i<go.length;i++){objects.add(go[i]);}
    }
    
}
