package com.example.joblisting.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.example.joblisting.Model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchRepositoryImplementation implements SearchRepository {

	@Autowired // spring will create the bean for us
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;

	@Override // to carry out customized search based on our req so created SearchRepository
	// and not using JobPostRepo that extends MongoDb Repo
	public List<JobPost> findByText(String text) {
		final List<JobPost> jpostlist = new ArrayList<>();

		MongoDatabase database = mongoClient.getDatabase("sao");
		MongoCollection<Document> collection = database.getCollection("JobPost");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				new Document("$search",
						new Document("text",
								new Document("query", text).append("path",
										Arrays.asList("profile", "desc", "techs")))),
				new Document("$sort", new Document("exp", 1L)), new Document("$limit", 5L)));

		//iterate result one by one //but we need to conert doc to java object
		//result.forEach(docu->jpostlist.add(converter.read(JobPost.class,docu)));
		for (Document doc : result) 
		{
			JobPost post = converter.read(JobPost.class, doc);
		    jpostlist.add(post);
		}
		
		
		return jpostlist;
	}

}
