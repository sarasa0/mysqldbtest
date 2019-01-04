package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class PanelOutput extends JPanel {

    private JTable queryOutputTable;

    public PanelOutput() {
        setLayout(new BorderLayout());
        queryOutputTable = new JTable();
        JScrollPane scroll = new JScrollPane(queryOutputTable);
        scroll.setPreferredSize(new Dimension(800, 240));
        setBorder(BorderFactory.createTitledBorder(new TitledBorder("Output")));
        add(scroll, BorderLayout.SOUTH);
    }

    public JTable getQueryOutputTable() {
        return queryOutputTable;
    }


}
