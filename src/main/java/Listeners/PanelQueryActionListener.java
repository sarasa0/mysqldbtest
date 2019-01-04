package Listeners;

import GUI.PanelQuery;
import Service.JTableBuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelQueryActionListener implements ActionListener {
    private PanelQuery panelquery;

    public PanelQueryActionListener(PanelQuery panelquery) {
        super();
        this.panelquery = panelquery;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTableBuilder tabla = new JTableBuilder();
        tabla.buildTable(panelquery.getInputpanel().getQueryInput().getText(), panelquery.getOutputpanel().getQueryOutputTable());
        panelquery.validate();
        panelquery.repaint();

    }
}
