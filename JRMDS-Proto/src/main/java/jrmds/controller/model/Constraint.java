package jrmds.controller.model;

public class Constraint extends Rule {
	
	public Constraint() {
		
	}
	public Constraint(String RefID) {
		super(RefID, ComponentType.CONSTRAINT);
	}
	public Constraint(Component cmpt) {
		super(cmpt);
	}
}
