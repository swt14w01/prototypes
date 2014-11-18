package jrmds.controller.model;

public class Rule extends SubComponent {
	private String severity;
		
	Rule(String RefID) {
		super(RefID);
	}
	
	public String getSeverity() {
		return severity;
	}
}
