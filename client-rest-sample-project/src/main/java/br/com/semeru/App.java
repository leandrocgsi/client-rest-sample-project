package br.com.semeru;

import br.com.semeru.authentication.Authentication;
import br.com.semeru.beans.BeanCidade;
import br.com.semeru.communication.Communication;
import br.com.semeru.communication.interfaces.ICommunication;
import com.sun.jersey.api.client.WebResource;

public class App {

    private static String url = "http://localhost:8080/erudio-client-ws-exporter/";
    private static String username = "admin";
    private static String password = "d033e22ae348aeb5660fc2140aec35850c4da997";
    private static BeanCidade cidade = new BeanCidade();
    private static WebResource resource = Authentication.authenticate(url, username, password);
    private static ICommunication<BeanCidade> cidadeCommunication = new Communication<BeanCidade>(BeanCidade.class, resource);

    public static void main(String[] args) {
        testInsertCidade();
    }

    public static void testInsertCidade() {
        cidade = new BeanCidade();
        cidade.setNomeCidade("TEST CIDADE 6");
        cidade.setPais("BRASIL");
        cidade.setSigla("MG");
        cidade.setUf("MINAS GERAIS");
        cidadeCommunication.save("service/cidade/save", "Application/JSON");
    }

    public static void testUpdateCidade() {
        cidade = new BeanCidade();
        cidade.setIdCidade(2);
        cidade.setNomeCidade("UPDATE COM JSON");
        cidade.setPais("BRASIL");
        cidade.setSigla("MG");
        cidade.setUf("MINAS GERAIS");
        cidadeCommunication.update("service/cidade/update", "Application/JSON");
    }

    public static void testDeleteCidade() {
        cidade = new BeanCidade();
        cidade.setIdCidade(55);
        cidadeCommunication.delete("service/cidade/delete/", cidade.getIdCidade(), "Application/JSON");        
    }
}
