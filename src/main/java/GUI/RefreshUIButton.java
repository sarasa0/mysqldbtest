package GUI;

import ErrorHandlers.GUIException;
import ErrorHandlers.ServiceException;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class RefreshUIButton extends JButton{
    private JFrame myFrame;

    public RefreshUIButton(String text){
        setModel(new DefaultButtonModel());
        init(text,null);
        MouseListener a = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    myFrame.dispose();
                    new UserInterface();
                } catch (Exception e1) {
                    try {
                        throw new GUIException("Fallo al refrescar la UI");
                    } catch (GUIException e2) {
                        new ServiceException("Falla de Servicio por Error de GUI:\n"+e2.getMessage());
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        addMouseListener(a);
    }
    public void setMyFrame (JFrame myFrame){
        this.myFrame=myFrame;
    }
}
