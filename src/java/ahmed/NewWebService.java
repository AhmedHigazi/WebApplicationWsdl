/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmed;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ahmed Higazi
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     * @param Name
     * @return 
     */
    @WebMethod(operationName = "getpersons")
    public List<person> getpersons(@WebParam(name = "Name")String Name)  {
         List<person> personList = new ArrayList<>();
        try{
            dbc dbh=new dbc();
            personList=dbh.retrieveAllPersons(Name);
        }
        catch (SQLException e) {
		}
        return personList;
    }
    
     @WebMethod(operationName = "getperson")
    public List<person> getperson(@WebParam(name = "id")int id)  {
         List<person> personList = new ArrayList<>();
        try{
            dbc dbh=new dbc();
            personList=dbh.retrievePerson(id);
        }
        catch (SQLException e) {
		}
        return personList;
    }
    
     @WebMethod(operationName = "getAll")
    public List<person> getAll()  {
         List<person> personList = new ArrayList<>();
        try{
            dbc dbh=new dbc();
            personList=dbh.retrieveAll();
        }
        catch (SQLException e) {
		}
        return personList;
    }
}
