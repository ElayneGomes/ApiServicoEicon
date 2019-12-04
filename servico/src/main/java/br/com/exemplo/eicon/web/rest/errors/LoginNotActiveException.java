package br.com.exemplo.eicon.web.rest.errors;

public class LoginNotActiveException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public LoginNotActiveException(String nomeEntidade) {
        super("Usuário inativo no SIGTR. Contate o administrador do sistema", nomeEntidade, ErrorConstants.KEY_LOGIN_NOT_ACTIVE);
    }
}