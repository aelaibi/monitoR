package ma.ael.message.test;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import ma.ael.message.bean.MessageBean;
import ma.ael.message.entities.TypeMessage;
import ma.ael.message.service.MessageService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
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


}
