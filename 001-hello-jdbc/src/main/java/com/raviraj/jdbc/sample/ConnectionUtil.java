/*-
 *  File    :   ConnectionUtil.java
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
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author raviraj
 * @date   Aug 23, 2018
 * @since  1.0
 */
public class ConnectionUtil {

	private static HikariDataSource dataSource = null;

	private static HikariDataSource createDataSource() {

		HikariConfig jdbcConfig = new HikariConfig();

		jdbcConfig.setJdbcUrl(JdbcConst.jdbcUrl);
		jdbcConfig.setUsername(JdbcConst.userName);
		jdbcConfig.setPassword(JdbcConst.password);

		jdbcConfig.setPoolName("SamplePool");
		jdbcConfig.setMaximumPoolSize(3);
		jdbcConfig.setMinimumIdle(1);

		HikariDataSource dataSource = new HikariDataSource(jdbcConfig);
		return dataSource;

	}

	public static Connection getConnection() {

		if (dataSource == null) {
			dataSource = createDataSource();
		}
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static void closeDataSource() {

		if (dataSource != null) {
			dataSource.close();
		}
	}

}
