package com.Ensim.tp5.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AddressData {

	private String type;
	private String version;
	ArrayList<Object> features = new ArrayList<Object>();
	private String attribution;
	private String licence;
	private String query;
	private long limit;

	private ArrayList<Double> getCoordinates() {

		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> firstResult = (LinkedHashMap<String, Object>) features.get(0);
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> geometry = (LinkedHashMap<String, Object>) firstResult.get("geometry");
		@SuppressWarnings("unchecked")
		ArrayList<Double> coordinates = (ArrayList<Double>) geometry.get("coordinates");
		return coordinates;
	}

	public Double getLon() {
		return getCoordinates().get(0);
	}

	public Double getLat() {
		return getCoordinates().get(1);
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String value) {
		this.version = value;
	}

	public String getAttribution() {
		return attribution;
	}

	public void setAttribution(String value) {
		this.attribution = value;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String value) {
		this.licence = value;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String value) {
		this.query = value;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long value) {
		this.limit = value;
	}

	public ArrayList<Object> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<Object> features) {
		this.features = features;
	}

	public String getAddress() {
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> firstResult = (LinkedHashMap<String, Object>) this.features.get(0);
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) firstResult.get("properties");
		String label = (String) properties.get("label");
		return label;
	}
}
