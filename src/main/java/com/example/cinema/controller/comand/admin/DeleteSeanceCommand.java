package com.example.cinema.controller.comand.admin;

import com.example.cinema.controller.comand.ActionCommand;
import com.example.cinema.model.service.MovieSeanceService;

import javax.servlet.http.HttpServletRequest;

public class DeleteSeanceCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        String page = null;
        MovieSeanceService service = MovieSeanceService.getInstance();

        service.deleteSeance(Integer.parseInt(req.getParameter("seanceId")));

        page = "/controller?command=getSeances";
        return page;
    }
}
