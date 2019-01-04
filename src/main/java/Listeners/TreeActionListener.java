package Listeners;

import GUI.UserInterface;
import Service.JTableBuilder;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TreeActionListener implements MouseListener {

    private UserInterface UI;

    public TreeActionListener(UserInterface UI) {
        this.UI = UI;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) UI.getTreepanel().getDBStruct().getLastSelectedPathComponent();
            if (node == null) {
                return;
            }
            Object nodeInfo = node.getUserObject();
            JTableBuilder table = new JTableBuilder();
            table.buildTable("SELECT * FROM " + nodeInfo.toString(), UI.getQuerypanel().getOutputpanel().getQueryOutputTable());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
