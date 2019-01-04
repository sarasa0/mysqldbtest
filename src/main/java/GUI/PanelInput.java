package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelInput extends JPanel {

    private JTextArea queryInput;
    private JButton execute;

    public JButton getExecute() {
        return execute;
    }

    public JTextArea getQueryInput() {
        return queryInput;
    }

    public PanelInput() {
        setLayout(new BorderLayout());
        queryInput = new JTextArea();
        JScrollPane scroll = new JScrollPane(queryInput);
        queryInput.setPreferredSize(new Dimension(320, 50));
        add(scroll, BorderLayout.CENTER);
        execute = new JButton("Execute");
        setBorder(BorderFactory.createTitledBorder("Input"));
        add(execute, BorderLayout.SOUTH);
    }

}
