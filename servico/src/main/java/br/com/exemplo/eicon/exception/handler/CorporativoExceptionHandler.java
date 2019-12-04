package br.com.exemplo.eicon.exception.handler;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.exemplo.eicon.exception.NegocioException;
import br.com.exemplo.eicon.web.rest.util.HeaderUtil;

@ControllerAdvice
public class CorporativoExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public CorporativoExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private final Logger log = LoggerFactory.getLogger(CorporativoExceptionHandler.class);

    @ExceptionHandler({NegocioException.class})
    public ResponseEntity<Object> handleIntegracaoSeiException(NegocioException exception, WebRequest request) {
        String mensagem = messageSource.getMessage(exception.getMessage(), null, LocaleContextHolder.getLocale());
        log.error("Erro :", mensagem);
        HttpHeaders failureAlert = HeaderUtil.createFailureAlert(exception.getClasseName(), exception.getMessage(), mensagem);
        return handleExceptionInternal(exception, exception.getMessage(), failureAlert, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleBigornaException(ConstraintViolationException exception, WebRequest request) {
        String chave = "erro.violacao-constraint.registro-filho-localizado";
        HttpHeaders failureAlert = HeaderUtil.createFailureAlert(exception.getConstraintName(), exception.getMessage(), chave);
        return handleExceptionInternal(exception, chave, failureAlert, HttpStatus.BAD_REQUEST, request);
    }

}
