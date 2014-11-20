package jrmds.controller.model;

public abstract class Rule extends SubComponent {
	private String severity;
	
	Rule() {
		//blubb
	}	
	Rule(String RefID, ComponentType type) {
		super(RefID, type);
	}
	Rule(Component cmpt) {
		super(cmpt.getRefID(),cmpt.getType());
		severity=cmpt.getSeverity();
	}
	
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String sev) {
		this.severity=sev;
	}
}
