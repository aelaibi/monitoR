package ma.neoxia.message.test;

import java.util.ArrayList;
import java.util.List;

import ma.neoxia.message.dao.DomaineRepository;
import ma.neoxia.message.entities.Domaine;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-domain.xml" })
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class DomainesRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private final static Logger log = LoggerFactory.getLogger(DomaineRepository.class);
	
	@Autowired
	DomaineRepository domaine;

	@Test
	@Ignore
	public void testFindALL() {
		List<Domaine> list = new ArrayList<Domaine>();		
		list = domaine.findAll();
		log.debug("list size : " + list.size());
	}


}
