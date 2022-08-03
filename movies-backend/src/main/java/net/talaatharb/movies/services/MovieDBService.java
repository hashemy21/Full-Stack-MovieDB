package net.talaatharb.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.dtos.Movie;
import net.talaatharb.movies.dtos.MoviePage;
import net.talaatharb.movies.repository.MovieRepository;

@Service
@RequiredArgsConstructor
public class MovieDBService {

	@Autowired
	private final RestTemplate restTemplate;
	@Autowired
	private final MovieRepository movieRepository;

	private String apiKey = "a97243d7813d31446f6c43284e6854d5";

	private String apiUrl = "https://api.themoviedb.org/3";

	private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";

	public MoviePage getPopularMovies(Integer page) {
		String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
				+ page.intValue();
		System.out.println(urlForPopularMovies);
		return restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();
	}

	public Movie getMovieDetails(Integer movieId) {
		String urlForMovieDetails = apiUrl + "/movie/" + movieId + "?api_key=" + apiKey;

		if (movieRepository.existsById(movieId)) {
			return movieRepository.findById(movieId).get();
		} else {
			Movie movie = restTemplate.getForEntity(urlForMovieDetails, Movie.class).getBody();
			System.out.println(urlForMovieDetails);

			movieRepository.save(movie);
			return movie;
		}
	}

	public Object searchMovie(String movieName) {

		String urlForMovieSearch = apiUrl + "/search/movie?api_key=" + apiKey + "&query=" + movieName;
		System.out.println(urlForMovieSearch);
		return restTemplate.getForEntity(urlForMovieSearch, Object.class).getBody();

	}
}
