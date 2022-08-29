package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mailbox.core.domain.user.Users;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Entity
public class Letter extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterIdx;

    @Column(length = 45, nullable = false)
    private Long userIdx;

    @Column(length = 45, nullable = false)
    private Long recipientIdx;

    @OneToMany(mappedBy = "letter")
    private List<Present> presents = new ArrayList<>();

    @OneToMany(mappedBy = "letter")
    private List<LetterEmoji> letterEmojis = new ArrayList<>();

    @OneToMany(mappedBy = "letter")
    private List<LetterTag> letterTags = new ArrayList<>();

    @OneToMany(mappedBy = "letter")
    private List<Message> messages = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name="userIdx")
//    private Users user;

    @Column(length = 45, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 45, nullable = false)
    private String sender;

    @Column(length = 45, nullable = false)
    private Long destinationIdx;

    @Column(length = 10, nullable = false)
    private String presentStatus;

    @Column(length = 10, nullable = false)
    private String publicSetting;

    @Column(length = 10, nullable = false)
    private String status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;


    @Builder
    public Letter(Long userIdx, String title, String content, Long recipientIdx, String sender,
                  Long destinationIdx, String presentStatus, String publicSetting, String status){
        this.userIdx = userIdx;
        this.title = title;
        this.content = content;
        this.recipientIdx = recipientIdx;
        this.sender = sender;
        this.destinationIdx = destinationIdx;
        this.presentStatus = presentStatus;
        this.publicSetting = publicSetting;
        this.status = status;
    }

    public void update(){
    }

}
