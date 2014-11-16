package convert;

import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType; 


@XmlType(propOrder = {"id", "description", "cypher"})
class Rules{

private String id;
private String description;
private String cypher;

	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getCypher(){
		return this.cypher;
	}
	
	
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public void setCypher(String cypher){
	    this.cypher=cypher;
	}
	
}
