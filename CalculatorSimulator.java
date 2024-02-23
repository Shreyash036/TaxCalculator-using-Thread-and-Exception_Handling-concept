import java.util.*;

class CountryNotValidException extends Exception 
{
	String message;
	public CountryNotValidException(String message) 
	{
       		this.message = message;
		System.out.println(this.message);
    	}	
}

class EmployeeNameInvalidException extends Exception 
{
	String message;
	public EmployeeNameInvalidException(String message) 
	{
       		this.message = message;
		System.out.println(this.message);
	}
}

class TaxNotEligibleException extends Exception 
{
	String message;
    	public TaxNotEligibleException(String message) 
	{
        	this.message = message;
		System.out.println(this.message);
    	}
}
class TaxCalculator
{
	public double calculateTax(String empName,boolean isIndian,double empSalary) throws CountryNotValidException,EmployeeNameInvalidException,TaxNotEligibleException
	{
		if(!isIndian)
		{
			throw new CountryNotValidException("For Calculating tax Employee Should be Indian");
		}
		if(empName == null || empName.isEmpty())
		{
			throw new EmployeeNameInvalidException("Please fill the employee name properly .It cannot be empty ");
		}
	
		double taxAmount = 0.0;
		if(empSalary > 100000)
		{
			taxAmount = empSalary * 8/100;
		}
		else if(empSalary >=50000 && empSalary <= 100000)
		{
			taxAmount = empSalary * 6/100 ;
		}
		else if(empSalary >= 30000 && empSalary <50000)
		{
			taxAmount = empSalary * 5/100;
		}
		else if(empSalary >= 10000 && empSalary < 30000 )
		{
			taxAmount = empSalary * 4/100;
		}
		else
		{
			throw new TaxNotEligibleException("This employee does not need to pay tax");
		}
		return taxAmount;
		
		
	} 
}
public class CalculatorSimulator
{
	public static void main(String[] arg)
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			System.out.println("Enter employee name :");
			String empName = scanner.nextLine() ;
			
			System.out.println("Is the employee Indian ? (true/false): ");
			boolean isIndian = scanner.nextBoolean();

			System.out.println("Enter employee salary ");
			double empSalary = scanner.nextDouble();

			TaxCalculator c= new TaxCalculator();
			double taxAmount = c.calculateTax(empName,isIndian,empSalary);
			System.out.println("Tax amount is :" + taxAmount);
		}
		catch(CountryNotValidException ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
		catch (EmployeeNameInvalidException ex) 
		{
            		System.out.println(ex);
			ex.printStackTrace();
        	}
		catch (TaxNotEligibleException ex) 
		{
        		System.out.println(ex);
			ex.printStackTrace();
        	}
		catch (InputMismatchException ex) 
		{
           		System.out.println(ex);			
			ex.printStackTrace();
        	} 

	
	}
}