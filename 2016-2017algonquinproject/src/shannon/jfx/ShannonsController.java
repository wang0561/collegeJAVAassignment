/*
 * Lab3
 * network package
 * ShannonsController.java
 * 
 */
package shannons.jfx_version;

import java.util.Observer;
/**
 * Interface of the controller for shannons model .
 * Shannons Theorem must implement the methods of this interface
 * 
 * 
 * @author Wang,Tao
 * @version 1.0
 */
public interface ShannonsController {
/**
 *Method for add the observers of model
 *
 */
public void addObserver(Observer o);
/**
 * Abstract Method for set the value of band width
 * */
public void setBandWidth(double bandWidth);
/**
 * Abstract Method for set the value of snr
 * */
public void setSignalToNoise(double signalToNoiseRatio );
}
