package net.talaatharb.movies.dtos;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class Movie {
	    @Id
	    private int id;
	    private boolean adult;
	    private String backdrop_path;
	    private String original_language;
	    private String original_title;
	    private String overview;
	    private String popularity;
	    private String poster_path;
	    private String release_date;
	    private String title;
	    private boolean video;
	    private float vote_average;
	    private int vote_count;
}
