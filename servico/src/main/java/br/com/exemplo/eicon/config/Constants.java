package br.com.exemplo.eicon.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_LANGUAGE = "en";
    
    public static final String SCHEMA_ORACLE_MDSGERAL = "MDSGERAL";
    public static final String SCHEMA_ORACLE_CORP_CNPJ= "CORP_CNPJ";

    private Constants() {
    }
}
