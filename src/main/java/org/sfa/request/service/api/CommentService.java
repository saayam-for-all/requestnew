package org.sfa.request.service.api;

import org.sfa.request.dto.CommentDTO;
import org.sfa.request.model.entity.Comment;

import java.util.Locale;

public interface CommentService {
    Comment createComment(String requesterId, String requestId, CommentDTO commentDTO, Locale locale);
    Comment getComment(Long commentId);
}
