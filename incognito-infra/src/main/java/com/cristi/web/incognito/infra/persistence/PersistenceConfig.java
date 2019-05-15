package com.cristi.web.incognito.infra.persistence;

import com.github.mongobee.Mongobee;
import com.github.mongobee.exception.MongobeeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.cristi.web.incognito")
public class PersistenceConfig {

    private final MongoTemplate mongoTemplate;

    public PersistenceConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Value("${spring.data.mongodb.uri}")
    private String mongoURI;
    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;

    private final String MIGRATION_PACKAGE = "com.cristi.web.incognito.infra.persistence.changelogs";

    @Bean
    public Mongobee mongobee() throws MongobeeException {
        Mongobee runner = new Mongobee(mongoURI);
        runner.setDbName(mongoDbName);         // host must be set if not set in URI
        runner.setChangeLogsScanPackage(MIGRATION_PACKAGE); // the package to be scanned for changesets
        runner.setMongoTemplate(mongoTemplate);
        return runner;
    }
}
