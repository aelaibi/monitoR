package ma.neoxia.message.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ma.neoxia.message.dao.MessageRepository;
import ma.neoxia.message.entities.Message;
import ma.neoxia.message.entities.TypeMessage;

import org.aspectj.internal.lang.reflect.StringToType;
import org.hibernate.metamodel.relational.Database;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ch.qos.logback.classic.pattern.DateConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-domain.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class MessageRepositoryTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	private final static Logger log = LoggerFactory.getLogger(MessageRepository.class);

	@Autowired
	MessageRepository msgDao;

	@Test
	@Ignore
	public void testSave() {
		Message msg = new Message();
		msg.setType(TypeMessage.ERROR.name());
		msgDao.save(msg);

		log.debug("SF: message enregistré !! ");
	}

	@Test
	@Ignore
	public void testUpdate() {
		Message msg = new Message();
		msg = msgDao.findOne(Long.valueOf(1));
		log.debug("SF: result operation  " + msg.getType());
		msgDao.setNewTypeForMessage(TypeMessage.ERROR.name(), Long.valueOf(1));
		
		msg = msgDao.findOne(Long.valueOf(1));
		log.debug("SF: result operation  " + msg.getType());
	}
	
	@Test
	public void testFindOne() {
		Message msg = new Message();
		msg = msgDao.findOne(Long.valueOf(1));
		
		log.debug("SF: result operation  " + msg.getIdMessage() + "--" + msg.getType());
	}
	
	
	
	@Test
	public void testFindDistinctType() {
		
		List<String> ret = msgDao.findDistinctType();
		
		Assert.assertNotNull(ret);
		log.debug("findDistinctType return  " + ret.size());
	
		
		Assert.assertEquals("en local nous avons 4 types", 4, ret.size());
	}
	
	
	@Test
	public void testFindEntre2Dates() {
        	
		List<Message> ret;
		
			ret = msgDao.findByDateServerBetween(null,null);
			Assert.assertNotNull(ret);
			log.debug("FindEntre2Dates return  " + ret.size());
		
			
			Assert.assertEquals("en local nous avons 4 types", 4, ret.size());
		
		
		
	}
	
	
	

}
