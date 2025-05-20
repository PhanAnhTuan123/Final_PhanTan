package services;

import models.Show;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

public interface ShowService extends Remote {
    List<Show> lisShowByCurrentDateAndDirector(String director) throws RemoteException;

    boolean updateShowDateTime(String showId, LocalDateTime dateTime) throws RemoteException;
}
