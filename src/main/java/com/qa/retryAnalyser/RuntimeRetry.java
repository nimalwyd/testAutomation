package com.qa.retryAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

//this class ensure that retry is done for failed TCs in runtime, 
//that too without the need to specify retry at the test signature
//make sure that this class is added as a listner in testng.xml
public class RuntimeRetry implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	
	

}
