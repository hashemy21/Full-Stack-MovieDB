package net.talaatharb.movies.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.facades.MovieFacade;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/movies")
public class MoviesController {
	
	private final MovieFacade movieFacade;
	
	@GetMapping(path = "/popular")
	public ResponseEntity<Object> getPopularMovies(@RequestParam Integer page){
		
		return new ResponseEntity<>(movieFacade.getPopularMovies(page), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{movie_id}")
	public ResponseEntity<Object> getMovieDetails(@PathVariable ("movie_id") Integer movieId){
		
		return new ResponseEntity<>(movieFacade.getMovieDetails(movieId), HttpStatus.OK);
	}
	
	@GetMapping(path = "/search")
	public ResponseEntity<Object> searchMovie(@RequestParam String movieName){
		return new ResponseEntity<>(movieFacade.searchMovie(movieName), HttpStatus.OK);
	}

}
