package hui.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

public class MybatisConfig {
    /**
     *  1. setTypeAliasesPackage("hui.domain");      -->  javaBean数据库封装类存放位置
     *  2. setDataSource(dataSource);                -->  设置数据连接池(这里使用Druid的DataSource)
     *
     * @param dataSource 已经加载配置的dataSource, 使用Druid的DataSource
     * @return mybatis的SqlSessionFactoryBean对象
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setTypeAliasesPackage("hui.domain");
        factoryBean.setDataSource(dataSource);

        return factoryBean;
    }

    /**
     *  msc.setBasePackage("hui.dao");                   -->  设置Mapper接口存放位置
     *
     * @return mybatis的MapperScannerConfigurer对象
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("hui.dao");

        return msc;
    }
}
