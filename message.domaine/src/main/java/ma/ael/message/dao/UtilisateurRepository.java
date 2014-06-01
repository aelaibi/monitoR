package ma.ael.message.dao;

import ma.ael.message.entities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> { 
	
}
