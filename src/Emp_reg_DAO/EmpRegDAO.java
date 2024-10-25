package Emp_reg_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class EmpRegDAO {
	public int save(int id,String name,String email,String address) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=conn.prepareStatement("insert into azenemp values (?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, address);
		int i=ps.executeUpdate();
		return i;
	}
	public boolean update(int id,String name,String email,String address) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=conn.prepareStatement("update azenemp set name=?,email=?,address=? where id=?");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, address);
		ps.setInt(4, id);
		int i=ps.executeUpdate();
		if(i!=0)
			return true;
		else 
		   return false;
		
		}
	
	public int delete(int id) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=conn.prepareStatement("delete from azenemp where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		return i;
		
	}
	
	public ArrayList<HashMap<String,Object>> find(int id)throws Exception{
		ArrayList<HashMap<String,Object>> emplist=new ArrayList<>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			PreparedStatement ps=conn.prepareStatement("select * from azenemp where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				HashMap<String,Object> empmap=new HashMap<>();
				empmap.put("id", rs.getInt("id"));//by name 
				empmap.put("name", rs.getString("name"));//just an string
				empmap.put("email",rs.getString(3));//by column index in table
				empmap.put("addr", rs.getString("address"));
				emplist.add(empmap);
			}
			conn.close();
			System.out.println("after iterations :"+emplist);
		}catch(Exception e){
			e.printStackTrace();
		}
		return emplist;
	}
}
