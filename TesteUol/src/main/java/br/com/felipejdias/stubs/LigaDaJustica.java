package br.com.felipejdias.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe gerada automaticamente a partir do XSD liga_da_justica.xsd que representa o layout do
 * arquivo .xml a ser consumido.
 * 
 *  
 * @author Felipe Jaconis 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codinomes"
})
@XmlRootElement(name = "liga_da_justica")
public class LigaDaJustica {

    @XmlElement(required = true)
    private Codinomes codinomes;


    public Codinomes getCodinomes() {
        return codinomes;
    }

    public void setCodinomes(Codinomes value) {
        this.codinomes = value;
    }

}
