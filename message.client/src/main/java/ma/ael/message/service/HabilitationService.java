/**
 * 
 */
package ma.ael.message.service;

import java.util.List;

import ma.ael.message.entities.Role;

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
