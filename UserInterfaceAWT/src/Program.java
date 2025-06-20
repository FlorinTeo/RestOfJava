import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class Program {

    // Main Frame, with a title bar and custom title.
    private static Frame myFrame = new Frame("Java AWT Demo");
    // Two Buttons in the first row in the Frame
    private static Button myButton1 = new Button("Dare!");
    private static Button myButton2 = new Button("Don't do it!");
    // Label and TextField in the second row in the Frame
    private static Label myLabel = new Label("Just say it:");
    private static TextField myTextField = new TextField();
    // TextArea in the third row in Frame
    private static TextArea myTextArea = new TextArea();
    // Canvas filling up the rest of the Frame
    private static MyCanvas myCanvas = new MyCanvas();
    
    // Create a main listener object
    private static MyListener myListener = new MyListener(myTextArea);
    
    public static void main(String[] args) {
        System.out.println("Hello to Java Abstract Window Toolkit (AWT)!");
        
        // Configure the frame to 600 x 400 pixels, centered on the screen.
        myFrame.setSize(600, 400);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.setResizable(false);
        myFrame.addWindowListener(myListener);

        // Make the frame visible
        myFrame.setVisible(true);
        
        // Once the frame is visible, get its insets
        Insets insets = myFrame.getInsets();
        System.out.println("Insets: ");
        System.out.printf("    top=%d, left=%d, bottom=%d, right=%d\n",
                insets.top, insets.left, insets.bottom, insets.right);
        
        // The effective (drawable) area of the frame is 
        // within the (top, left) and (bottom, right) insets.
        int xMin = insets.left;
        int yMin = insets.top;
        int xMax = myFrame.getWidth() - insets.right;
        int yMax = myFrame.getHeight() - insets.bottom;
        System.out.println("Effective (drawable) area:");
        System.out.printf("    from top-left: (%d, %d)\n", xMin, yMin);
        System.out.printf("    to bottom-right: (%d, %d)\n", xMax, yMax);
        
        addButtons();
        
        addTextField();
        
        addTextArea();
        
        addCanvas();
        
        System.out.println("Goodbye");
    }
    
    /**
     * Add two buttons to the frame
     */
    public static void addButtons() {
        Insets insets = myFrame.getInsets();
        
        // Configure first button
        myButton1.setBounds(insets.left + 10, insets.top + 10, 80, 40);
        myButton1.addActionListener(myListener);
        myFrame.add(myButton1);
        
        // configure second button
        myButton2.setBounds(
                myButton1.getX() + myButton1.getWidth() + 10,
                myButton1.getY(),
                80, 40);
        myButton2.addActionListener(myListener);
        myFrame.add(myButton2);
    }
    
    /**
     * Add a label and a text field to the frame
     */
    private static void addTextField() {
        myLabel.setBounds(
                myButton1.getX(),
                myButton1.getY() + myButton1.getHeight() + 10,
                80, 20);
        myFrame.add(myLabel);
        myTextField.setBounds(
                myButton2.getX(),
                myButton2.getY() + myButton2.getHeight() + 10,
                myFrame.getWidth() - myButton2.getX() - myFrame.getInsets().right - 10, 20);
        myTextField.addKeyListener(myListener);
        myFrame.add(myTextField);
    }
    
    /**
     * Add a read-only text area to the form
     */
    private static void addTextArea() {
        int xAnchor = myLabel.getX();
        int yAnchor = myLabel.getY() + myLabel.getHeight() + 10;
        myTextArea.setBounds(
                xAnchor, yAnchor, 
                myFrame.getWidth() - xAnchor - myFrame.getInsets().right - 10,
                120);
        myTextArea.setEditable(false);
        myFrame.add(myTextArea);
    }
    
    private static void addCanvas() {
        int xAnchor = myTextArea.getX();
        int yAnchor = myTextArea.getY() + myTextArea.getHeight() + 10;
        myCanvas.setBounds(
                xAnchor, yAnchor,
                myFrame.getWidth() - xAnchor - myFrame.getInsets().right - 10,
                myFrame.getHeight() - yAnchor - myFrame.getInsets().bottom - 10);
        myCanvas.setBackground(new Color(240,240,240));
        myFrame.add(myCanvas);
    }

}
