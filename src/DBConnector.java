import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

	private static String driverName = "com.mysql.jdbc.Driver";
	// JDBCのドライバー (Javaとデータベースを繋げる箱)の名前を変数に代入
	
	private static String url = "jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false";
	//URLの指定　localhost(自分のPC)testdb(データベース名)を使用
	//？以降はオプションのため必須ではない
	
	private static String user = "root";
	
	private static String password = "root";
	//パスワードは自分の環境に合ってるか確認する
	
	public Connection getConnection() {
		Connection con = null;
		//接続状態にする
		//一度状態を初期化
		
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
		}
		return con;
	}
}
