package pe.edu.i202223255.cl1_jpa_data_mallma_isaac;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConexionesConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/world");
        config.setUsername("root");
        config.setPassword("71861615");


        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(4 * 60 * 1000);
        config.setConnectionTimeout(45 * 1000);

        return new HikariDataSource(config);
    }
}
