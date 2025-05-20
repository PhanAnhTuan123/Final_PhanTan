import services.MovieService;
import services.ShowService;
import services.impl.MovieServiceImpl;
import services.impl.ShowServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws Exception {
        Context context = new InitialContext();
        LocateRegistry.createRegistry(8080);

        ShowService showService = new ShowServiceImpl();
        MovieService movieService = new MovieServiceImpl();

        context.bind("rmi://AnhTuan:8080/showService", showService);
        context.bind("rmi://AnhTuan:8080/movieService", movieService);
        System.out.println("Server ready");
    }
}
