package beans123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class VoterDao {

	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Votersystem","root","Rushikesh@123");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return con;
		
	}
	
	public static int InsertVoter(Voter voter) {
		int status = 0;
		PreparedStatement ps;
		
		try {
			Connection con = getConnection();
			ps= con.prepareStatement("Insert into voter(name,lastname,password,age,location,country) values(?,?,?,?,?,?)");
			ps.setString(1, voter.getName());
			ps.setString(2, voter.getLastname());
			ps.setString(3, voter.getPassword());
			ps.setInt(4, voter.getAge());
			ps.setString(5, voter.getLocation());
			ps.setString(6, voter.getCountry());
			
		    status = ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Voter>getAllVoter(){
		Connection con = getConnection();
		List<Voter>list = new ArrayList<Voter>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from voter");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Voter voter = new Voter();
				
				voter.setId(rs.getInt("id"));
				voter.setName(rs.getString("name"));
				voter.setLastname(rs.getString("lastname"));
				voter.setPassword(rs.getString("password"));
				voter.setAge(rs.getInt("age"));
				voter.setLocation(rs.getString("location"));
				voter.setCountry(rs.getString("country"));
				list.add(voter);
				
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static boolean getAge(int age) {
		boolean flag = false;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("select * from voter where age >= ?");
			ps.setInt(1, age);
			ResultSet rs = ps.executeQuery();
			flag = rs.next();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean getName(String name) {
		boolean flag1 = false;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("select * from voter where name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			flag1 = rs.next();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag1;
		
	}
	

	public static int deleteData(int id) {
		int status = 0;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Delete from voter where id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static Voter getVoter (int id) {
		Connection con = getConnection();
		PreparedStatement ps;
		Voter vote = new Voter();
		
		try {
			ps = con.prepareStatement("select * from voter where id=?");
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			  
			if(rs.next()) {
				vote.setId(rs.getInt("id"));
				vote.setName(rs.getString("name"));
				vote.setLastname(rs.getString("lastname"));
				vote.setPassword(rs.getString("password"));
				vote.setAge(rs.getInt("age"));
				vote.setLocation(rs.getString("location"));
				vote.setCountry(rs.getString("country"));	
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vote;
	}
	
//	public static Voter getVoter1(int age) {
//		PreparedStatement ps;
//		Connection con = getConnection();
//		Voter vote = new Voter();
//		
//		try {
//			ps = con.prepareStatement("select * from voter where age = ?");
//			ps.setInt(1, age);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				vote.setId(rs.getInt("id"));
//				vote.setName(rs.getString("name"));
//				vote.setLastname(rs.getString("lastname"));
//				vote.setPassword(rs.getString("password"));
//				vote.setAge(rs.getInt("age"));
//				vote.setLocation(rs.getString("location"));
//				vote.setCountry(rs.getString("country"));
//			}
//			
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return vote;
//	}

	
	public static int UpdateVoter(String name, String lastname, String password, int age, String location, String country,int id) {
		
		PreparedStatement ps;
		int status = 0;
		 try {
			 Connection con = getConnection();
			 ps = con.prepareStatement("update voter set name =?, lastname=?,password=?, age =?, location =?, country =? where id=?");
			
			 ps.setString(1, name);
			 ps.setString(2, lastname);
			 ps.setString(3, password);
			 ps.setInt(4, age);
			 ps.setString(5, location);
			 ps.setString(6, country);
			 ps.setInt(7, id);
			 status = ps.executeUpdate();
			 
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return status;
	}
	
	public static int InsertParty(Voter vote) {
		int status = 0;
		PreparedStatement ps;
		 
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("insert into Party(party,votes) values(?,?)");
			ps.setString(1, vote.getParty());
			ps.setInt(2, vote.getVote());
			status = ps.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return status;
	}
	
}
