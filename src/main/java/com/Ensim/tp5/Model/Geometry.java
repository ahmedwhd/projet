package com.Ensim.tp5.Model;

import java.util.ArrayList;

public class Geometry {
	private String type;
	private ArrayList<Double> coordinates = new ArrayList<Double>();

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public ArrayList<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<Double> value) {
		this.coordinates = value;
	}
}