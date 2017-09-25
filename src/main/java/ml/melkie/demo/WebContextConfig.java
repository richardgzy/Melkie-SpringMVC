package ml.melkie.demo;

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

/**
 * 类似于spring-context.xml或者beans.xml
 * MapperScan用于扫描Mapper映射接口，比如本例中的 UserDao
 * MapperScan、ComponentScan具体的使用方法 跟之前的ComponentScan 完全相同 此处便不再赘述
 * Created by SXY on 2016/1/26.
 */
@Configuration
@MapperScan(basePackages = "ml.melkie.demo")
@ComponentScan(basePackages = "ml.melkie.demo")
public class WebContextConfig {

    @Bean
    public BasicDataSource getDataSource() throws URISyntaxException {

        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    //    事务管理
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