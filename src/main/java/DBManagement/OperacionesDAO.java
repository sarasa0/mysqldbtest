package DBManagement;

import ErrorHandlers.DAOException;

import java.util.ArrayList;

public interface OperacionesDAO {

    ArrayList<ArrayList<Object>> SQLQUERY(String sql) throws DAOException;

}
