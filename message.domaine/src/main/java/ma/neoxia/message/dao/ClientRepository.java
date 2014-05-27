//package ma.neoxia.message.dao;
//
//import java.util.List;
//
//import ma.neoxia.message.entities.Client;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//public interface ClientRepository
//    extends JpaRepository<Client, Long>
//{
//    
//    List<Client> findByNomLike(String nom);
//    
//    //Page<Customer> findByNomLikeOrderByNomAsc(String nom, Pageable pageable);
//
//}