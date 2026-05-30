package cite.project.demo.model;


import cite.project.demo.enums.StatusEnum;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.OffsetDateTime;

@Entity
@Table(name = "client_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT")
    private String fullName;

    @Column(length = 1)
    private String gender;




    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @ColumnDefault(value ="'ACTIVE'")
    private StatusEnum status = StatusEnum.ACTIVE;

    @CreationTimestamp
    @Column(name = "create_dttm", nullable = false, updatable = false)
    private OffsetDateTime createDttm;


    @UpdateTimestamp
    @Column(name = "modify_dttm",nullable = false)
    private  OffsetDateTime modifyDttm;
}
