package org.sfa.request.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "state",
        uniqueConstraints = {
                @UniqueConstraint(name = "state_id_unique", columnNames = "state_id")
        }
)
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Integer stateId;

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            nullable = false,
            referencedColumnName = "country_id",
            foreignKey = @ForeignKey(name = "fk_country_id")
    )
    private Country country;

    @Column(name = "state_name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String stateName;

    @Column(name = "last_update_date", columnDefinition = "TIMESTAMP")
    private ZonedDateTime lastUpdatedAt;
}
