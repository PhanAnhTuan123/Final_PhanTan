package services.impl;

import dao.MovieDAO;
import models.Movie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MovieServiceImpl extends UnicastRemoteObject implements services.MovieService {

    private final MovieDAO movieDAO;

    public MovieServiceImpl() throws RemoteException {
        movieDAO = new MovieDAO();
    }

    @Override
    public boolean addMovie(Movie movie) throws RemoteException {
        return movieDAO.addMovie(movie);
    }
}
