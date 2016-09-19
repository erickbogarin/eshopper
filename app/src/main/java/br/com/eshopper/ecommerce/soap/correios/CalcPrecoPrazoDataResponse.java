
package br.com.eshopper.ecommerce.soap.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CalcPrecoPrazoDataResult" type="{http://tempuri.org/}cResultado"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "calcPrecoPrazoDataResult"
})
@XmlRootElement(name = "CalcPrecoPrazoDataResponse")
public class CalcPrecoPrazoDataResponse {

    @XmlElement(name = "CalcPrecoPrazoDataResult", required = true)
    protected CResultado calcPrecoPrazoDataResult;

    /**
     * Obt�m o valor da propriedade calcPrecoPrazoDataResult.
     * 
     * @return
     *     possible object is
     *     {@link CResultado }
     *     
     */
    public CResultado getCalcPrecoPrazoDataResult() {
        return calcPrecoPrazoDataResult;
    }

    /**
     * Define o valor da propriedade calcPrecoPrazoDataResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CResultado }
     *     
     */
    public void setCalcPrecoPrazoDataResult(CResultado value) {
        this.calcPrecoPrazoDataResult = value;
    }

}
