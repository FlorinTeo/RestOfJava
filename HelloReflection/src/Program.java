import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    /**
     * Prints all the methods defined in a class.
     * @param c - class containing all methods. 
     */
    public static void ListMethods(Class<?> c) {
        System.out.printf("-- %s methods --------\n", c.getName());
        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods) {
            System.out.printf("\t%s\n", m);
        }
        System.out.println("--------\n");
    }
    
    public static void ListConstructors(Class<?> c) {
        System.out.printf("-- %s constructors --------\n", c.getName());
        Constructor<?>[] ctors = c.getDeclaredConstructors();
        for(Constructor<?> ctor : ctors) {
            System.out.printf("\t%s\n", ctor);
        }
        System.out.println("--------\n");
    }
    
    /**
     * Calls a static method from a class. The method is expected to have
     * only one string argument.
     * @param className - name of the class.
     * @param methodName - name of the method.
     * @param arg - argument value.
     */
    public static void CallStatic(String className, String methodName, String arg)
            throws ClassNotFoundException, 
                   NoSuchMethodException,
                   SecurityException,
                   IllegalAccessException,
                   IllegalArgumentException,
                   InvocationTargetException {
        Class<?> c = Class.forName(className);
        Method m = c.getDeclaredMethod(methodName, String.class);
        m.invoke(null, arg);
    }
    
    /**
     * Calls an instance method of an object. The method is expected to have
     * one string argument and one int argument.
     * @param obj - object having the method being called.
     * @param methodName - name of the method.
     * @param arg1 - first (String) argument.
     * @param arg2 - second (int) argument.
     */
    public static void CallInstance(Object obj, String methodName, String arg1, int arg2)
            throws NoSuchMethodException,
                   SecurityException,
                   IllegalAccessException,
                   IllegalArgumentException,
                   InvocationTargetException {
        Class<?> c = obj.getClass();
        Method m = c.getDeclaredMethod(methodName, String.class, int.class);
        m.invoke(obj, arg1, arg2);
    }
    
    /**
     * Calls a private method of an object. The method is expected to have
     * no arguments and returning an int.
     * @param obj - object having the private method being called.
     * @param methodName - name of the method.
     */
    public static void CallPrivate(Object obj, String methodName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> c = obj.getClass();
        Method m = c.getDeclaredMethod(methodName);
        m.setAccessible(true);
        int value = (int)m.invoke(obj);
        System.out.printf("Returned %d\n", value);
    }

    public static Object CallCreateInstance(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> c = Class.forName(className);
        Constructor<?> ctor = c.getDeclaredConstructor(int.class);
        return ctor.newInstance(42);
    }
    
    public static void main(String[] args) 
            throws ClassNotFoundException,
                   NoSuchMethodException,
                   SecurityException,
                   IllegalAccessException,
                   IllegalArgumentException,
                   InvocationTargetException, InstantiationException {
        System.out.println("Hello to Java reflection!");
        System.out.println();
        
        // create an object
        MyClass myObject = new MyClass();
        
        // list all the methods defined in MyClass
        ListMethods(MyClass.class);
        // calls MyClass.myStaticMethod("general");
        CallStatic("MyClass", "myStaticMethod", "general");
        // calls myObject.myInstanceMethod("specific", 42);
        CallInstance(myObject, "myIntanceMethod", "specific", 42);
        // calls myObject.myPrivateMethod() and prints the return value
        CallPrivate(myObject, "myPrivateMethod");
        
        // creates an instance of the given class
        ListConstructors(MyClass.class);
        Object otherObject = CallCreateInstance("MyClass");
        System.out.println(otherObject);
    }
}

