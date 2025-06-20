package cosmos;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic star. Stars are a specific kind of astral corpus.
 * In addition to all attributes of an astral corpus, a star has a specific spectral type.
 * @see <a href=https://www.astronomytrek.com/list-of-different-star-types/>astronomytrek</a> 
 */
public class Star extends Corpus {

    /**
     * Spectral types of stars.
     * @see <a href=https://www.star-facts.com/types-of-stars/>star-facts</a>
     */
    public enum SpectralType {
        O,
        B,
        A,
        F,
        G,
        K,
        M,
    };
    
    // Spectral type of this star
    private SpectralType spectralType;
    // List of planets orbiting this star
    private List<Planet> planets;

    /**
     * Constructs a new Star of a given name, age and spectralType.
     * @param name - name of this star.
     * @param age - age of this star in billions of years.
     * @param spectralType - spectralType of this planet.
     */
    public Star(String name, double age, SpectralType spectralType) {
        super(name, age);
        this.spectralType = spectralType;
        this.planets = new ArrayList<Planet>();
    }
    
    /**
     * Add zero or more planets to this star if not already in the star system. 
     * @param planets - array of planets to be added. 
     */
    public void addPlanets(Planet... planets) {
        for (Planet planet : planets) {
            if (!this.planets.contains(planet)) {
                this.planets.add(planet);
            }
        }
    }
    
    /**
     * Returns a representation of this star as a string,
     * prefixed by a given number of spaces.
     * @param indent - number of spaces to use as an indent.
     */
    @Override
    public String toString(int indent) {
        String value = String.format("%s, spectral type %s, with planets:\n",
                super.toString(indent),
                spectralType);
        for(Planet planet: planets) {
            value += String.format("%s", planet.toString(indent + 4));
        }
        return value;
    }
}
