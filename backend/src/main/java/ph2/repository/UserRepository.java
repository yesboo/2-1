package ph2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import ph2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
        value = "SELECT * FROM users WHERE acname = :acname",
        nativeQuery = true
    )   
    Optional<User> findByAcname(@Param("acname") String acname);
}
