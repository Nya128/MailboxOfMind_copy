package mailbox.core.repository;

import mailbox.core.domain.user.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

}
