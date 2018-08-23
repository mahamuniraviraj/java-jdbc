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
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author raviraj
 * @date   Aug 23, 2018
 * @since  1.0
 */
public class App9_CreatePreparedStatementUsingConnectionForDelete {

	public static void main(String[] args) throws SQLException {

		Connection conn = ConnectionUtil.getConnection();

		System.out.println(" conn  isClosed  " + conn.isClosed());

		String query = "DELETE FROM `demo_db`.`Student` WHERE `name`= ? ";

		PreparedStatement statement = conn.prepareStatement(query);

		statement.setString(1, "Kiran");

		// Returns an integer representing the number of rows affected by the SQL statement.
		// Use this method if you are
		// using INSERT, DELETE, or UPDATE SQL statements.
		int rowCount = statement.executeUpdate();

		System.out.println(" row Count " + rowCount);

		statement.close();

		conn.close(); // this returns the connection to the pool

		ConnectionUtil.closeDataSource();

	}
}
