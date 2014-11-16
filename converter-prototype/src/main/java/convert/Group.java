package convert;

import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.*;


class Group extends Rules{
	
private List<Group> groups = new ArrayList<Group>();


@XmlElement(name="group")
public List<Group> getGroupList(){
	return this.groups;
}

public void setGroup(Group group){
	this.groups.add(group);
}
	
}
