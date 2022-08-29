package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationIdx;

    @Column(length = 10, nullable = false)
    private String description;

    @Column(length = 500, nullable = false)
    private String destinationImgUrl;

    @Column(length = 500, nullable = false)
    private String destinationAniUrl;

    @Builder
    public Destination (Long destinationIdx, String description, String destinationImgUrl, String destinationAniUrl){
        this.destinationIdx = destinationIdx;
        this.description = description;
        this.destinationImgUrl = destinationImgUrl;
        this.destinationAniUrl = destinationAniUrl;
    }

}
