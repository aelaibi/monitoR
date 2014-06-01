package ma.ael.message.service.impl;

import ma.ael.message.dao.UtilisateurRepository;
import ma.ael.message.entities.Utilisateur;
import ma.ael.message.service.UtilisateurService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private static Logger logger = LoggerFactory.getLogger( UtilisateurServiceImpl.class );

	@Autowired
	private UtilisateurRepository utilisateurDao;
	
	@Override
	public long count() {
		long count = utilisateurDao.count();
		logger.info( "count = " + count );
		return count;
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

	

	@Override
	public void delete(Utilisateur utilisateur) {
		utilisateurDao.delete(utilisateur);
	}

	
}