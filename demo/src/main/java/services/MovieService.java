package services;

import models.Movie;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MovieService extends Remote {
    boolean addMovie(Movie movie) throws RemoteException;
}
