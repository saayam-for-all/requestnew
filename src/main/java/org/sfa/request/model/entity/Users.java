package org.sfa.request.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Users")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_id_unique", columnNames = "user_id")
        }
)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, columnDefinition = "VARCHAR(255)")
    private String userId;

    @ManyToOne
    @JoinColumn(
            name = "state_id",
            nullable = false,
            referencedColumnName = "state_id",
            foreignKey = @ForeignKey(name = "fk_user_state_id")
    )
    private State state;

    @ManyToOne
    @JoinColumn(
            name = "user_status_id",
            nullable = false,
            referencedColumnName = "user_status_id",
            foreignKey = @ForeignKey(name = "fk_user_status_id")
    )
    private UserStatus userStatus;

    @ManyToOne
    @JoinColumn(
            name = "user_category_id",
            nullable = false,
            referencedColumnName = "user_category_id",
            foreignKey = @ForeignKey(name = "fk_user_category_id")
    )
    private UserCategory userCategory;

    @Column(name = "full_name", columnDefinition = "VARCHAR(255)")
    private String fullName;

    @Column(name = "first_name", columnDefinition = "VARCHAR(255)")
    private String firstName;

    @Column(name = "middle_name", columnDefinition = "VARCHAR(255)")
    private String middleName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(255)")
    private String lastName;

    @Column(name = "primary_email_address", columnDefinition = "VARCHAR(255)")
    private String primaryEmailAddress;

    @Column(name = "secondary_email_1", columnDefinition = "VARCHAR(255)")
    private String secondaryEmail1;

    @Column(name = "secondary_email_2", columnDefinition = "VARCHAR(255)")
    private String secondaryEmail2;

    @Column(name = "primary_phone_number", columnDefinition = "VARCHAR(255)")
    private String primaryPhoneNumber;

    @Column(name = "secondary_phone_1", columnDefinition = "VARCHAR(255)")
    private String secondaryPhone1;

    @Column(name = "secondary_phone_2", columnDefinition = "VARCHAR(255)")
    private String secondaryPhone2;

    @Column(name = "addr_ln1", columnDefinition = "VARCHAR(255)")
    private String addrLn1;

    @Column(name = "addr_ln2", columnDefinition = "VARCHAR(255)")
    private String addrLn2;

    @Column(name = "addr_ln3", columnDefinition = "VARCHAR(255)")
    private String addrLn3;

    @Column(name = "city_name", columnDefinition = "VARCHAR(255)")
    private String cityName;

    @Column(name = "zip_code", columnDefinition = "VARCHAR(255)")
    private String zipCode;

    @Column(name = "last_update_date", columnDefinition = "TIMESTAMP")
    private ZonedDateTime lastUpdatedAt;

    @Column(name = "time_zone", columnDefinition = "VARCHAR(255)")
    private String timeZone;

    @Column(name = "profile_picture_path", columnDefinition = "VARCHAR(255)")
    private String profilePicturePath;

    @Column(name = "passport_doc", columnDefinition = "VARCHAR(255)")
    private String passportDoc;

    @Column(name = "drivers_license", columnDefinition = "VARCHAR(255)")
    private String driversLicense;

}
