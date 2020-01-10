package bean;

import java.sql.Date;
import java.sql.Timestamp;

public class hdbean {
	private String mahd;
	private String tenhd;
	private String motahd;
	private Timestamp ngbd;
	private Timestamp ngkt;
	private int sltt;
	private int sltd;
	private Date thdk;
	private String tt;
	private String matv;
	private String ldhhd;
	public hdbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hdbean(String mahd, String tenhd, String motahd, Timestamp ngbd, Timestamp ngkt, int sltt, int sltd,
			Date thdk, String tt, String matv, String ldhhd) {
		super();
		this.mahd = mahd;
		this.tenhd = tenhd;
		this.motahd = motahd;
		this.ngbd = ngbd;
		this.ngkt = ngkt;
		this.sltt = sltt;
		this.sltd = sltd;
		this.thdk = thdk;
		this.tt = tt;
		this.matv = matv;
		this.ldhhd = ldhhd;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getTenhd() {
		return tenhd;
	}
	public void setTenhd(String tenhd) {
		this.tenhd = tenhd;
	}
	public String getMotahd() {
		return motahd;
	}
	public void setMotahd(String motahd) {
		this.motahd = motahd;
	}
	public Timestamp getNgbd() {
		return ngbd;
	}
	public void setNgbd(Timestamp ngbd) {
		this.ngbd = ngbd;
	}
	public Timestamp getNgkt() {
		return ngkt;
	}
	public void setNgkt(Timestamp ngkt) {
		this.ngkt = ngkt;
	}
	public int getSltt() {
		return sltt;
	}
	public void setSltt(int sltt) {
		this.sltt = sltt;
	}
	public int getSltd() {
		return sltd;
	}
	public void setSltd(int sltd) {
		this.sltd = sltd;
	}
	public Date getThdk() {
		return thdk;
	}
	public void setThdk(Date thdk) {
		this.thdk = thdk;
	}
	public String getTt() {
		return tt;
	}
	public void setTt(String tt) {
		this.tt = tt;
	}
	public String getMatv() {
		return matv;
	}
	public void setMatv(String matv) {
		this.matv = matv;
	}
	public String getLdhhd() {
		return ldhhd;
	}
	public void setLdhhd(String ldhhd) {
		this.ldhhd = ldhhd;
	}
	
	
}
