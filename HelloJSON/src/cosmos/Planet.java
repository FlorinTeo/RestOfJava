package cosmos;

public class Planet extends Corpus {

    /**
     * Planets composition types.
     * @see <a href=https://www.worldatlas.com/articles/how-many-types-of-planets-are-there-on-the-basis-of-composition.html>World Atlas</a>
     */
    public enum Composition {
        Chthonian,
        Carbon,
        Coreless,
        Desert,
        Dwarf,
        GasGiant,
        Helium,
        Hycean,
        IceGiant,
        Ice,
        Iron,
        Lava,
        Ocean,
        Proto,
        Puffy,
        Silicate,
        Terrestrial,
    }
    
    // The composition type of this planet
    private Composition composition;
    
    /**
     * Constructs a new Planet of a given name, age and composition.
     * @param name - name of this planet.
     * @param age - age of this planet in billions of years.
     * @param composition - composition of this planet.
     */
    public Planet(String name, double age, Composition composition) {
        super(name, age);
        this.composition = composition;
    }
    
    /**
     * Returns a representation of this planet as a string,
     * prefixed by a given number of spaces.
     * @param indent - number of spaces to use as an indent of the string.
     */
    @Override
    public String toString(int indent) {
        return String.format("%s, %s planet\n", super.toString(indent), composition.toString());
    }
}
