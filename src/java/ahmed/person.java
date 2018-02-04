
package ahmed;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "person")
public class person {
    private int id;
    private String Name;
    private String Address;
    private int Age;
    
    public void setId(int x){this.id=x;}
    public void setName(String x){this.Name=x;}
    public void setAdress(String x){this.Address=x;}
    public void setAge(int x){this.Age=x;}
    @XmlElement(name = "id")
    public int getId(){return this.id;}
    @XmlElement(name = "Name")
    public String getName(){return this.Name;}
    @XmlElement(name = "Address")
    public String getAddress(){return this.Address;}
    @XmlElement(name = "Age")
    public float getAge(){return this.Age;}
    
}
