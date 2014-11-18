package jrmds.controller.model;

import java.util.List;
import java.util.ArrayList;

public class SubComponent extends Component {
	private String description;
	private String cypher;
	private List<Parameter> parameters;
	
	SubComponent(String RefID) {
		super(RefID);
		parameters=new ArrayList<Parameter>();
	}
	
	public String getDescription() {
		return description;
	}
	public String getCypher() {
		return cypher;
	}
	public List<Parameter> getParameters() {
		return parameters;
	}
}
