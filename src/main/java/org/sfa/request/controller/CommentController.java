package org.sfa.request.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.sfa.request.dto.CommentDTO;
import org.sfa.request.model.entity.Comment;
import org.sfa.request.service.api.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1.0.0/requests/{requesterId}/{requestId}/comments")
@RequiredArgsConstructor
@Tag(name = "Comment", description = "Comment management APIs")
public class CommentController {


    private  final CommentService commentService;
    private final LocaleResolver localeResolver;

    @PostMapping
    public ResponseEntity<Comment> createComment(@PathVariable  String requesterId, @PathVariable String requestId, @RequestBody CommentDTO commentDTO, HttpServletRequest request)
    {
        //System.out.println("Reached");
        Locale locale = localeResolver.resolveLocale(request);
        Comment comment = commentService.createComment(requesterId, requestId, commentDTO, locale);

        if(comment == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    @GetMapping("/{commentId}")
    public  ResponseEntity<Comment> getComment(@PathVariable  String requesterId, @PathVariable String requestId, @PathVariable Long commentId, HttpServletRequest request)
    {
        Locale locale = localeResolver.resolveLocale( request);
        Comment comment = commentService.getComment(commentId);

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
