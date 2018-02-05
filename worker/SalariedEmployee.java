

package worker;
/**
 * An class the implements the Employee interface and supplies information
 * for only salaried employes
 * 
 * @ author Jaime Vega, Will Haanen
 * @version January 29, 2018
 */
public class SalariedEmployee implements Employee
{
  public String name;
  public double monthlySalary;
  /**
   * Creates Salaried employee 
   */
  public SalariedEmployee(String newName, double newSalary)
  {
   name = newName; 
   monthlySalary = newSalary;
  }
  
   /**
   * Return the monthly pay for the employee 
   * 
   * @return amount of the monthly pay
   */
  public double getMonthlyPay()
  {
    return monthlySalary;
  }
  
 /**
   * Set the monthly pay for the Salaried Employee 
   * 
   * pre: newPay cannot be negative
   * 
   * @param newPay change in current amount of pay
   * @throws illegalArgumentException if newPay is negative
   */
  public void setMonthlyPay(double newPay)
  {
    if(newPay < 0)
    {
      throw new IllegalArgumentException("Cannot add negative Hours");
    }
    else
    {
      monthlySalary = newPay;
    }
  }
   /**
   * Return the name of the Salaried Employee 
   */
  public String getName()
  {
    return name;
  }
  
  public String toString()
  {
    return "SalariedEmployee"; 
  }
  public boolean equals(Object otherObject)
  {
    
    if( this.getName() == ((Worker)otherObject).getName())
    {
      return true;
    }
    else{
      return false;
    }
  }
  
}