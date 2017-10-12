package ml.melkie;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@MapperScan(basePackages = "ml.melkie.model")
@ComponentScan(basePackages = "ml.melkie.model")
public class WebContextConfig {

//    heroku clear db datasource. used in deployment
//    @Bean
//    public BasicDataSource getDataSource() throws URISyntaxException {
//
//        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
//
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setUrl(dbUrl);
//        basicDataSource.setUsername(username);
//        basicDataSource.setPassword(password);
//
//        return basicDataSource;
//    }

//    localhost mysql datasoure, used in localhost testing
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
//        database connection settings
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Melkie");
        dataSource.setUsername("root");
        dataSource.setPassword("richard0625");
        return dataSource;
    }

    //transaction management
    @Bean
    public DataSourceTransactionManager transactionManager() throws URISyntaxException {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(getDataSource());
        return sqlSessionFactory.getObject();
    }
}