package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LettersCreateRequestDto {
    // Controller -> Repository Dto
    private Long userIdx;
    private String title;
    private String content;
    private Long recipientIdx;
    private String sender;
    private Long destinationIdx;
    private String presentStatus;
    private String publicSetting;
    private Timestamp createdDate;
    private String status;

    @Builder
    public LettersCreateRequestDto(Long userIdx, String title, String content, Long recipientIdx, String sender,
                                   Long destinationIdx, String presentStatus, String publicSetting, String status){
        this.userIdx = userIdx;
        this.title = title;
        this.content = content;
        this.recipientIdx = recipientIdx;
        this.sender = sender;
        this.destinationIdx = destinationIdx;
        this.presentStatus = presentStatus;
        this.publicSetting = publicSetting;
//        this.createdDate = createdDate;
        this.status = status;
    }

    public Letter toEntity(){
        return Letter.builder()
                .userIdx(userIdx)
                .title(title)
                .content(content)
                .recipientIdx(recipientIdx)
                .sender(sender)
                .destinationIdx(destinationIdx)
                .presentStatus(presentStatus)
                .publicSetting(publicSetting)
                .status(status)
                .build();
    }
}
