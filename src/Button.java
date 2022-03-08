import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Button  extends JButton implements KeyListener {
    private Main frm;

    public Button(Main frm){
        super();
        this.frm=frm;
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() >= '0'  && e.getKeyChar()<='9')
        frm.setNumertoText(e.getKeyChar()+"");
        else if(e.getKeyChar()=='+')frm.setPlus();
        else if(e.getKeyChar()==e.VK_ENTER)frm.setEquals();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
