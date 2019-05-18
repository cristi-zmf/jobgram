package com.cristi.web.jobgram.infra.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories("com.cristi.web.jobgram")
@EntityScan(
        basePackages = {"com.cristi.web.jobgram", "org.springframework.data.jpa.convert.threeten"}
)
@ComponentScan(
        basePackages = {"com.cristi.web.jobgram"}
)
public class PersistenceConfig {
//    @Bean
//    public LocalEntityManagerFactoryBean  entityManagerFactory() {
//        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//        factoryBean.setPersistenceUnitName("jpa");
//        return factoryBean;
//    }
}
