package mailbox.core.repository;

import mailbox.core.domain.Letter;
import mailbox.core.dto.response.LettersListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LettersRepository extends JpaRepository<Letter, Long> {

    @Query("SELECT p FROM Letter p order by p.letterIdx desc ")
    List<Letter> findAllDesc();

//    List<LettersListResponseDto> findLettersWithRecipient();


}
