package cosmos;

/**
 * A generic astral corpus, such as a Galaxy, a Star, a Planet, etc.
 * Every corpus in space is expected to have at a name and an age.
 */
public class Corpus {
    // the name of this corpus (i.e. "Milky Way", "Sun", "Earth")
    private String name;
    
    // the age of the corpus, in billions of years
    private double age;
    
    /**
     * Constructs a new generic astral Corpus of a given name and age.
     * @param name - name of this corpus.
     * @param age - age of this corpus in billions of years.
     */
    public Corpus(String name, double age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Returns a representation of this astral corpus as a string,
     * prefixed by a given number of spaces.
     * @param indent - number of spaces to use as an indent.
     */
    public String toString(int indent) {
        String value = "";
        for (int i = 0; i < indent; i++) {
            value += " ";
        }
        value += String.format("%s [%.2f bln years old]", name, age);
        return value;
    }
    
    /**
     * Returns a string representation of this astral corpus.
     */
    @Override
    public String toString() {
        return toString(0);
    }

    /**
     * Two astral corpuses are considered to be equal (identical)
     * if they have the same name.
     */
    @Override
    public boolean equals(Object other) {
        return (other instanceof Corpus) 
            && ((Corpus) other).name.equals(this.name);
    }
}
