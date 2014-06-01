package ma.ael.message.service;

import java.util.List;

import junit.framework.Assert;
import ma.ael.message.bean.MessageBean;
import ma.ael.message.dao.ApplicationRepository;
import ma.ael.message.dao.DomaineRepository;
import ma.ael.message.dao.MessageRepository;
import ma.ael.message.entities.Application;
import ma.ael.message.entities.Domaine;
import ma.ael.message.entities.Message;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class MessageServiceIntTest {
	@Autowired
	MessageService messageService;
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	DomaineRepository domaineRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Before
	public void initDB() {
		messageRepository.deleteAll();
		domaineRepository.deleteAll();
		applicationRepository.deleteAll();
	}
	
	@Test
	public void ajoutMessageInitialShouldCreateAll(){
		
		MessageBean mb = initMessageBean("AEL MARKET", "MARKETING", "MESSAGE TEST");
		//when
		messageService.add(mb);
		
		//then
		List<Message> messages = messageService.findAll();
		List<Application> apps = applicationRepository.findAll();
		List<Domaine> doms = domaineRepository.findAll();
		
		Assert.assertNotNull(messages);
		Assert.assertEquals(1, messages.size());
		Assert.assertNotNull(apps);
		Assert.assertEquals(1, apps.size());
		Assert.assertNotNull(doms);
		Assert.assertEquals(1, doms.size());
	}
	
	@Test
	public void ajout3messagesShouldCreateOneAppDomaine(){
		
		MessageBean mb = initMessageBean("AEL MARKET", "MARKETING", "MESSAGE TEST 1");
		MessageBean mb2 = initMessageBean("AEL MARKET", "MARKETING", "MESSAGE TEST 2");
		MessageBean mb3 = initMessageBean("AEL MARKET", "MARKETING", "MESSAGE TEST 3");
		//when
		messageService.add(mb);
		messageService.add(mb2);
		messageService.add(mb3);
		
		//then
		List<Message> messages = messageService.findAll();
		List<Application> apps = applicationRepository.findAll();
		List<Domaine> doms = domaineRepository.findAll();
		
		Assert.assertNotNull(messages);
		Assert.assertEquals(3, messages.size());
		Assert.assertNotNull(apps);
		Assert.assertEquals(1, apps.size());
		Assert.assertNotNull(doms);
		Assert.assertEquals(1, doms.size());
	}
	
	@Test
	public void ajout2messagesShouldCreateOneAppTwoDomaines(){
		
		MessageBean mb = initMessageBean("AEL MARKET", "MARKETING", "MESSAGE TEST 1");
		MessageBean mb2 = initMessageBean("AEL MARKET", "HR", "MESSAGE TEST 2");
		//when
		messageService.add(mb);
		messageService.add(mb2);
		
		//then
		List<Message> messages = messageService.findAll();
		List<Application> apps = applicationRepository.findAll();
		List<Domaine> doms = domaineRepository.findAll();
		
		Assert.assertNotNull(messages);
		Assert.assertEquals(2, messages.size());
		Assert.assertNotNull(apps);
		Assert.assertEquals(1, apps.size());
		Assert.assertNotNull(doms);
		Assert.assertEquals(2, doms.size());
	}
	
	@Test
	public void ajout2messagesShouldCreateTwoAppsTwoDomaines(){
		
		MessageBean mb = initMessageBean("AEL MARKET", "MARKETING", "MESSAGE TEST 1");
		MessageBean mb2 = initMessageBean("AEL HR", "HR", "MESSAGE TEST 2");
		//when
		messageService.add(mb);
		messageService.add(mb2);
		
		//then
		List<Message> messages = messageService.findAll();
		List<Application> apps = applicationRepository.findAll();
		List<Domaine> doms = domaineRepository.findAll();
		
		Assert.assertNotNull(messages);
		Assert.assertEquals(2, messages.size());
		Assert.assertNotNull(apps);
		Assert.assertEquals(2, apps.size());
		Assert.assertNotNull(doms);
		Assert.assertEquals(2, doms.size());
	}

	private MessageBean initMessageBean(String nomApp, String nomDom, String messageText) {
		MessageBean mb = new MessageBean();
		mb.setDescription("message de test ael");
		mb.setType("INFO");
		mb.setMessage(messageText);
		mb.setNomApplication(nomApp);
		mb.setNomDomaine(nomDom);
		return mb;
	}

}
