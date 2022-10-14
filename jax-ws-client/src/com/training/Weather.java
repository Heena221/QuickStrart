
package com.training;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for weather complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="weather">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxTemp" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minTemp" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="humidity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weather", propOrder = {
    "city",
    "maxTemp",
    "minTemp",
    "humidity"
})
public class Weather {

    protected String city;
    protected double maxTemp;
    protected double minTemp;
    protected double humidity;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the maxTemp property.
     * 
     */
    public double getMaxTemp() {
        return maxTemp;
    }

    /**
     * Sets the value of the maxTemp property.
     * 
     */
    public void setMaxTemp(double value) {
        this.maxTemp = value;
    }

    /**
     * Gets the value of the minTemp property.
     * 
     */
    public double getMinTemp() {
        return minTemp;
    }

    /**
     * Sets the value of the minTemp property.
     * 
     */
    public void setMinTemp(double value) {
        this.minTemp = value;
    }

    /**
     * Gets the value of the humidity property.
     * 
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Sets the value of the humidity property.
     * 
     */
    public void setHumidity(double value) {
        this.humidity = value;
    }

	@Override
	public String toString() {
		return "Weather [city=" + city + ", maxTemp=" + maxTemp + ", minTemp=" + minTemp + ", humidity=" + humidity
				+ "]";
	}
    

}
