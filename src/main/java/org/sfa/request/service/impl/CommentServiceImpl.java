package org.sfa.request.service.impl;

import lombok.RequiredArgsConstructor;
import org.sfa.request.dto.CommentDTO;
import org.sfa.request.exception.types.NotFoundException;
import org.sfa.request.model.entity.Comment;
import org.sfa.request.model.entity.Request;
import org.sfa.request.model.enums.RequestStatusEnum;
import org.sfa.request.repository.CommentRepository;
import org.sfa.request.repository.RequestRepository;
import org.sfa.request.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    RequestRepository requestRepository;
    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(String requesterId, String requestId, CommentDTO commentDTO, Locale locale)
    {
        System.out.println(requesterId + " " + requestId);
        Request request = requestRepository.findActiveByRequestIdAndRequesterId(requestId,requesterId, RequestStatusEnum.DELETED.getId())
                .orElseThrow(() -> new NotFoundException("Request is not found"));

        Comment comment = new Comment();
        comment.setRequest(request);
        comment.setUserId(commentDTO.getUserId());
        comment.setCommentDesc(commentDTO.getCommentDesc());
        comment.setCommentDate(ZonedDateTime.now());
        Comment addedComment = commentRepository.save(comment);

        System.out.println("Comment added Successfully");
        return  addedComment;
    }

    @Override
    public Comment getComment(Long commentId) {

        return  commentRepository.findByCommentId(commentId).orElseThrow( () -> new NotFoundException("Comment Not found"));
    }
}
