import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Write a description of class WindFarmTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WindFarmTable //implements IWindFarm
{
    //instance variables - replace the example below with your own
    private String name;
    private ArrayList<WindFarm> windFarms;
    private HashSet<WindFarm> windFarmSet;
    private HashMap<String, Double> countryCapacities;
    private HashMap<String, HashSet<WindFarm>> countryMap;
    private HashSet<WindFarm> newSet;
    boolean empty = true;

    /**
     * Constructor for objects of class WindFarmTable
     */
    public WindFarmTable(String name)
    {
        // initialise instance variables
        name = name;
        windFarms = new ArrayList<WindFarm>();
        windFarmSet = new HashSet<WindFarm>();

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addPowerStation(WindFarm powerStation)
    {
        // put your code here
        windFarms.add(powerStation);
    }

    public double getTotalPower()
    {
        double sum = 0;
        for (WindFarm i: windFarms){
            sum += i.getCapacity();

        }

        return sum;
    }

    public void printTable()
    {
        System.out.printf("--------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-12s | %-17s | %-15s | %15s |%n", "Wind farm","Capacity", "Country","Turbine&Model","Commissioned");
        System.out.printf("---------------------------------------------------------------------------------------%n");
        for(WindFarm i: windFarms){
            i.printValue();
        }
    }

    public void initList()
    {
        if (empty)
        {
            WindFarm windFarm1 = new WindFarm("Hornsea","United Kingdom",1218,174, 2019);
            this.addPowerStation(windFarm1);
            WindFarm windFarm2 = new WindFarm("Walney","United Kingdom",1026,102, 2018);
            this.addPowerStation(windFarm2);
            WindFarm windFarm3 = new WindFarm("Jiangsu Qidong","China",802,134, 2021);
            this.addPowerStation(windFarm3);
            WindFarm windFarm4 = new WindFarm("Borsela 1&2","Netherlands",752,94, 2020);
            this.addPowerStation(windFarm4);
            WindFarm windFarm5 = new WindFarm("Borsela 3&4","Netherlands",731.5,77, 2021);
            this.addPowerStation(windFarm5);
        }

        empty = false;
    }

    /**
     * Gets country of wind farm instances.
     * checks if it is the same with string inputed by the user.
     * prints the instance if it is the same.
     * Searches for wind farm by countries.
     */
    public void listWindFarms(String country)
    {
        System.out.printf("--------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-12s | %-17s | %-15s | %15s |%n", "Wind farm","Capacity", "Country","Turbine&Model","Commissioned");
        System.out.printf("---------------------------------------------------------------------------------------%n");
        for(WindFarm i : windFarms)
        {
            if (i.getCountry().contains(country)){
                i.printValue();
            }
        }
    }

    /**
     * Searches for wind farms by their countries.
     * Adds the found wind farms to a HashSet
     * windFarmSet is a HashSet created to store the wind farms
     * found by their country.
     */
    public HashSet<WindFarm>findWindFarms(String country)
    {
        for (WindFarm i : windFarms)
        {
            if(i.getCountry().contains(country))
            {
                // Add the instance to a set.    
                windFarmSet.add(i);
            }
        }
        // Returns the set.
        return windFarmSet;
    }

    public void listByCountry()
    {

        for (WindFarm i : windFarms)
        {
            System.out.println(i.getCountry());
            i.printValue();
        }
    } 

    public HashMap<String, Double>powerByCountry() 
    {
        countryCapacities = new HashMap<String, Double>();

        for (WindFarm i : windFarms)
        {
            if (countryCapacities.get(i.getCountry())== null) 
            {
                countryCapacities.put(i.getCountry(), i.getCapacity());
            }
            else{
                countryCapacities.put(i.getCountry(), countryCapacities.get(i.getCountry())+ i.getCapacity()); 
            }
        }

        return countryCapacities;
    }

    public void printCapacity(HashMap<String,Double> printCountryCapacity)
    {
        printCountryCapacity = new HashMap<String, Double>();
        System.out.printf("---------------------------------------------%n");
        System.out.printf("| %-15s | %-15s |%n", "Country","Total Capacity");
        System.out.printf("---------------------------------------------%n");

        for (String key: countryCapacities.keySet())
        {
            String country= key;
            Double totalPower = countryCapacities.get(key);
            System.out.printf("| %-15s | %-15f |%n", country,totalPower);

        }

    }

    public HashMap<String, HashSet<WindFarm>>mapByCountry()
    {
        HashMap<String, HashSet<WindFarm>>countryMap = new HashMap<String, HashSet<WindFarm>>();

        for (WindFarm i : windFarms) 
        {
            HashSet<WindFarm> countrySet = 
                countryMap.getOrDefault(i.getCountry(), new HashSet<WindFarm>());
            countrySet.add(i);
            countryMap.put(i.getCountry(), countrySet);
        }
        return countryMap;
    }

    public void printMap(HashMap<String, HashSet<WindFarm>> searchMap)
    {
        for (String key : searchMap.keySet())
        {
            System.out.println("Country:" + key);
            for (WindFarm i :searchMap.get(key) )
            {
                i.printValue();
            }

        }
    }
}
