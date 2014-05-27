/**
 * 
 */
package ma.neoxia.message.service;

import java.util.List;

import ma.neoxia.message.entities.Role;

/**
 * @author abdelhaq
 *
 */
public interface HabilitationService {

	long count();

	Role save(Role role);

	void delete(Long id);

	List<Role> findAllRoles();

}
