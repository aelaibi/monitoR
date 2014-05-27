package ma.neoxia.message.service;

import ma.neoxia.message.entities.Utilisateur;


public interface UtilisateurService {

	long count();
	
	Utilisateur save( Utilisateur utilisateur );
	
	void delete( Utilisateur utilisateur );
	
}
