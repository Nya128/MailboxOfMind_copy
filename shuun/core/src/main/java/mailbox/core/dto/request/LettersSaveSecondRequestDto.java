package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letter;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class LettersSaveSecondRequestDto {
    // 클라이언트 -> Controller Dto
    private String title;
    private String content;
    private Long destinationIdx;
    private String presentStatus;
    private String publicSetting;
    private Timestamp createdDate;

    @Builder
    public LettersSaveSecondRequestDto(String title, String content, Long destinationIdx, String presentStatus, String publicSetting, Timestamp createdDate){
        this.title = title;
        this.content = content;
        this.destinationIdx = destinationIdx;
        this.presentStatus = presentStatus;
        this.publicSetting = publicSetting;
        this.createdDate = createdDate;
    }

}
