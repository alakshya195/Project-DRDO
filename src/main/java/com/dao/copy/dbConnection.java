package com.dao.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.projectDRDO.aircraftData;
import java.util.concurrent.atomic.DoubleAdder;

public class dbConnection {

	static long startTime = System.currentTimeMillis();

	static Connection con = null;


	public static ArrayList<aircraftData> getConnection() 
	{

		ArrayList<aircraftData> data = new ArrayList<>();

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"googleselectme");

			PreparedStatement st = con.prepareStatement("Select * From project_1");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				aircraftData aircraftData = new aircraftData( 

						rs.getInt("total_fatalities"), rs.getString("date"), rs.getString("aircraft"),
						rs.getString("crash_location"), rs.getString("country"));

				data.add(aircraftData);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Opened database successfully");

		/* to check program is successfully retrieving records from database

		for (aircraftData s : data) // Iterates as long as there are elements in the list.
		{
			System.out.print("Details of Total Fatalities, Date, Aircraft and Country are : ");
			System.out.println(s.getTotal_fatalities() + " " + s.getDate() + " " + s.getAircraft() + " " + s.getCountry());
		}
		 */
		long dataSize = data.size();
		System.out.println("Total Number of Records: inside db" + dataSize);

		return data;


	}	
}







































