package com.nortal.jroad.client.aar;

/**
 * Aar andmekogu xtee teenused
 * 
 * @author Lauri Lättemäe (lauri.lattemaw@webmedia.ee)
 * @date 27.10.2010
 */
public enum RollEnum {
	GENERAL_ASUTUS_ESINDAJA("GENERAL.ASUTUS_ESINDAJA"),
	GENERAL_ASUTUS_AINUOIGUSETA_ESINDAJA("GENERAL.ASUTUS_AINUOIGUSETA_ESINDAJA"),
	ESFOS_TATOTLUSE_ESITAJA("ESFOS.TAOTLUSE_ESITAJA");
	
	private String value;
	
	private RollEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
