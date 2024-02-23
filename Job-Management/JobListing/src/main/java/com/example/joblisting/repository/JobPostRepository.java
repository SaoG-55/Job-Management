package com.example.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.joblisting.Model.JobPost;

//MongoRepository will take care of the create read  update delete(CRUD) operations
public interface JobPostRepository extends MongoRepository<JobPost,String>
{

}
