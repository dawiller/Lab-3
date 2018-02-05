/*
 * File: Worker.java
 */


package worker;

import java.io.*;
/** 
 * Worker is an interface for workers who have work hours .
 * 
 * @author Jaime Vega and Will Haanen
 * @version January 29, 2018
 */
public interface Worker extends Serializable

{
  /**
   * Get the name of the worker
   *  
   * @return The name of the worker
   */
  public String getName();
  
  /**
   * Checks if the object is equal to the other provided object
   * 
   * 
   * @param otherObject the object that the original object is compared to
   * @return true if the objects are equal and false if they are not
   */
  public boolean equals(Object otherObject);
  /**
   * Convert the given object to a String
   * 
   * @return The string value of the given object
   */
  public String toString();
}