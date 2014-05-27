package ma.neoxia.message.service.impl;

import java.util.List;

import ma.neoxia.message.dao.RoleRepository;
import ma.neoxia.message.entities.Role;
import ma.neoxia.message.service.HabilitationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HabilitationServiceImpl implements HabilitationService {
	
	private static Logger logger = LoggerFactory.getLogger( HabilitationServiceImpl.class );

	@Autowired
	private RoleRepository roleDao;
	
	@Override
	public long count() {
		long count = roleDao.count();
		logger.info( "count roles = " + count );
		return count;
	}

	@Override
	public Role save(Role role) {
		return roleDao.save(role);
	}
	
	@Override
	public List<Role> findAllRoles() {
		return roleDao.findAll();
	}

	

	@Override
	public void delete(Long id) {
		roleDao.delete(id);
	}

	
}