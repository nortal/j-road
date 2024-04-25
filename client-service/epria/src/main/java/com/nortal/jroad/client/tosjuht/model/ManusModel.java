package com.nortal.jroad.client.tosjuht.model;

import jakarta.activation.DataHandler;

/**
 * Manuse mudel faili nimi ja sisu
 * 
 * @author Lauri Lättemäe 
 * @date 02.06.2010
 */
public class ManusModel {
	private String portaaliId;
	private String nimi;
	private DataHandler sisu;
	
	public ManusModel(String portaaliId, String nimi, DataHandler sisu) {
		this.portaaliId = portaaliId;
		this.nimi = nimi;
		this.sisu = sisu;
	}

	public String getPortaaliId() {
		return portaaliId;
	}

	public String getNimi() {
		return nimi;
	}

	public DataHandler getSisu() {
		return sisu;
	}
}
