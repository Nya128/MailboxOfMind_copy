package mailbox.core.repository;

import mailbox.core.domain.Letter;
import mailbox.core.domain.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {

//    @Query(value = "SELECT recipientIdx FROM Recipient WHERE recipientName = ?", nativeQuery = true)
    Recipient findByRecipientName(String recipientName);

//    @Query(value = "SELECT EXISTS(SELECT * FROM Recipient WHERE recipientName = ?)", nativeQuery = true)
    Boolean existsRecipientByRecipientName(String recipientName);
}
