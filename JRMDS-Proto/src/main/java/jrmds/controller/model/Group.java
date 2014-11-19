package jrmds.controller.model;

public class Group extends Component {
	public Group() {
		//empty
	}
	public Group (String RefID) {
		super(RefID, ComponentType.GROUP);
	}
	public Group (Component cmpt) {
		super(cmpt.getRefID(), ComponentType.GROUP);
	}
}
