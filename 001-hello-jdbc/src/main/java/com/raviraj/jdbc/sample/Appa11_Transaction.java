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
public class Appa11_Transaction {

	public static void main(String[] args) throws SQLException {

		Connection conn = ConnectionUtil.getConnection();

		System.out.println(" conn  isClosed  " + conn.isClosed());

		// When a connection is created, it is in auto-commit mode. This means that each individual SQL statement is
		// treated as a transaction and is automatically committed right after it is executed.

		// The way to allow two or more statements to be grouped into a transaction is to disable the auto-commit mode.
		conn.setAutoCommit(false);
		try {

			String query1 = " INSERT INTO `Student` (`name`, `age`) VALUES (?, ?);";
			PreparedStatement statement1 = conn.prepareStatement(query1);
			statement1.setString(1, "Raj");
			statement1.setInt(2, 99);
			int rowCount1 = statement1.executeUpdate();
			System.out.println(" row Count1 " + rowCount1);
			statement1.close();

			String query2 = " <invalid Query12323? UPDATE `Student` SET `age`='100' WHERE `name`= ? 1";
			PreparedStatement statement2 = conn.prepareStatement(query2);
			statement2.setString(1, "Raj");
			int rowCount2 = statement2.executeUpdate();
			System.out.println(" row Count2 " + rowCount2);
			statement2.close();

			// the auto-commit mode is disabled for the connection conn, which means that the two prepared statements
			// insert and update are committed together when the method commit() is called.
			// Whenever the commit method is called , all changes resulting from statements in the transaction are made
			// permanent.
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// calling the method rollback terminates a transaction and returns any values that were modified to their
			// previous values. If you are trying to execute one or more statements in a transaction and get a
			// SQLException, call the method rollback to end the transaction and start the transaction all over again.
			conn.rollback();
		} finally {
			// enables auto-commit mode, which means that each statement is once again committed automatically
			// When it is completed.
			conn.setAutoCommit(true);
		}

		conn.close(); // this returns the connection to the pool

		ConnectionUtil.closeDataSource();

	}
}
