package ma.ael.message.dao;

import ma.ael.message.entities.Profil;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilRepository extends JpaRepository<Profil, Long> { 
	
}
