package br.com.semeru.util;

import com.sun.jersey.api.client.ClientResponse;

public class ResponseUtils {
	
	public String responseStatus(ClientResponse response) {
		String mensagem = null;
		if (response.getStatus() == 200) {
			System.err.println("OK estamos conectados.");
        } else if (response.getStatus() == 403) {
            System.err.println("Voc� n�o tem permiss�o para acessar este recurso.");
        } else {
            System.err.println("Ocorreu um erro " + response.getStatus() + " ao tentar a conex�o com o servidor.");
        }
		return mensagem;		
	}
}
