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
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;  // Using Long type to match SERIAL in DB

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id", referencedColumnName = "request_id", foreignKey = @ForeignKey(name = "fk_request_id"))
    private Request request;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "comment_desc", nullable = false)
    private String commentDesc;

    @Column(name = "comment_date", nullable = false)
    private ZonedDateTime commentDate;

}
