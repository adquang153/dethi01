package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.hdbean;
import bean.tkbean;
import bo.hdbo;

/**
 * Servlet implementation class hdcontroller
 */
@WebServlet("/hdcontroller")
public class hdcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hdcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		hdbo dshd = new hdbo();
		try {
			String mahd = request.getParameter("mahd");
			String xmhd = request.getParameter("xmhd");
			String smhd = request.getParameter("smhd");
			request.setAttribute("dshd", dshd.getHD());
			if(mahd!=null) {
				String tenhd = request.getParameter("tenhd");
				String motahd = request.getParameter("mthd");
				Timestamp ngbd = Timestamp.valueOf(request.getParameter("ngbd"));
				Timestamp ngkt = Timestamp.valueOf(request.getParameter("ngkt")); 
//				Timestamp ngbd = Timestamp.valueOf("2008-1-26 12:12:12");
//				Timestamp ngkt = Timestamp.valueOf("2008-1-27 12:12:12"); 
				int sltt = Integer.valueOf(request.getParameter("sltt"));
				int sltd = Integer.valueOf(request.getParameter("sltd"));
				Date thdk = Date.valueOf(request.getParameter("thdk"));
				String tt = request.getParameter("tt");
				String matv = request.getParameter("matv");
				String ldhhd="";
				hdbean nhd = new hdbean(mahd, tenhd, motahd, ngbd, ngkt, sltt, sltd, thdk, tt, matv,ldhhd);
				if(request.getParameter("btnthem")!=null) {
					int n = dshd.ThemHD(nhd);
					if(n==0) request.setAttribute("kt", 1);
					request.setAttribute("dshd", dshd.getHD());
				}
				if(request.getParameter("btnsua")!=null) {
					int n = dshd.SuaHD(nhd);
					request.setAttribute("dshd", dshd.getHD());
				}
			}
			if(xmhd!=null) {
				int n = dshd.XoaHD(xmhd);
				request.setAttribute("dshd", dshd.getHD());
			}
			if(smhd!=null) {
				hdbean shd = new hdbean();
				for(hdbean i : dshd.getHD()) {
					if(i.getMahd().trim().equals(smhd.trim()))
						shd = i;
				}
				request.setAttribute("smhd", shd);
			}
			if(request.getParameter("ttac")!=null) {
				request.setAttribute("ttac", request.getParameter("ttac"));
			}
			if(request.getParameter("tk")!=null) {
				request.setAttribute("dtb", dshd.getDTB());
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
