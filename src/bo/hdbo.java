package bo;

import java.util.ArrayList;

import bean.hdbean;
import bean.tkbean;
import dao.hddao;

public class hdbo {
	hddao hd = new hddao();
	ArrayList<hdbean> dshd;
	ArrayList<tkbean> dstk;
	public ArrayList<hdbean> getHD() throws Exception{
		dshd = hd.gethd();
		return dshd;
	}
	public int ThemHD(hdbean nhd) throws Exception {
		return hd.themhd(nhd);
	}
	public int XoaHD(String mahd) throws Exception {
		return hd.xoahd(mahd);
	}
	public int SuaHD(hdbean nhd) throws Exception {
		return hd.Sua(nhd);
	}
	public ArrayList<tkbean> getDTB() throws Exception{
		dstk = hd.getdtb();
		return dstk;
	}
}
