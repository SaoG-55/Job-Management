package com.example.joblisting.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.joblisting.Model.JobPost;
import com.example.joblisting.repository.JobPostRepository;
import com.example.joblisting.repository.SearchRepository;

import springfox.documentation.annotations.ApiIgnore;


@RestController
public class PostController 
{
 
	//not created any class or obj of interface "JobPostRepository"
	//only connected with PostController obj it will try to search for this obj
	@Autowired 
	JobPostRepository repo;
	@Autowired 
	SearchRepository srepo;
	
	 @ApiIgnore //dont want predefined requests
	//everytime  someone sends a req for home page it should redirect to swagger page
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException 
	{
		
		response.sendRedirect("/swagger-ui.html");
	}
	 
	
	//fetch all job posts using "spring-boot-starter-data-mongodb" dependancy
	@GetMapping(value="/JobPosts")
	public List<JobPost> getAllPosts()
	{
		return repo.findAll();
		
	}
	
	
	@GetMapping(value="/JobPosts/{text}")
	//to search based on filter //JobPosts/java
	public List<JobPost> search(@PathVariable String text)
	{
		return srepo.findByText(text);
	}
	
	
	//to submit any job
	@PostMapping("/addJob")
	//@RequestBody--helps to extract the body of http req   & convert to java obj
	//used in post and put req --data sent in the body of the req
	// giving waiter a recipe of your desired dish
	public JobPost addJob(@RequestBody JobPost post)
	{
		
		return repo.save(post);
	}
	
}
