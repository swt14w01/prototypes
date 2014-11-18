package jrmds.controller.model;

public abstract class Rule extends SubComponent {
	private String severity;
	
	Rule() {
		//blubb
	}
	
	Rule(String RefID) {
		super(RefID);
	}
	
	public String getSeverity() {
		return severity;
	}
}
