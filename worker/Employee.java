/*
 * File: Employee.java
 */


package worker;

import java.io.*;
/**
 * An interface that defines methods for employees
 * 
 * @ author Jaime Vega, Will Haanen
 * @version January 29, 2018
 */
public interface Employee extends Worker

{
  /**
   * Get the monthly pay for the worker
   *  
   * @return The  monthly pay for the employee
   */
  public double getMonthlyPay();
 
}