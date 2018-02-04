/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmed;

import  java.sql.*;
import java.util.ArrayList;
import java.util.List;
    public  class  dbc { 
     Connection connect;  
     
        public  void dbco(){
          try{
     	    Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");     
          } 
          catch (   SQLException | ClassNotFoundException  Sql){
          System.out.print(Sql );
          }
        } 
     
        public List <person> retrieveAllPersons(String name) throws SQLException{
          List <person> personList = new ArrayList<>();
          dbco();
          Statement statement = connect.createStatement( );
               String qu = "select * from student where Name like '%"+name+"%'";
          ResultSet  resultSet = statement.executeQuery(qu);
          while ( resultSet.next( ) ){
            person person=new person();
	    	person.setId(resultSet.getInt("id"));
	    	person.setName(resultSet.getString("Name"));
	    	person.setAdress(resultSet.getString("Address"));
                person.setAge(resultSet.getInt("age"));
	    	personList.add(person);
           }
                   return personList;
        }
        
   public List<person> retrievePerson(int id) throws SQLException{
          List<person> per = new ArrayList<>();
          dbco();
          Statement statement = connect.createStatement( );
               String qu = "select * from student where id="+id;
          ResultSet  resultSet = statement.executeQuery(qu);
         
          while ( resultSet.next( ) ){
           person person=new person();
	    	person.setId(resultSet.getInt("id"));
	    	person.setName(resultSet.getString("Name"));
	    	person.setAdress(resultSet.getString("Address"));
                person.setAge(resultSet.getInt("age"));
	    	per.add(person);
           }
                   return per;
        }
        //////////////////////////////////////////////////////////////////
  public List <person> retrieveAll() throws SQLException{
          List <person> personList = new ArrayList<>();
          dbco();
          Statement statement = connect.createStatement( );
               String qu = "select * from student";
          ResultSet  resultSet = statement.executeQuery(qu);
          while ( resultSet.next( ) ){
            person person=new person();
	    	person.setId(resultSet.getInt("id"));
	    	person.setName(resultSet.getString("Name"));
	    	person.setAdress(resultSet.getString("Address"));
                person.setAge(resultSet.getInt("age"));
	    	personList.add(person);
           }
                   return personList;
        }
        
        
        
    }