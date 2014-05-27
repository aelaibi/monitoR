package ma.neoxia.message.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ma.neoxia.message.bean.MessageBean;
import ma.neoxia.message.entities.Message;
import ma.neoxia.message.entities.TypeMessage;
import ma.neoxia.message.service.MessageService;
import ma.neoxia.message.util.DateFormatter;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.mchange.util.AssertException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class MessageServiceImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	MessageService messageService;

	@Test
	public void testSave() {
		MessageBean msgBean = new MessageBean();

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		// msgBean.setIdMessage(Long.valueOf(1));
		msgBean.setType(TypeMessage.ERROR.name());
		msgBean.setMessage("message ....");
		msgBean.setDescription("description ......");
		cal.set(2013, 01, 24, 12, 00);
		date = cal.getTime();
		msgBean.setDateServer(date);
		msgBean.setDateEnvoi(date);
		// msgBean.setIdDomaine(Long.valueOf(1));
		msgBean.setNomDomaine("REST");
		// msgBean.setIdApplication(Long.valueOf(1));
		msgBean.setNomApplication("Followatch");
		messageService.save(msgBean);
		assertNotNull(msgBean);
	}

	@Test
	@Ignore
	public void testFindAll() {
		assertNotNull(messageService.findAll());
	}

@Test
	public void testFindBydate() {
		
		
		List<Message> ret = messageService.findByDateServerBetween(DateFormatter.FirstDate(),
				DateFormatter.LastDate());
		assertNotNull(ret);
		assertEquals(1, ret.size());
	}

//	
//
//	private Date string2Date2(int date , int month,int year ,int heure, int minute) {
//
//		Calendar c = Calendar.getInstance();
//
//		c.set(year, month, date, heure, minute);
//		System.out.println(c.getTime());
//		return c.getTime();
//	}

}
