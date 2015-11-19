package com.mat.controller;

import java.util.concurrent.locks.Lock;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ParseExclusion implements ExclusionStrategy {

	public boolean shouldSkipClass(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {
		// TODO Auto-generated method stub
		 return (f.getDeclaredClass() == Lock.class);
	}

}
