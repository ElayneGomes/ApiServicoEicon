package br.com.exemplo.eicon.config;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class CnpjCpfAuth {
	
	private CnpjCpfAuth() {
		
	}

	/**
	 * Método que retorna uma HttpEntity com autorização de consumo dos serviços de 
	 * consulta por CPF e CNPJ - http://sistemasweb.cultura.gov.br/minc-pessoa/servicos/pessoa_fisica/consultar
	 * usuário e senha na primeira linha.
	 * @return HttpEntity<String>
	 */
	public static final HttpEntity<String> getCnpjCpfAuth(){
		
    	String plainCreds = "3bf410091bddf5e2092be862aa25fe34:ou8557787eRN9Dr";
    	byte[] plainCredsBytes = plainCreds.getBytes();
    	byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    	String base64Creds = new String(base64CredsBytes);

    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Authorization", "Basic " + base64Creds);
    	
    	return new HttpEntity<>(headers);
	}
}
