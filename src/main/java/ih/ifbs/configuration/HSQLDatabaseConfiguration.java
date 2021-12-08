//package ih.ifbs.configuration;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import javax.sql.DataSource;
//
//@Configuration
//@Profile("dev")
//public class HSQLDatabaseConfiguration extends HikariConfig {
//    private static final Logger log = LoggerFactory.getLogger(HSQLDatabaseConfiguration.class);
//
//    @Bean
//    public DataSource dataSource() {
//        log.debug("Using HSQL as data source...");
//        HikariDataSource ds = (HikariDataSource) DataSourceBuilder.create()
//                .driverClassName("org.hsqldb.jdbcDriver")
//                .url("jdbc:hsqldb:file:aviatoDB;hsqldb.lock_file=false")
//                .username("isot")
//                .password("")
//                .build();
//        return ds;
//    }
//}
