package mailbox.core.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letter;
import mailbox.core.domain.Recipient;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class LettersListResponseDto {
    private Long userIdx;
    private Long letterIdx;
    private String title;
    private String content;
    private Long recipientIdx;
    private String sender;
    private Long destinationIdx;
    private String presentStatus;
    private String publicSetting;
    private Timestamp createdDate;
    private String status;


    public LettersListResponseDto(Letter letterEntity){
        this.userIdx = letterEntity.getUserIdx();
        this.letterIdx = letterEntity.getLetterIdx();
        this.title = letterEntity.getTitle();
        this.content = letterEntity.getContent();
        this.recipientIdx = letterEntity.getRecipientIdx();
        this.sender = letterEntity.getSender();
        this.destinationIdx = letterEntity.getDestinationIdx();
        this.presentStatus = letterEntity.getPresentStatus();
        this.publicSetting = letterEntity.getPublicSetting();
        this.createdDate = Timestamp.valueOf(letterEntity.getCreateDate());
        this.status = letterEntity.getStatus();
    }
}
