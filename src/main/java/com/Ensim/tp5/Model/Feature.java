package com.Ensim.tp5.Model;

public class Feature {
	private String type;
	private Geometry geometry;
	private Properties properties;

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry value) {
		this.geometry = value;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties value) {
		this.properties = value;
	}
}