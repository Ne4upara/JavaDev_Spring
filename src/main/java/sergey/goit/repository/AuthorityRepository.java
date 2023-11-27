package sergey.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sergey.goit.model.Authority;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @Query("FROM Authority a WHERE a.authority = 'ROLE_USER'")
    List<Authority> findByAuthority();
}