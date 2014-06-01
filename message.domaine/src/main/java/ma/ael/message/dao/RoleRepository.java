package ma.ael.message.dao;

import java.util.List;

import ma.ael.message.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> { 
	@Query("select r from Role r where r.role like :roleP")
	List<Role> getbys(@Param("roleP")String role);
	
}
