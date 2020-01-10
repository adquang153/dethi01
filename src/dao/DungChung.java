package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.print("da xac dinh HQTCSDL");
		String url="jdbc:sqlserver://DESKTOP-R9EMP3B\\SQLEXPRESS:1433;databaseName=DeThiMau;user=sa; password=123";
		cn=DriverManager.getConnection(url);
		System.out.print("Da ket noi");
	}
}
