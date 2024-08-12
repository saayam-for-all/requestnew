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
        name = "country",
        uniqueConstraints = {
                @UniqueConstraint(name = "country_id_unique", columnNames = "country_id")
        }
)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country_name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String countryName;

    @Column(name = "phone_country_code", nullable = false)
    private Integer phoneCountryCode;

    @Column(name = "last_update_date", columnDefinition = "TIMESTAMP")
    private ZonedDateTime lastUpdatedAt;
}
