package cosmos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A generic Galaxy as one of the multiple kinds of corpuses in the universe.
 */
public class Galaxy extends Corpus {
    // List of stars in this galaxy
    private List<Star> stars;

    /**
     * Constructs a new Galaxy of a given name and age.
     * @param name - name of this galaxy.
     * @param age - age of this galaxy in billions of years.
     */
    public Galaxy(String name, double age) {
        super(name, age);
        stars = new ArrayList<Star>();
    }
    
    /**
     * Adds zero or more stars to this galaxy.
     * @param stars - array of stars to be added.
     */
    public void addStars(Star... stars) {
        this.stars.addAll(Arrays.asList(stars));
    }
    
    /**
     * Returns the Star instance given its name.
     * @param starName - the name of the stars being searched.
     * @return - the Star instance if found, null otherwise.
     */
    public Star getStar(String starName) {
        int iStar = this.stars.indexOf(new Corpus(starName, 0));
        return (iStar != -1) ? this.stars.get(iStar) : null;
    }
    
    /**
     * Returns a representation of this galaxy as a string,
     * prefixed by a given number of spaces.
     * @param indent - number of spaces to use as an indent.
     */
    @Override
    public String toString(int indent) {
        String value = String.format("%s, with stars:\n", super.toString(indent));
        for(Star star: stars) {
            value += String.format("%s", star.toString(indent + 4));
        }
        return value;
    }
}
