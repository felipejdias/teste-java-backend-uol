package br.com.felipejdias.stubs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
    "codinome"
})
public class Codinomes {

    @XmlElement(required = true)
    protected List<String> codinome;

	/**
	 * Instancia uma nova lista de codinomes.
	 * 
	 * @return Lista de String que representa os codinomes obtidos do arquivo xml
	 */
    public List<String> getCodinome() {
        if (codinome == null) {
            codinome = new ArrayList<String>();
        }
        return this.codinome;
    }

}
