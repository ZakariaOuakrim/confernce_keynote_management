package com.zakaria.confernce;

import com.zakaria.confernce.entities.Conference;
import com.zakaria.confernce.entities.Review;
import com.zakaria.confernce.entities.conferenceType;
import com.zakaria.confernce.feign.KeynoteRestClient;
import com.zakaria.confernce.model.Keynote;
import com.zakaria.confernce.repositories.ConferenceRepository;
import com.zakaria.confernce.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class ConfernceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfernceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ConferenceRepository conferenceRepository,
										ReviewRepository reviewRepository,
										KeynoteRestClient keynoteRestClient) {
		return args -> {
			Collection<Keynote> keynotes = keynoteRestClient.getAllkeynotes().getContent();
			Random random = new Random();

			keynotes.forEach(k -> {
				for (int i = 1; i <= 2; i++) {
					Conference conf = new Conference();
					conf.setTitle("Conference " + i + " by " + k.getFirstName());
					conf.setCONFERENCE_TYPE(i % 2 == 0 ? conferenceType.ACADEMIQUE : conferenceType.COMMERCIALE);
					conf.setDate(new Date());
					conf.setDuration(90);
					conf.setNbrRegistration(random.nextInt(300) + 50);
					conf.setScore(random.nextDouble() * 5);
					conf.setKeyNoteId(k.getId());
					conferenceRepository.save(conf);

					// Add some reviews
					for (int j = 1; j <= 3; j++) {
						Review review = new Review();
						review.setDate(new Date());
						review.setText("Review " + j + " for " + conf.getTitle());
						review.setScore(random.nextInt(5) + 1);
						review.setConference(conf);
						reviewRepository.save(review);
					}
				}
			});

		};
	}
}
