/*
 * SalariedEmployeeManager.java
 */

import java.util.*;
import worker.*;
import javax.swing.*;
import java.io.*;

/**
 * This class implements a program that manages a set of workers.
 *
 * @author  J. Miller, J. A. Whitford Holey, Will Haanen, and Jamie Vega
 * @version TODAY'S DATE
 */
public class SalariedEmployeeManager {
  
  private SalariedEmployee employee;
  
  /**
   * Creates a new SalariedEmployeeManager.
   */
  public SalariedEmployeeManager(SalariedEmployee newEmployee) 
  {
    System.out.println("Welcome to the Salaried Employee Manager");
    employee = newEmployee;
  }
  
  /**
   * Processes commands to the SalariedEmployeeManager.
   */
  public void runManager() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
  private void menu() {
    System.out.println();
    System.out.println("\tC Changa a Salaried Employee's Salary");
    System.out.println("\tQ Quit the program");
    System.out.println();
  }
  
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");
    cmd = s.charAt(0);
    return cmd;
  }
  
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 'c': case 'C':
        change();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  /**
   * Change the salary for the given employee
   */
  private void change()
  {
    System.out.print("Enter the new Salary: ");
    Scanner in = new Scanner(System.in);
    employee.setMonthlyPay(in.nextDouble());
  }
  /**
   * 
   */
  private void quit() {        
    System.out.println("Now exiting the Worker Manager\n");
  }
} 
