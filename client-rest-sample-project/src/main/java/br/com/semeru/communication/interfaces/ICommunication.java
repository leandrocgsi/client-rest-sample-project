package br.com.semeru.communication.interfaces;

import br.com.semeru.beans.BaseBean;
import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

public interface ICommunication<T extends BaseBean> {

    ClientResponse save(String path, String mediaType);
    ClientResponse update(String path, String mediaType);
    ClientResponse delete(String path, Integer id, String mediaType);
    ClientResponse findById(String path, Integer id, String mediaType);
    List<T> findAll();
    List<T> findByQuery();
}
