package com.guigu.drug.fuyou.pojo;

public class Staff {
    private Integer sid;

    private String sname;

	private String username;

    private String pwd;

    private String ssex;
    
    private String sdate;

    private String cellPhone;

    private String address;

    private Integer jid;

    private Integer aid;

    private Integer loantableid;

    private Integer investnotesid;

    public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "Staff [sid=" + sid + ", sname=" + sname + ", username=" + username + ", pwd=" + pwd + ", ssex=" + ssex
				+ ", sdate=" + sdate + ", cellPhone=" + cellPhone + ", address=" + address + ", jid=" + jid + ", aid="
				+ aid + ", loantableid=" + loantableid + ", investnotesid=" + investnotesid + "]";
	}



	public Staff(Integer sid, String sname, String username, String pwd, String ssex, String sdate, String cellPhone,
			String address, Integer jid, Integer aid, Integer loantableid, Integer investnotesid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.username = username;
		this.pwd = pwd;
		this.ssex = ssex;
		this.sdate = sdate;
		this.cellPhone = cellPhone;
		this.address = address;
		this.jid = jid;
		this.aid = aid;
		this.loantableid = loantableid;
		this.investnotesid = investnotesid;
	}



	public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate == null ? null : sdate.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getLoantableid() {
        return loantableid;
    }

    public void setLoantableid(Integer loantableid) {
        this.loantableid = loantableid;
    }

    public Integer getInvestnotesid() {
        return investnotesid;
    }

    public void setInvestnotesid(Integer investnotesid) {
        this.investnotesid = investnotesid;
    }
}