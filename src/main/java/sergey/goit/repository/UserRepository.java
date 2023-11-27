package sergey.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sergey.goit.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.userName = :username")
//    User getUserByUsername(@Param("username") String username);

    @Query("FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(String username);

//    @Query("SELECT role FROM user u where u.username =:username")
//    String role(String username);
}

