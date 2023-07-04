package com.projectDRDO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{  
  
 public void contextInitialized(ServletContextEvent e) {  
	 Connection con = null;
	 ArrayList<aircraftData> data = new ArrayList<>();
	 try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"googleselectme");

			PreparedStatement st = con.prepareStatement("Select * From project_1");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				aircraftData aircraftData = new aircraftData( // rs.getString("time"),

						rs.getInt("total_fatalities"), rs.getString("date"), rs.getString("aircraft"),
						rs.getString("crash_location"), rs.getString("country"));

				data.add(aircraftData);
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
			System.exit(0);
		} 
	 
	   ServletContext context=e.getServletContext();  
	   context.setAttribute("data",data);  
	          
	 }  
	 public void contextDestroyed(ServletContextEvent arg0) {  
	    System.out.println("project undeployed...");  
	 }  
	  
	 
}
