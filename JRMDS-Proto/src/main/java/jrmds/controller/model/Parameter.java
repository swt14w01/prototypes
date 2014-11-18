package jrmds.controller.model;

public class Parameter {
	private Boolean isString;
	private String name;
	private String valueStr;
	private Integer valueInt;
	
	public Parameter() {
		//empty for Hibernate
	}
	
	public Parameter(String name, String valueStr) {
		this.isString=true;
		this.name=name;
		this.valueStr=valueStr;
	}
	public Parameter(String name, Integer valueInt) {
		this.isString=false;
		this.name=name;
		this.valueInt=valueInt;
	}
	
	public String getName() {
		return name;
	}
	public Boolean isString() {
		return isString;
	}
	public String getValueStr() {
		return valueStr;
	}
	public Integer getValueInt() {
		return valueInt;
	}
}
