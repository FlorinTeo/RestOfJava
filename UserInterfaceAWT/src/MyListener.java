import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;

/**
 * Main Listener class, implementing all listener interfaces
 * needed for reacting to user actions. An instance of this
 * object is registered with each of the UI components.
 */
public class MyListener implements WindowListener, ActionListener, KeyListener {

    private TextArea _console;
    
    private void printText(String text) {
        String crtText = _console.getText();
        String newText = crtText + "\n" + text;
        _console.setText(newText);
        _console.setCaretPosition(newText.length());
    }
    
    public MyListener(TextArea console) {
        _console = console;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        printText("Opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        printText("Closing");
        ((Frame)e.getSource()).dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        printText("Closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        printText("Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        printText("Deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        printText("Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        printText("Deactivated");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        printText(e.getActionCommand());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\n' && e.getSource() instanceof TextField) {
            TextField textField = (TextField)e.getSource();
            printText(textField.getText());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
