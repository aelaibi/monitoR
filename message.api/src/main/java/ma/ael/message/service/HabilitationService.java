package ma.ael.message.service;

import java.util.List;

import ma.ael.message.dao.RoleRepository;
import ma.ael.message.entities.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HabilitationService  {
	
	private static Logger logger = LoggerFactory.getLogger( HabilitationService.class );

	@Autowired
	private RoleRepository roleDao;
	
	
	public long count() {
		long count = roleDao.count();
		logger.info( "count roles = " + count );
		return count;
	}

	
	public Role save(Role role) {
		return roleDao.save(role);
	}
	
	
	public List<Role> findAllRoles() {
		return roleDao.findAll();
	}

	

	
	public void delete(Long id) {
		roleDao.delete(id);
	}

	
}