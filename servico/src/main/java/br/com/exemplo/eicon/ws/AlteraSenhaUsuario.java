//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.01.11 às 05:02:53 PM BRST 
//


package br.com.exemplo.eicon.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de alteraSenhaUsuario complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="alteraSenhaUsuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="argumento0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="argumento1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="argumento2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alteraSenhaUsuario", propOrder = {
        "argumento0",
        "argumento1",
        "argumento2"
})
public class AlteraSenhaUsuario {

    protected String argumento0;
    protected String argumento1;
    protected String argumento2;

    /**
     * Obtém o valor da propriedade argumento0.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArgumento0() {
        return argumento0;
    }

    /**
     * Define o valor da propriedade argumento0.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArgumento0(String value) {
        this.argumento0 = value;
    }

    /**
     * Obtém o valor da propriedade argumento1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArgumento1() {
        return argumento1;
    }

    /**
     * Define o valor da propriedade argumento1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArgumento1(String value) {
        this.argumento1 = value;
    }

    /**
     * Obtém o valor da propriedade argumento2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArgumento2() {
        return argumento2;
    }

    /**
     * Define o valor da propriedade argumento2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArgumento2(String value) {
        this.argumento2 = value;
    }

}
