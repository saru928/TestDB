import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUserDAO {

	String name = "";
	String password = "";
	
	public void select(String name,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		//DBへの接続準備
		
		String sql = "select * from test_table where user_name=? and password=?";
		//?はプレースホルダー。都度違うデータを入れたい際に使用
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//PreparedStatementとは DBまで運んでくれる箱
			//executeQuery();は実行メソッド。必ずResultSetが返ってくる
			if(rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
			//データベースを終了させるという意味
			//これがないとデータベースに接続したまま次の作業が実行され、メモリに負荷がかかる
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
