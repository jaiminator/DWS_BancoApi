
package com.fpmislata.bancoapi.presentacion.database.impl;

import com.fpmislata.banco.persistence.jdbc.DataSourceFactory;
import com.fpmislata.bancoapi.presentacion.database.DatabaseMigration;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;


public class DatabaseMigrationImplFlyWay implements DatabaseMigration {
    
    @Autowired
    DataSourceFactory dataSourceFactory;

    @Override
    public void migrate() {
        Flyway flyway = new Flyway();
        DataSource dataSource = dataSourceFactory.getDataSource();
        flyway.setDataSource(dataSource);
        flyway.setLocations("com.fpmislata.banco.persistence.database");
        flyway.setEncoding("UTF-8");
        flyway.migrate();
    }
    
}
