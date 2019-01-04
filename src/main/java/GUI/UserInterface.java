package GUI;

import Listeners.TreeActionListener;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private PanelQuery querypanel;
    private PanelTree treepanel;

    public PanelQuery getQuerypanel() {
        return querypanel;
    }

    public PanelTree getTreepanel() {
        return treepanel;
    }

    public UserInterface() {
        super("Cliente SQL");
        CrearUI();
    }

    public void CrearUI() {
        treepanel = new PanelTree();
        querypanel = new PanelQuery();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        treepanel.getDBStruct().addMouseListener(new TreeActionListener(this));
        add(treepanel, BorderLayout.WEST);
        add(querypanel, BorderLayout.CENTER);
        validate();
        repaint();
        pack();
        setVisible(true);
    }


}
