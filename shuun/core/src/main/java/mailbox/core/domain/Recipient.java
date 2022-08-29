package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Entity
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipientIdx;

    @Column(length = 45, nullable = false)
    private String recipientName;

    @Column(length = 45, nullable = false)
    private Long userIdx;

//    @ManyToOne
//    @JoinColumn(name="userIdx", referencedColumnName = "userIdx")
//    private User user;




    @Builder
    public Recipient(Long recipientIdx, String recipientName, Long userIdx){
        this.recipientIdx = recipientIdx;
        this.recipientName = recipientName;
        this.userIdx = userIdx;
    }

//    public void update(Long recipientIdx, String recipientName, Long userIdx){
//
//    }
}
