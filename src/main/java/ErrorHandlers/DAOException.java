package ErrorHandlers;

import javax.swing.*;

public class DAOException extends Exception {
    //para los que salten del dao
    public DAOException(String message) {
        super(message);
        //JOptionPane.showMessageDialog(null,message);

    }
}
