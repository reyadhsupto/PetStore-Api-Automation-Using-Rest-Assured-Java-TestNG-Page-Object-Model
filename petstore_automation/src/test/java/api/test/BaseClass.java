package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import reports.ExtentManager;

import com.github.javafaker.Faker;

import api.payload.User;
import io.restassured.response.Response;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BaseClass {
	public Faker faker;
	public User payload;
	public Response response;
	public static final Logger logger = LoggerFactory.getLogger(UserTests.class);
	public ExecutorService service;
	
	public void logResponse(Response response) {
		logger.info("logging response body");
		response.then().log().all();
	}
	
	@BeforeSuite
	  public void beforeSuite() throws IOException {
	    ExtentManager.setExtent();
	    service = Executors.newFixedThreadPool(5);
	  }

	  @AfterSuite
	  public void afterSuite() {
		  if (service != null && !service.isShutdown()) {
	            service.shutdown();
	        }
		  else {
			  System.out.println("Service is null");
		  }
	    ExtentManager.endReport();
	  }

}
