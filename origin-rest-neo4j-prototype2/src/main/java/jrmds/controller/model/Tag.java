package jrmds.controller.model;

public class Tag {
	 
	public int id;
	public String tagName;
 
	//getter and setter methods
 
	public Tag(int id, String tagName) {
		this.id = id;
		this.tagName = tagName;
	}
	
	public String getTagName() {
		return tagName;
	}
 
}
