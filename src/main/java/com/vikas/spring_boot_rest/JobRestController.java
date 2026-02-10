package com.vikas.spring_boot_rest;

import com.vikas.spring_boot_rest.model.JobPost;
import com.vikas.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController
{
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getjob(@PathVariable("postId") int postId){

        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchJob(@PathVariable ("keyword") String keyword){
        return service.search(keyword);
    }
    @GetMapping("load")
    public String loadData(){
         service.load();
        return "success";
    }
}
