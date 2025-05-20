package services.impl;

import dao.ShowDAO;
import models.Show;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.List;

public class ShowServiceImpl extends UnicastRemoteObject implements services.ShowService {
    private final ShowDAO showDAO;

    public ShowServiceImpl() throws RemoteException {
        showDAO = new ShowDAO();
    }
    @Override
    public List<Show> lisShowByCurrentDateAndDirector(String director) throws RemoteException {
        return showDAO.listShowsByCurrentDateAndDirector(director);
    }

    @Override
    public boolean updateShowDateTime(String showId, LocalDateTime dateTime) throws RemoteException {
        return showDAO.updateShowDateTime(showId, dateTime);
    }
}
