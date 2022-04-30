package users_service;

import users_service.services.TeamsServiceImpl;
import users_service.services.UsersServiceImpl;

import javax.xml.ws.Endpoint;
import java.util.logging.Logger;

public class  UsersServiceServer {

    private static final Logger LOGGER = Logger.getGlobal();

    public static void main(String[] args) {
        LOGGER.info("Creating WEB server and publishing SOAP endpoints");
        Endpoint.publish("http://localhost:8090/svc_users", new UsersServiceImpl());
        Endpoint.publish("http://localhost:8090/svc_teams", new TeamsServiceImpl());
    }
}
