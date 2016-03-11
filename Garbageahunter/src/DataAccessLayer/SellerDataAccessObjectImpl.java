package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DatatransferObjects.Category;
import DatatransferObjects.Item;
import DatatransferObjects.Offer;
import DatatransferObjects.PostItem;
import DatatransferObjects.User;

public class SellerDataAccessObjectImpl implements SellerDataAccessObject{

	@Override
	public PostItem Post(PostItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cancelPost(PostItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PostItem editPost(PostItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer Auction(PostItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String username) {
		//check
		//System.out.println("+++");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		//check
		//System.out.println("+++");
		try{
			//check
			//System.out.println("+++");
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement("SELECT * FROM User WHERE UserName = ?");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			while(rs.next()){
				user = new User();
				user.setUserName(username);
				user.setPassword(rs.getString("Password"));
				user.setRegisterDate(rs.getDate("Register_Date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){rs.close();}
			}catch(SQLException ex){
				System.out.println(ex.getMessage());}
			try{
				if(pstmt != null){pstmt.close();}
			}catch(SQLException ex){System.out.println(ex.getMessage());}
			try{
				if(con != null){
					con.close();}
			}catch(SQLException ex){System.out.println(ex.getMessage());}	
		}
		return user;
	}

}
