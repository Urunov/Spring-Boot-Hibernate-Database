package spring.budget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.budget.exception.ResourceNotFoundException;
import spring.budget.model.Post;
import spring.budget.repository.PostRepository;

import javax.validation.Valid;
import java.awt.print.Pageable;

/**
 * @Created 10 / 06 / 2020 - 10:29 AM
 * @project FamilyBudgetOne2Many
 * @Author Hamdamboy
 */
@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public Page<Post> getAllPosts(Pageable pageable){
        return postRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/posts/{postId}")
    public Post update (@PathVariable Long postId, @Valid @RequestBody Post postRequest){

        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(()-> new ResourceNotFoundException("PostId" + postId + "not found"));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId" + postId + "not found"));
    }
}
