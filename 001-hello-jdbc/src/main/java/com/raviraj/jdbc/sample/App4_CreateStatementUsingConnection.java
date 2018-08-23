/*-
 *  File    :   App4_CreateStatementUsingConnection.java
 *  Version :   1.0
 *  Date    :   Aug 23, 2018
 *  Author  :   raviraj
 *
    This file is part of 001-hello-jdbc.

    001-hello-jdbc is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    001-hello-jdbc is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with 001-hello-jdbc.  If not, see <http://www.gnu.org/licenses/>.

 */
package com.raviraj.jdbc.sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author raviraj
 * @date   Aug 23, 2018
 * @since  1.0
 */
public class App4_CreateStatementUsingConnection {

	public static void main(String[] args) throws SQLException {

		Connection conn = ConnectionUtil.getConnection();

		System.out.println(" conn  isClosed  " + conn.isClosed());

		String query = " Select * from Student where id =1";

		// Statement: Used to implement simple SQL statements with no parameters.
		Statement statement = conn.createStatement();

		// executeQuery: Returns one ResultSet object.
		ResultSet resultSet = statement.executeQuery(query);

		/*You access the data in a ResultSet object through a cursor.
		 * Note that this cursor is not a database cursor.
		 * This cursor is a pointer that points to one row of data in the ResultSet object.
		 *  Initially, the cursor is positioned before the first row.
		 *  You call various methods defined in the ResultSet object to move the cursor.*/

		while (resultSet.next()) {

			System.out.println(" id   :: " + resultSet.getInt("id"));
			System.out.println(" name :: " + resultSet.getString("name"));
			System.out.println(" age  :: " + resultSet.getInt("age"));

		}

		resultSet.close();

		statement.close();

		conn.close(); // this returns the connection to the pool

		ConnectionUtil.closeDataSource();

	}
}
