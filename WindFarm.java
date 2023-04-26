
/**
 * Write a description of class WindFarm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WindFarm 

{
    // instance variables - replace the example below with your own
    private String name;
    private double capacity;
    private String country;
    private int numberTurbines;
    private int year;
    
    public WindFarm()
    {
        name = "Triton Knoll";
        capacity = 857;
        country = "United Kingdom";
        numberTurbines = 90;
        year = 2021;

    }

    /**
     * Constructor for objects of class WindFarm
     */
    public WindFarm(String name, String country, double capacity, int numberTurbines, int year)
    {
        // initialise instance variables
        this.name = name;
        this.country = country;
        this.capacity = capacity;
        this.numberTurbines = numberTurbines;
        this.year = year;

    }
    public void print(){
        System.out.printf("--------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-12s | %-17s | %-15s | %15s |%n", "Wind farm","Capacity", "Country","Turbine&Model","Commissioned");
        System.out.printf("---------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-12f | %-17s | %-15d | %15d |%n", name, capacity,country,numberTurbines, year);
        



    }
   
    public void printValue(){
      System.out.printf("| %-15s | %-12f | %-17s | %-15d | %15d |%n", name, capacity,country,numberTurbines,year);  
    }
    
    public double getCapacity(){
        return capacity;
    }
    public  String getCountry()
    {
        return country;
    }
} 
    


