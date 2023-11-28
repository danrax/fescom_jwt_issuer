package mx.escom.fescom.config;


import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@ConfigurationProperties
@PropertySource("classpath:application.yml")
public class FescomConfiguration {


    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${openstack.swift.username}") String storageUsername;
    @Value("${openstack.swift.password}") String storagePassword;
    @Value("${openstack.swift.container}") String storageContainer;
    //@Value("${openstack.swift.tenant}") String storageTenantId;
    @Value("${openstack.swift.url}") String storageUrl;
    @Value("${openstack.swift.api_key}") String storageKey;

    /*@Bean
    public DataSource dataSource() {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();
    }*/

    /*
    * @Bean
    public Account storageService(){
        AccountConfig config = new AccountConfig();
        config.setUsername(storageUsername);
        config.setPassword(storageKey);
        config.setAuthUrl(storageUrl);
        config.setAuthenticationMethod(AuthenticationMethod.BASIC);
        return new AccountFactory(config).createAccount();
    }
    * */

}
