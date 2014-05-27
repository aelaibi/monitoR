package ma.neoxia.message.dao;

import ma.neoxia.message.entities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> { 
	
}
