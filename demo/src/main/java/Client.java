import services.MovieService;
import services.ShowService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("AnhTuan",8080);
        ShowService showService = (ShowService) registry.lookup("showService");
        MovieService movieService = (MovieService) registry.lookup("movieService");
        showService.lisShowByCurrentDateAndDirector("Anthony Russo")
                .forEach(System.out::println);
    }
}
