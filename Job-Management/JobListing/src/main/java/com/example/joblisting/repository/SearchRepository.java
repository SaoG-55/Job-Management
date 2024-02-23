package com.example.joblisting.repository;

import java.util.List;

import java.util.List;

import com.example.joblisting.Model.JobPost;

//creating my own method
public interface SearchRepository 
{
	public abstract List<JobPost>findByText(String text);
}
