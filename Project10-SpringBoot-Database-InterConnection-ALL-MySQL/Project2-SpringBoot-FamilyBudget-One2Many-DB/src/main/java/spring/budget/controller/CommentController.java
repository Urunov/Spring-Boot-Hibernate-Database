package spring.budget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.budget.exception.ResourceNotFoundException;
import spring.budget.model.Comment;
import spring.budget.repository.CommentRepository;
import spring.budget.repository.PostRepository;

import javax.validation.Valid;
import java.awt.print.Pageable;

/**
 * @Created 10 / 06 / 2020 - 10:29 AM
 * @project FamilyBudgetOne2Many
 * @Author Hamdamboy
 */

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, (org.springframework.data.domain.Pageable) pageable);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable (value = "postId") Long postId, @Valid @RequestBody Comment comment) {

        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId" +postId + "not found"));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") Long postId, @PathVariable(value = "commentId") Long commentId) {

        return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Comment not found with id" + commentId + "and postId" + postId));
    }
}
