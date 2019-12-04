package br.com.exemplo.eicon.web.rest.errors;

public class LoginNotAuthorityException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public LoginNotAuthorityException(String nomeEntidade) {
        super("O Usuário deve possuir permissão de acesso no SAA.", nomeEntidade, ErrorConstants.KEY_LOGIN_NOT_AUTHORITY);
    }
}