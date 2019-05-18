package com.cristi.web.jobgram.infra;

import com.cristi.web.jobgram.application.ApplicationConfig;
import com.cristi.web.jobgram.infra.persistence.PersistenceConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = PersistenceConfig.class)
@Transactional
public abstract class InfraLocalIT {

}
