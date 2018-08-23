/*-
 *  File    :   App2_CreateConnectionDataSource.java
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
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * @author raviraj
 * @date   Aug 23, 2018
 * @since  1.0
 */
public class App2_CreateConnectionDataSource {

	public static void main(String[] args) throws SQLException {

		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl(JdbcConst.jdbcUrl);
		ds.setUser(JdbcConst.userName);
		ds.setPassword(JdbcConst.password);

		DataSource dataSource = ds;

		Connection conn = dataSource.getConnection();

		DatabaseMetaData data = conn.getMetaData();

		String url = data.getURL();
		String uname = data.getUserName();
		String drivername = data.getDriverName();

		String driverVersin = data.getDriverVersion();
		int driverajorVersion = data.getDriverMajorVersion();
		int driverMinorVersion = data.getDriverMinorVersion();

		int jdbcMajorversion = data.getJDBCMajorVersion();
		int jdbcMinorVersion = data.getJDBCMinorVersion();
		conn.close();

		System.out.println("jdbcUrl ::" + url);
		System.out.println("user name ::" + uname);
		System.out.println("driver name ::" + drivername);
		System.out.println("driver version ::" + driverVersin);
		System.out.println("driver major version ::" + driverajorVersion);
		System.out.println("driver minor version ::" + driverMinorVersion);

		System.out.println("jdbc Major version ::" + jdbcMajorversion);
		System.out.println("jdbc Minor version ::" + jdbcMinorVersion);
	}

}
