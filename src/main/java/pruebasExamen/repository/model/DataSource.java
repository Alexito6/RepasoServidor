package pruebasExamen.repository.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSource {
    @Bean
    public static MysqlDataSource getMyDataSource(){
        MysqlDataSource mysql=new MysqlDataSource();
        mysql.setURL("jdbc:mysql://localhost:3307/pruebas1");
        mysql.setUser("root");
        mysql.setPassword("1234");
        return mysql;
    }
}
