package ErrorHandlers;

import javax.swing.*;

public class ServiceException extends Exception{
    //para las que salten del service layer
    public ServiceException(String Message) {
        super();
        JOptionPane.showMessageDialog(null,Message);
    }
}
