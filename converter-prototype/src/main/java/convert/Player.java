package convert;
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType; 

@XmlRootElement
class Player
{
  private String name;

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

}