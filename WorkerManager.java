/*
 * WorkerManager.java
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
public class WorkerManager {
  
  private Set<Worker> workers;
  
  /**
   * Creates a new WorkerManager.
   */
  public WorkerManager() {
    System.out.println("Welcome to the Worker Manager");
    workers = new HashSet<Worker>();
  }
  
  /**
   * Processes commands to the WorkerManager.
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
   * Prints the menus for the WorkerManager.
   */
  private void menu() {
    System.out.println();
    System.out.println("\tA Add a new worker");
    System.out.println("\tR Remove a worker");
    System.out.println("\tM Manage an individual worker");
    System.out.println("\tP rePort on workers");
    System.out.println("\tS Save the current worker set");
    System.out.println("\tL Load a worker set");
    System.out.println("\tQ Quit the program");
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
        remove();
        break;
      case 'm': case 'M':
        manage();
        break;
      case 'p': case 'P':
        report();
        break;
      case 's': case 'S':
        save();
        break;
      case 'l': case 'L':
        load();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /**
   * Prompts the user for the type of worker to add,
   * creates the appropriate worker type,
   * and adds the worker to the set.
   *
   */
  private void add() {
    System.out.println();
    System.out.println("Which type of worker do you want to add?");
    System.out.println();
    System.out.println("\tV add a Volunteer");
    System.out.println("\tH add an Hourly Employee");
    System.out.println("\tS add a Salaried Employee");
    System.out.println("\tC Cancel add worker");
    System.out.println();
    
    String s = JOptionPane.showInputDialog("Enter worker type: ");;
    char cmd = s.charAt(0);
    
    Worker newWorker;
    switch (cmd)
    {
      case 'v': case 'V':
        newWorker = newVolunteer();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 'h': case 'H':
        newWorker = newHourlyEmployee();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 's': case 'S':
        newWorker = newSalariedEmployee();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 'c': case 'C':
        System.out.println("Add worker cancelled");
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /**
   * Gets data for and creates a new Volunteer
   */
  private Worker newVolunteer() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for a Volunteer (name and hours)
    System.out.print("Enter the name of the new Volunteer: ");
    Scanner in = new Scanner(System.in);
    String newVolunteerName = in.next();
    System.out.print("Enter the hours of the new Volunteer: ");
    Scanner inn = new Scanner(System.in);
    double newVolunteerHours = inn.nextDouble();
    return new Volunteer(newVolunteerName, newVolunteerHours);
  } 
  
  /**
   * Get data for and creates a new HourlyEmployee.
   */
  private Worker newHourlyEmployee() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for an HourlyEmployee (name,  hours and hourly pay rate)
    System.out.print("Enter the name of the new Employee: ");
    Scanner in = new Scanner(System.in);
    String newHourlyEmployeeName = in.next();
    System.out.print("Enter the hours of the new Employee: ");
    Scanner inn = new Scanner(System.in);
    double newHourlyEmployeeHours = inn.nextDouble();
    return new HourlyEmployee(newHourlyEmployeeName, newHourlyEmployeeHours);
  } 
  
  /**
   * Gets data for and creates a new SalariedEmployee.
   */
  private Worker newSalariedEmployee() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for a SalariedEmployee (name and salary)
    System.out.print("Enter the name of the new Salaried Employee: ");
    Scanner in = new Scanner(System.in);
    String newSalariedName = in.next();
    System.out.print("Enter the new Salary: ");
    Scanner inn = new Scanner(System.in);
    double newSalary = inn.nextDouble();
    return new SalariedEmployee(newSalariedName, newSalary);
  } 
  
  /**
   * Prompt the user for a worker name and remove that worker from the set;
   * report if the worker is not found.
   */
  private void remove() {
    // Fill in appropriate code
    System.out.print("Enter the name to be removed: ");
    Scanner in = new Scanner(System.in);
    boolean removed = workers.remove(in);
    if(removed)
    {
      System.out.print(in + " was removed from the list of workers");
    }
    else
    {
      System.out.print(in + " was not found in list, or has already been removed");
    }
    
  }
  
  /**
   * Prompt the user for a worker name and find the worker;
   * if the worker is found, create a VolunteerManager, HourlyEmployeeManager or
   * SalariedEmployeeManager on that worker and run it;
   * otherwise report that the worker is not found.
   */
  private void manage() {
    // Fill in appropriate code
    System.out.print("Enter the name to be found: ");
    Scanner in = new Scanner(System.in);
    if(workers.contains(in))
    {
      for(Worker w : workers) 
      {
        if(w.getName().equals(in))
        {
          if(w.toString().equals("Volunteer"))
          {
            VolunteerManager(w);
          }
          else if(w.toString().equals("HourlyEmployee"))
          {
            HourlyEmployeeManager(w);
          }
          else
          {SalariedEmployeeManager(w);}
        }
      } 
    }
    else
    {
      System.out.println("Worker does not exist in List");
    }
  }
  
  /**
   * Prompt the user for the type of report desired: all workers, hourly workers,
   * all employees, volunteers, hourly employees or salaried employees;
   * print a list of all the workers in the selected category.
   */
  private void report() {
    // Fill in appropriate code
    System.out.print("Enter the category of worker to be found: ");
    Scanner in = new Scanner(System.in);
    if(in.equals("volunteer"))
    {
      for(Worker w : workers)
      {
        if(w.toString().equals("Volunteer"))
        {
          System.out.println("Volunteer: " + w.getName() + ", Hours: " + ((Volunteer)w).getHours());
        }
      }
      
    }
    else if(in.equals("HourlyEmployee"))
    {
      if(in.equals("HourlyEmployee"))
      {
        for(Worker w : workers)
        {
          if(w.toString().equals("HourlyEmployee"))
          {
            System.out.println("Hourly Employee: " + w.getName() + ", Hours: " + ((HourlyEmployee)w).getHours());
          }
        }
      }
    }
    else if(in.equals("SalariedEmployee"))
    {
      if(in.equals("SalariedEmployee"))
      {
        for(Worker w : workers)
        {
          if(w.toString().equals("SalariedEmployee"))
          {
            System.out.println("Salaried Employee: " + w.getName() + ", Salary: " + ((SalariedEmployee)w).getMonthlyPay());
          }
        }
      }
    }
  }
  
  /**
   * Prompt the user for a file name and save the set to the 
   * specified file using an ObjectOutputStream;
   * report an error if an exception occured.
   */
  private void save(){
    // Fill in appropriate code
    try {
    System.out.println("Enter name for output file");
    Scanner in = new Scanner(System.in);
    FileOutputStream fos = new FileOutputStream(in.nextLine());
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(workers);}
    
    catch(FileNotFoundException fne) {
      System.err.println("FileNotFoundException");
      System.err.println(fne);
      return;
    }
    catch(IOException ioe) {
      System.err.println("IOException");
      System.err.println(ioe);
      return;
    }
    
    }
    
    /**
     * Prompt the user for a file name and load a new set from the specified
     * file using an ObjectInputStream;
     * report an error if an exception occured.
     */
    private void load() {
      // Fill in appropriate code
      try {
    System.out.println("Enter name for input file");
    Scanner in = new Scanner(System.in);
    FileInputStream fis = new FileInputStream(in.nextLine());
    ObjectInputStream ois = new ObjectInputStream(fis);
    workers = (HashSet<Worker>) ois.readObject();}
    
    catch(FileNotFoundException fne) {
      System.err.println("FileNotFoundException");
      System.err.println(fne);
      return;
    }
    catch(IOException ioe) {
      System.err.println("IOException");
      System.err.println(ioe);
      return;
    }
    catch(ClassNotFoundException cnfe) {
      System.err.println("ClassNotFoundException");
      System.err.println(cnfe);
      return;
    }
    }
    
    /**
     * Terminate the WorkerManager program.
     */
    private void quit() {        
      System.out.println("Now exiting the Worker Manager\n");
      System.exit(0);
    }
    
    /**
     * Creates and runs a WorkerManager.
     * 
     * @param args the command line arguments (not used)
     */
    public static void main (String args[]) {
      WorkerManager manager = new WorkerManager ();
      manager.runManager();
    }
  }
