package jrmds.controller.model;

import java.util.Set;
import java.util.HashSet;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelatedTo;

public abstract class SubComponent extends Component {
	private String description;
	private String cypher;
	@RelatedTo(type="PARAMETER", direction=Direction.BOTH)
	private @Fetch Set<Parameter> parameters;
	
	SubComponent() {
		//empty Constructor for no-arg
	}
	SubComponent(String RefID, ComponentType type) {
		super(RefID, type);
		parameters=new HashSet<Parameter>();
	}
	SubComponent(Component cmpt) {
		super(cmpt.getRefID(), cmpt.getType());
		super.setTags(cmpt.getTags());
		description=cmpt.getDescription();
		cypher=cmpt.getCypher();
		parameters=cmpt.getParameters();
	}
	
	public String getDescription() {
		return description;
	}
	public String getCypher() {
		return cypher;
	}
	public Set<Parameter> getParameters() {
		return parameters;
	}
	public void setDescription(String desc) {
		this.description=desc;
	}
	public void setCypher(String cypher) {
		this.cypher=cypher;
	}
	public void setParameters(Set<Parameter> para) {
		this.parameters = para;
	}
	public void addParameter(Parameter para) {
		this.parameters.add(para);
	}
	public void deleteParameter(Parameter para) {
	}

}
