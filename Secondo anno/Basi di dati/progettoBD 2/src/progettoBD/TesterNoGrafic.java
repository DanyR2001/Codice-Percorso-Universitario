package progettoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TesterNoGrafic {

	private static final String DB_URL="jdbc:mysql://localhost/progetto2022";
	private static final String USER="root";
	private static final String PAS="Vaffanculo12";

	public static void main(String[] args) {
		QueryManger q=new QueryManger(DB_URL,USER,PAS);
		System.out.print(q.print(q.makeQuery("Select * from Vinili")));
	}

}
