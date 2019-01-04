package GUI;

import Listeners.PanelQueryActionListener;

import javax.swing.*;

public class PanelQuery extends JPanel {

    private PanelOutput outputpanel;
    private PanelInput inputpanel;

    public PanelOutput getOutputpanel() {
        return outputpanel;
    }

    public PanelInput getInputpanel() {
        return inputpanel;
    }

    public PanelQuery() {
        outputpanel = new PanelOutput();
        inputpanel = new PanelInput();
        inputpanel.getExecute().addActionListener(new PanelQueryActionListener(this));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(inputpanel);
        add(outputpanel);
    }

}
