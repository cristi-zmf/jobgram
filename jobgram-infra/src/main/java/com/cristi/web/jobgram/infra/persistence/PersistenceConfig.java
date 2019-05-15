package com.cristi.web.jobgram.infra.persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.cristi.web.jobgram")
public class PersistenceConfig {
}
