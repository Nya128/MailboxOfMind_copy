package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letter;
import mailbox.core.domain.Recipient;

@Getter
@NoArgsConstructor
public class RecipientSaveRequestDto {
    // Controller -> Repository 전달되는 Dto
    private String recipientName;
    private Long userIdx;

    @Builder
    public RecipientSaveRequestDto(String recipientName, Long userIdx){
        this.recipientName = recipientName;
        this.userIdx = userIdx;
    }

    public Recipient toEntity(){
        return Recipient.builder()
                .recipientName(recipientName)
                .userIdx(userIdx)
                .build();
    }

}
