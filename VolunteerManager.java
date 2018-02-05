/*
 * VolunteerManager.java
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
public class VolunteerManager {
  
  private Set<Volunteer> workers;
  private Volunteer volunteer;
  /**
   * Creates a new VolunteerManager.
   */
  public VolunteerManager(Volunteer newVolunteer) {
    System.out.println("Welcome to the Volunteer Manager");
    volunteer = newVolunteer;
  }
  
  /**
   * Processes commands to the VolunteerManager.
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
   * Prints the menus for the VolunteerManager.
   */
  private void menu() {
    System.out.println();
    System.out.println("Volunteer hour manager");
    System.out.println();
    System.out.println("\tA add hours");
    System.out.println("\tR reset hours");
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
    volunteer.addHours(in.nextDouble());
  }
  
  private void reset()
  {
    volunteer.resetHours(); 
  }
  /**
   * Terminate the VolunteerManager program.
   */
  private void quit() {        
    System.out.println("Now exiting the Volunteer Manager\n");
    System.exit(0);
  }
  private void remove(){
    
  }
  /**
   * Creates and runs a VolunteerManager.
   * 
   * @param args the command line arguments (not used)
   */

}