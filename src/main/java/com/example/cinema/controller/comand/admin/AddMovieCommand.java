package com.example.cinema.controller.comand.admin;

import com.example.cinema.controller.comand.ActionCommand;
import com.example.cinema.model.entity.Movie;
import com.example.cinema.model.service.MovieSeanceService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;

/**
 * The command that is responsible for adding new movies
 *
 */
public class AddMovieCommand implements ActionCommand {

    private static Logger log = Logger.getLogger(AddMovieCommand.class);
    private static final String PARAM_NAME_TITLE = "title";
    private static final String PARAM_NAME_DIRECTOR = "director";
    private static final String PARAM_NAME_YEAR = "year";
    private static final String PARAM_NAME_GENRE = "genres";
    private static final String PARAM_NAME_AGE = "age";
    private static final String PARAM_NAME_DURATION = "duration";
    private static final String PARAM_NAME_IMAGE = "image";

    @Override
    public String execute(HttpServletRequest req) {
        String page = null;
        String title = req.getParameter(PARAM_NAME_TITLE);
        String director = req.getParameter(PARAM_NAME_DIRECTOR);
        int year = Integer.parseInt(req.getParameter(PARAM_NAME_YEAR));
        int genreId = Integer.parseInt(req.getParameter(PARAM_NAME_GENRE));
        int age = Integer.parseInt(req.getParameter(PARAM_NAME_AGE));
        int duration = Integer.parseInt(req.getParameter(PARAM_NAME_DURATION));
        String imageUrl = req.getParameter(PARAM_NAME_IMAGE);

        MovieSeanceService service = MovieSeanceService.getInstance();
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setProductionYear(year);
        movie.setGenre(String.valueOf(genreId));
        movie.setDuration(Duration.ofMinutes(duration));
        movie.setAgeRestriction(age);
        movie.setImagePath(imageUrl);
        if (service.addMovie(movie)) {
            page = "/controller?command=getmovies";
        }
        else page = (String)req.getAttribute("queryString");

        return page;
    }
}
