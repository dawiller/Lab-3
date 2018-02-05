/*
 * HourlyEmployeeManager.java
 */

import java.util.*;
import worker.*;
import javax.swing.*;
import java.io.*;

/**
 * This class implements a program that manages a set of workers.
 *
 * @author  J. Miller, J. A. Whitford Holey, and YOUR NAME
 * @version TODAY'S DATE
 */
public class HourlyEmployeeManager {
  
  private Set<HourlyEmployee> workers;
  private HourlyEmployee hourlyEmployee;
  /**
   * Creates a new HourlyEmployeeManager.
   */
  public HourlyEmployeeManager(HourlyEmployee bill) {
    System.out.println("Welcome to the HourlyEmployee Manager");
    workers = new HashSet<HourlyEmployee>();
    hourlyEmployee = bill;
  }
  
  /**
   * Processes commands to the HourlyEmployeeManager.
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
  
  /**
   * Prints the menus for the HourlyEmployeeManager.
   */
  private void menu() {
    System.out.println();
    System.out.println("HourlyEmployee hour manager");
    System.out.println();
    System.out.println("\tA add hours");
    System.out.println("\tR reset hours");
    System.out.println("\tS set hours");
    System.out.println("\tQ quit program");
    System.out.println();
  }
  
  /**
   * Gets a one character command from the user.
   */
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");
    cmd = s.charAt(0);
    return cmd;
  }
  
  /**
   * Determines the current command and calls the corresponding
   * command method.
   */
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 'a': case 'A':
        add();
        break;
      case 'r': case 'R':
        reset();
        break;
      case 's': case 'S':
        quit ();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  private void add(){
    System.out.print("Enter the amount of hours to be added: ");
    Scanner in = new Scanner(System.in);
    hourlyEmployee.addHours(in.nextDouble());
  }
  /**
   * Terminate the HourlyEmployeeManager program.
   */
  private void quit() {        
    System.out.println("Now exiting the HourlyEmployee Manager\n");
    System.exit(0);
  }
  private void reset(){
    hourlyEmployee.setHourlyPay(15);
  }
  private void setHourlyPay(){
    System.out.print("Set Hourly Pay Amount: ");
    Scanner in = new Scanner(System.in);
    hourlyEmployee.setHourlyPay(in.nextDouble());
  }
}
