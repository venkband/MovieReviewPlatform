package com.bandaru.ven.MovieReviewPlatform;

import com.bandaru.ven.MovieReviewPlatform.entities.Review;
import com.bandaru.ven.MovieReviewPlatform.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieReviewPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewPlatformApplication.class, args);


		//we are posting requests to the same web server we are hosting
		RestTemplate restTemplate = new RestTemplate();

		//ResponseEntity response = restTemplate.postForEntity("http://localhost:1234/addUser" , new User("zzz") , null );
		ResponseEntity response = restTemplate.postForEntity("http://localhost:1234/addReview" , new Review("ven" ,"MI4",9),null);
		ResponseEntity response1 = restTemplate.postForEntity("http://localhost:1234/addReview" , new Review("ven" ,"F2",7),null);
		ResponseEntity response2 = restTemplate.postForEntity("http://localhost:1234/addReview" , new Review("ven" ,"jersey",8),null);
		ResponseEntity response3 = restTemplate.postForEntity("http://localhost:1234/addReview" , new Review("ven" ,"don",5),null);
	}

}
