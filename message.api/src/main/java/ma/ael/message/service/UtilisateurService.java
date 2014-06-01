package ma.ael.message.service;

import ma.ael.message.dao.UtilisateurRepository;
import ma.ael.message.entities.Utilisateur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurService {
	
	private static Logger logger = LoggerFactory.getLogger( UtilisateurService.class );

	@Autowired
	private UtilisateurRepository utilisateurDao;
	
	
	public long count() {
		long count = utilisateurDao.count();
		logger.info( "count = " + count );
		return count;
	}

	
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

	

	
	public void delete(Utilisateur utilisateur) {
		utilisateurDao.delete(utilisateur);
	}

	
}