
/**
 * Some simple class, with various kinds of methods.
 * This is going to be used to demonstrate how to call each method through reflection.
 * 
 * @author Florin
 *
 */
public class MyClass {
    
    public static void myStaticMethod(String text) {
        System.out.printf("In myStaticMethod, with text '%s'\n", text);
    }

    public void myIntanceMethod(String text, int number) {
        System.out.printf("In myIntanceMethod, with text '%s' and number '%d'\n", text, number);
    }
    
    @SuppressWarnings("unused")
    private int myPrivateMethod() {
        System.out.printf("In myPrivateMethod, no arguments, returning int\n");
        return 42;
    }
    
    public MyClass() {
        System.out.println("MyClass default constructor");
    }
    
    public MyClass(int someParam) {
        System.out.printf("MyClass constructor with parameter %d\n", someParam);
    }
    
    public String toString() {
        return String.format("Printing instance %s@%x", this.getClass(), this.hashCode());
    }
    
}
