package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letter;

@Getter
@NoArgsConstructor
public class LettersSaveFirstRequestDto {
    // 클라이언트에게서 받는 Dto
    private String sender;
    private String recipientName;

    @Builder
    public LettersSaveFirstRequestDto(String sender, String recipientName){
        this.sender = sender;
        this.recipientName = recipientName;
    }



}
