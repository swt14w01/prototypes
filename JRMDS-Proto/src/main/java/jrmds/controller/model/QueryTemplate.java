package jrmds.controller.model;

public class QueryTemplate extends SubComponent {
	public QueryTemplate() {
		//empty for Hibernate
	}
	public QueryTemplate(String RefID) {
		super(RefID, ComponentType.TEMPLATE);
	}
	public QueryTemplate(Component cmpt) {
		super(cmpt);
	}
}
