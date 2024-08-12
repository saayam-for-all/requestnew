package org.sfa.request.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sfa.request.model.enums.VolunteerTypeEnum;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "VolunteersAssigned")
@Table(
        name = "volunteers_assigned",
        uniqueConstraints = {
                @UniqueConstraint(name = "volunteers_assigned_id_unique", columnNames = "volunteers_assigned_id")
        }
)
public class VolunteersAssigned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteers_assigned_id")
    private String volunteersAssignedId;


    @ManyToOne
    @JoinColumn(
            name = "request_id",
            nullable = false,
            referencedColumnName = "request_id",
            foreignKey = @ForeignKey(name = "fk_request_id")
    )
    private Request request;

    @ManyToOne
    @JoinColumn(
            name = "volunteer_id",
            nullable = false,
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "fk_volunteer_id")
    )
    private Users user;

    @Enumerated(EnumType.STRING)
    @Column(name = "volunteer_type", nullable = false, columnDefinition = "VARCHAR(255)")
    private VolunteerTypeEnum volunteerType;

    @Column(name = "last_update_date", nullable = false, columnDefinition = "TIMESTAMP")
    private ZonedDateTime lastUpdatedAt;
}
