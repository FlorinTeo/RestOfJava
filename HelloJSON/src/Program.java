import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cosmos.Galaxy;
import cosmos.Planet;
import cosmos.Star;

/**
 * This program demonstrates the usage of Gson for serializing
 * and deserializing objects on the disk, in JSON format.
 * It starts by loading MilkyWay.json, which contains a representation
 * of the Milky Way galaxy, with only two stars: the "Sun" and "Proxima Centauri".
 * The "Proxima Centauri" includes its "Proxima Centaury b" planet,
 * the "Sun" includes only "Mars", "Neptune" and "Pluto".
 * 
 * The program deserializes the file in memory, adds to the solar system
 * the rest of the planets and serializes back the resulting object in the same file.
 */
public class Program {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello to JSON World!");
        
        // Read the entire content of the file MilkyWay.json
        // in the String variable jsonMilkyWay.
        Scanner input = new Scanner(new File("MilkyWay.json"));
        input.useDelimiter("\\A");
        String jsonMilkyWay = input.next();
        System.out.printf("---- JSON string loaded:\n%s\n",jsonMilkyWay);
        
        // Deserialize the JSON string into the Java object milkyWay
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Galaxy milkyWay = gson.fromJson(jsonMilkyWay, Galaxy.class);
        System.out.printf("---- MilkyWay deserialized:\n%s\n", milkyWay);
        
        // Add "Earth" as a planet orbiting the "Sun"
        Star sun = milkyWay.getStar("Sun");
        if (sun != null) {
            sun.addPlanets(
                new Planet("Mercury", 4.5, Planet.Composition.Terrestrial),
                new Planet("Venus", 4.5, Planet.Composition.Terrestrial),
                new Planet("Earth", 4.54, Planet.Composition.Terrestrial),
                new Planet("Jupiter", 4.5, Planet.Composition.GasGiant),
                new Planet("Saturn", 4.6, Planet.Composition.GasGiant),
                new Planet("Uranus", 4.6, Planet.Composition.IceGiant)
            );
        }
        System.out.printf("---- Solar system is now complete:\n%s\n", milkyWay);

        // Serialize back the milkyWay object into the JSON file
        jsonMilkyWay = gson.toJson(milkyWay);
        PrintStream output = new PrintStream(new File("MilkyWay.json"));
        output.print(jsonMilkyWay);
        System.out.printf("---- JSON string saved:\n%s\n", jsonMilkyWay);
    }
}
