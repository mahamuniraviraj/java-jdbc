/*-
 *  File    :   App3_CreateConnectionPooledDataSource.java
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

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author raviraj
 * @date   Aug 23, 2018
 * @since  1.0
 */
public class App3_CreateConnectionPooledDataSource {

	public static void main(String[] args) throws SQLException {

		HikariConfig jdbcConfig = new HikariConfig();

		jdbcConfig.setJdbcUrl(JdbcConst.jdbcUrl);
		jdbcConfig.setUsername(JdbcConst.userName);
		jdbcConfig.setPassword(JdbcConst.password);

		jdbcConfig.setPoolName("SamplePool");
		jdbcConfig.setMaximumPoolSize(10);
		jdbcConfig.setMinimumIdle(5);

		HikariDataSource dataSource = new HikariDataSource(jdbcConfig);

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

		dataSource.close();

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
