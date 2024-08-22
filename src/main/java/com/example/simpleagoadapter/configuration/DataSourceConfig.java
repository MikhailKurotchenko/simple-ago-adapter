package com.example.simpleagoadapter.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:my-property.yaml", factory = YamlPropertySourceFactory.class)
public class DataSourceConfig {
    @Bean
    public DataSourceProperties interimDataSourceProperties(){
        return new DataSourceProperties();
    }

    //Это не нужно, SpringBoot автоматически создают данную проперти их конфига
//    @Bean
//    public JpaProperties interimJpaProperties(){
//        return new JpaProperties();
//    }


    @Bean
    public DataSource interimDataSource(DataSourceProperties interimDataSourceProperties){
        return interimDataSourceProperties.initializeDataSourceBuilder()
                .build();
    }


}
