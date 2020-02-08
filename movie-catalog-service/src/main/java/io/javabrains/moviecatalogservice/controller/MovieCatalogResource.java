package io.javabrains.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		List<CatalogItem> catalogList=new ArrayList<CatalogItem>();
		UserRatings ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+ userId, UserRatings.class);
		for(Rating rating:ratings.getUserRatings()){
			// For each movie ID, call movie info service and get details
			Movie movie =restTemplate.getForObject("http://localhost:8082/movies/" +rating.getMovieId(), Movie.class);
			// Pull all data together
			CatalogItem catalog= new CatalogItem(movie.getName(),"Battel", rating.getRating());
			catalogList.add(catalog);
		}
		return catalogList;
		 /* return ratings.stream().map(rating -> 
		  Movie movie =restTemplate.getForObject("http://localhost:8082/movies/" +rating.getMovieId(), Movie.class); 
		  return new CatalogItem("Lord Of The Ring","Battel", 5)).collect(Collectors.toList());*/
		 
		/*
		 * return Collections.singletonList( new CatalogItem("Lord Of The Ring",
		 * "Battel", 5));
		 */
		
	}
		
		
}
