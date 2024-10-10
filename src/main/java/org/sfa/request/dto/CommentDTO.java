package org.sfa.request.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sfa.request.model.entity.Request;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    //@NotNull(message = "Requester cannot be null")
    private String requestId;

   // @NotNull(message = "User ID cannot be blank")
    //@Size(max = 255, message = "User ID must not exceed 255 characters")
    private String userId;

    //@NotNull(message = "Comment Description can't be blank!")
    private String commentDesc;

    private ZonedDateTime commentDate;
}
