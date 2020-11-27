/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxgamengine;

import javafx.scene.input.KeyEvent;

/**
 *
 * @author Leem
 */
public interface ControllerInterface {
    public int heldDown[]  = {0,0,0,0};
    public void controllerConfig(KeyEvent event, GameObject go);
}
