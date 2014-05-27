package ma.neoxia.message.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import ma.neoxia.message.dao.RoleRepository;
import ma.neoxia.message.entities.Role;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-domain.xml" })
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class RoleRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	RoleRepository role;
	
	@Test
	@Ignore
	public void testSaveAndCount() {
		Role rl = new Role();
		rl.setRole("admin");
		role.save(rl);
		List<Role> ret = role.getbys("%ad%");
		assertNotNull(ret);
		assertEquals(1, ret.size());
	}


	@Test
	public void testFindAll() {
		assertNotNull(role.findAll());
	}

	

}
