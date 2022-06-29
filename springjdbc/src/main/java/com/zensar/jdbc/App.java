package com.zensar.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zensar.jdbc.dao.ClientDao;
import com.zensar.jdbc.entities.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Programe Started..." );
        
        // spring jdbc = JdbcTemplate
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/zensar/jdbc/context.xml");
        ClientDao clientDao = context.getBean("clientDao",ClientDao.class);
        Client client = new Client();
        
//        Insert Data
//        client.setId(10);
//        client.setName("Rohit");
//        client.setCity("Pune");
//        int result = clientDao.insert(client);
//        System.out.println("Inserted Sucessfully.." + result);
        
        
//        Update Data
//        client.setId(4);
//        client.setName("Mangesh");
//        client.setCity("Mumbai");
//        int result = clientDao.update(client);
//        System.out.println("Client Updated Sucessfully.." + result);
        

//      Delete Data  
        int result = clientDao.delete(10);
        System.out.println("Client Deleted Sucessfully.." + result);
             
        
//       JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
        
        
//         Insert Query
        
//        String query = "insert into client(id,name,city) values(?,?,?)";
//        
//        Fired The Query
//        int result = template.update(query,4,"Rahul","Nashik");
//        
//        System.out.println("The data inserted to the table--> " + result);
    }
}
