package Service;

import DBManagement.DBMetaDataManager;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;

public class JTreeBuilder extends JTree {
    private DBMetaDataManager Manager;
    private DefaultMutableTreeNode RootNode = null;
    private DefaultMutableTreeNode tables = null;
    private DefaultTreeModel DBModel;

    /**
     * esta clase construye un Jtree
     */
    public JTreeBuilder() {
        Manager = new DBMetaDataManager();
        ArrayList<String> tabnames = Manager.getTablas();
        ArrayList<ArrayList<String>> colnames = Manager.getTabycol();

        RootNode = new DefaultMutableTreeNode(Manager.getRootNode());
        tables = new DefaultMutableTreeNode("Tables");
        DefaultMutableTreeNode table = null;
        DefaultMutableTreeNode atrib = null;
        for (int j = 0; j < tabnames.size(); j++) {
            table = new DefaultMutableTreeNode(tabnames.get(j));
            for (int k = 0; k < colnames.get(j).size(); k++) {
                atrib = new DefaultMutableTreeNode(colnames.get(j).get(k));
                table.add(atrib);
            }
            tables.add(table);
        }
        RootNode.add(tables);
        DBModel = new DefaultTreeModel(RootNode);

        setModel(DBModel);
    }
}
