package com.anjelikabog.db.connection_to_db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class HikariCPConnectionToDB {

        private static DataSource datasource;

        public static DataSource getDataSource(){
            if(datasource == null)
            {
                HikariConfig config = new HikariConfig();

                config.setJdbcUrl("jdbc:postgresql://localhost/persons_db");
                config.setUsername("postgres");
                config.setPassword("postgres");

                config.setMaximumPoolSize(10);
                config.addDataSourceProperty("cachePrepStmts", "true");
                config.addDataSourceProperty("prepStmtCacheSize", "250");
                config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

                datasource = new HikariDataSource(config);
            }
            return datasource;
        }
}
