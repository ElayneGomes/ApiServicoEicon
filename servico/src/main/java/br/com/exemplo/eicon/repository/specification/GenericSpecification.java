package br.com.exemplo.eicon.repository.specification;

/**
 * Created by deividy.deividy on mai, 2019
 */
public class GenericSpecification {

    protected GenericSpecification() {

    }

    protected static String getPatternLikePercentAfterAndBefore(String parametro){
        return "%" + parametro + "%";
    }

    private static String getPatternLikePercentAfter(String parametro){
        return "%" + parametro;
    }

    private static String getPatternLikePercentBefore(String parametro){
        return parametro + "%";
    }

}




