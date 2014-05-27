package ma.neoxia.message.dao;

import ma.neoxia.message.entities.Profil;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilRepository extends JpaRepository<Profil, Long> { 
	
}
