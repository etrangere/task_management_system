package com.em.test_em.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.em.test_em.beans.Comments;
import com.em.test_em.services.CommentsService;


@CrossOrigin()
@RestController
@RequestMapping("/comment")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;
    
    @GetMapping(value = "/getAllComments")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Comments> findAll(){
        return this.commentsService.getAllComments();
    }
    //get task with id
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Comments> findById(@PathVariable Long id){
        return this.commentsService.getCommentsById(id);
    }
    
    //create task    
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Comments create(@RequestBody Comments comments) {
        return this.commentsService.create(comments);
    }
    
    //update task    
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Comments update(@RequestBody Comments comments, @PathVariable("id") Long id) {
        if (!id.equals(comments.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Wrong session to update");
        }
        return this.commentsService.update(comments);
    }
    
    //delete task
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.commentsService.delete(id);
    }
}