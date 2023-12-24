package com.em.test_em.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "task_table")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "header",columnDefinition = "TEXT",nullable = true)
    private String header;
    
    @Column(name = "description",columnDefinition = "LONGTEXT",nullable = true)
    private String description;
    
    @Column(name = "status",columnDefinition = "LONGTEXT",nullable = true)
    private String status;
    
    @Column(name = "priority",length=100,nullable = true)
    private String priority;
    
    @Column(name = "author",length=100,nullable = true)
    private String author;
    
    @ManyToMany
    @JoinTable(
        name = "task_executor",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> executors = new ArrayList<>();

    

    @OneToMany(mappedBy="task", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List <Comments> comments = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User user;
    
    public Task() {
        super();
    }

    public Task(long id, String header, String description, String status, String priority, String author) {
        super();
        this.id = id;
        this.header = header;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        
    }

    
    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<User> getExecutors() {
        return executors;
    }

    public void setExecutors(List<User> executors) {
        this.executors = executors;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", header=" + header + ", description=" + description + ", status=" + status
                + ", priority=" + priority + ", author=" + author + ", executors=" + executors + ", comments="
                + comments + ", user=" + user + "]";
    }

   

   
       
}
