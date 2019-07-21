package com.qa.analyzer;

	import java.lang.reflect.Constructor;
	import java.lang.reflect.Method;

	import org.testng.IAnnotationTransformer;
	import org.testng.annotations.ITestAnnotation;

	public class RetryTransformer implements IAnnotationTransformer{

		//override transform method from IAnanotationTransformer interface
		public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
		
		{
			annotation.setRetryAnalyzer(RetryAnalyzer.class);//give class name of analyzer class u written	
		}	
	}
