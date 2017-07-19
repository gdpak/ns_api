package domain;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Data Holder for VL
 * @author Deepak Agrawal
 */
@XmlRootElement
public class VirtualLink {
	int id;
	String subnet_assigned;
	String ip_profile;
	int cloud_tenant_id;
	int ns_id;
	int state;
	int prev_state;
	Date time_created;
	
	public VirtualLink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VirtualLink(int id, String subnet_assigned, String ip_profile, int cloud_tenant_id, int ns_id,
			int state, int prev_state, Date time_created) {
		super();
		this.id = id;
		this.subnet_assigned = subnet_assigned;
		this.ip_profile = ip_profile;
		this.cloud_tenant_id = cloud_tenant_id;
		this.ns_id = ns_id;
		this.state = state;
		this.prev_state = prev_state;
		this.time_created = time_created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubnet_assigned() {
		return subnet_assigned;
	}

	public void setSubnet_assigned(String subnet_assigned) {
		this.subnet_assigned = subnet_assigned;
	}

	public String getIp_profile() {
		return ip_profile;
	}

	public void setIp_profile(String ip_profile) {
		this.ip_profile = ip_profile;
	}

	public int getCloud_tenant_id() {
		return cloud_tenant_id;
	}

	public void setCloud_tenant_id(int cloud_tenant_id) {
		this.cloud_tenant_id = cloud_tenant_id;
	}

	public int getNs_id() {
		return ns_id;
	}

	public void setNs_id(int ns_id) {
		this.ns_id = ns_id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPrev_state() {
		return prev_state;
	}

	public void setPrev_state(int prev_state) {
		this.prev_state = prev_state;
	}

	public Date getTime_created() {
		return time_created;
	}

	public void setTime_created(Date time_created) {
		this.time_created = time_created;
	}
	
}
