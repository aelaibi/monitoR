package ma.neoxia.message.test;

import ma.neoxia.message.dao.ApplicationRepository;
import ma.neoxia.message.entities.Application;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-domain.xml" })
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class ApplicationRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private final static Logger log = LoggerFactory.getLogger(ApplicationRepository.class);
	
	@Autowired
	ApplicationRepository application;
	

	@Test
	@Ignore
	public void testFindOne() {
		Application app = new Application();
		app = application.findOne(Long.valueOf(3));
		log.debug("app name " + app.getNomApplication() + " app id " + app.getIdApplication());
	}
	
	@Test
	public void testFindAllApp() {
		Pageable topTen = new PageRequest(2, 10);
		Page<Application> result = application.findAll(topTen);

		log.debug("app size " + result.getSize());
	}
	
}
