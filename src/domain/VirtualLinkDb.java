package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/*
 * Layer which converts VL records to DB 
 */

/*
 * In-memory implementation
 */
@XmlRootElement
@XmlSeeAlso(VirtualLink.class)
public class VirtualLinkDb extends ArrayList<VirtualLink>{
	private static final long serialVersionUID = 1L;

	public VirtualLinkDb() {
		super();
	}

	public VirtualLinkDb(Collection<? extends VirtualLink> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="VirtalLinks")
	public List<VirtualLink> getVirtualLinks() {
		return this;
	}
	
	/*
	 * Add a list of VLs
	 */
	public void addVirtualLinks(List<VirtualLink> Vls) {
		this.addAll(Vls);
	}
    
}
