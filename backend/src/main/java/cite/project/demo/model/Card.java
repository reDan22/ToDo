package cite.project.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Table(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="user_id")
    private Long userId;

    @CreationTimestamp
    @Column(name = "create_dttm", nullable = false, updatable = false)
    private OffsetDateTime createDttm;

    @UpdateTimestamp
    @Column(name = "modify_dttm", nullable = false)
    private OffsetDateTime modifyDttm;

    @Column(name = "next_card_id")
    private Long nextCardId;

}
