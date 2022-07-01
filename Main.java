package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("  BEAST ","  Vijay  ","PoojaHegde",2022,"Nelson");
	insert("  DON  ","SivaKarthikeyan","Priyanka Mohan",2022,"Cibi Chakaravarthi");
	insert("AYAN "," Surya","Tamana",2009,"K.V Anand");
	insert("PATTAS","Dhanush   ","Mehreen Pirzada ",2020,"R.S Durai Senthilkumar");
	insert("WAR","Hrithik Roshan","Vaani Kapoor ",2019,"Siddharth Anand");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
