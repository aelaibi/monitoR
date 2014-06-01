package ma.ael.message.service;

import ma.ael.message.entities.Utilisateur;


public interface UtilisateurService {

	long count();
	
	Utilisateur save( Utilisateur utilisateur );
	
	void delete( Utilisateur utilisateur );
	
}
