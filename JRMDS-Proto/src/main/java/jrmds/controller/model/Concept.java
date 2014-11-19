package jrmds.controller.model;

public class Concept extends Rule {
	public Concept() {
		//empty Constructor for Hibernate
	}
	public Concept(String RefID) {
		super(RefID, ComponentType.CONCEPT);
	}
	public Concept(Component cmpt) {
		super(cmpt);
	}
}
