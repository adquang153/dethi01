package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.hdbean;
import bean.tkbean;

public class hddao {
	DungChung dc = new DungChung();
	public ArrayList<hdbean> gethd() throws Exception{
		ArrayList<hdbean> dshd = new ArrayList<hdbean>();
		dc.KetNoi();
		String sql = "select * from HOATDONG";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String mahd = rs.getString("MaHD");
			String tenhd = rs.getString("TenHD");
			String motahd = rs.getString("MoTaHD");
			Timestamp ngbd = rs.getTimestamp("NgayGioBD");
			Timestamp ngkt = rs.getTimestamp("NgayGioKT");
			int sltt = rs.getInt("SLToiThieuYC");
			int sltd = rs.getInt("SLToiDaYC");
			Date thdk = rs.getDate("ThoiHanDK");
			String tt = rs.getString("TrangThai");
			String matv = rs.getString("MaTV");
			String ldhhd = rs.getString("LyDoHuyHD");
			hdbean hd = new hdbean(mahd, tenhd, motahd, ngbd, ngkt, sltt, sltd, thdk, tt, matv, ldhhd);
			dshd.add(hd);
		}
		rs.close();
		dc.cn.close();
		return dshd;
	}
	boolean KTHD(String mahd) throws SQLException {
		String sql = "select MaHD from HOATDONG where MaHD=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, mahd);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}
	public int themhd(hdbean hd) throws Exception {
		dc.KetNoi();
		if(KTHD(hd.getMahd())) return 0;
		String sql = "insert into HOATDONG values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, hd.getMahd());
		cmd.setString(2, hd.getTenhd());
		cmd.setString(3, hd.getMotahd());
		cmd.setTimestamp(4, hd.getNgbd());
		cmd.setTimestamp(5, hd.getNgkt());
		cmd.setInt(6, hd.getSltt());
		cmd.setInt(7, hd.getSltd());
		cmd.setDate(8, hd.getThdk());
		cmd.setString(9, hd.getTt());
		cmd.setString(10, hd.getMatv());
		cmd.setString(11, hd.getLdhhd());
		int kq = cmd.executeUpdate();
		//b5: truyen tham so
		//b6: cho thuc hien
		cmd.close();
		//b7: dong ket noi
		dc.cn.close();
		return kq;
	}
	public int xoahd(String mahd) throws Exception {
		dc.KetNoi();
//		if(KTHD(mahd))
//			return 0;
		String sql = "delete from HOATDONG where MaHD=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, mahd);
		int kq = cmd.executeUpdate();
		cmd.close();
		dc.cn.close();
		return kq;
	}
	public int Sua(hdbean nhd) throws Exception {
		//sua loai theo ma
		dc.KetNoi();
		//b2: kt trung ma
		String sql = "update HOATDONG set TenHD=?,MoTaHD=?,NgayGioBD=?,NgayGioKT=?,SLToiThieuYC=?,SLToiDaYC=?,ThoiHanDK=?,TrangThai=?,MaTV=? where MaHD=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, nhd.getTenhd());
		cmd.setString(2, nhd.getMotahd());
		cmd.setTimestamp(3, nhd.getNgbd());
		cmd.setTimestamp(4, nhd.getNgkt());
		cmd.setInt(5, nhd.getSltt());
		cmd.setInt(6, nhd.getSltd());
		cmd.setDate(7, nhd.getThdk());
		cmd.setString(8, nhd.getTt());
		cmd.setString(9, nhd.getMatv());
		cmd.setString(10, nhd.getMahd());
		int kq = cmd.executeUpdate();
		//b5: truyen tham so
		//b6: cho thuc hien
		cmd.close();
		//b7: dong ket noi
		dc.cn.close();
		return kq;
	}
	public ArrayList<tkbean> getdtb() throws Exception{
		ArrayList<tkbean> dstk = new ArrayList<tkbean>();
		dc.KetNoi();
		String sql = "select * from Vdiem";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String matv = rs.getString("MaTV");
			String httv = rs.getString("HoTen");
			String dtb = rs.getString("ĐTB");
			tkbean tk = new tkbean(matv, httv, dtb);
			dstk.add(tk);
		}
		rs.close();
		dc.cn.close();
		return dstk;
	}
}
