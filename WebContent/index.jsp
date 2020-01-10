<%@page import="bean.tkbean"%>
<%@page import="bean.hdbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Đề Thi Mẫu</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/solid.css" integrity="sha384-QokYePQSOwpBDuhlHOsX0ymF6R/vLk/UQVz3WHa6wygxI5oGTmDTv8wahFOSspdm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/brands.css" integrity="sha384-n9+6/aSqa9lBidZMRCQHTHKJscPq6NW4pCQBiMmHdUCvPN8ZOg2zJJTkC7WIezWv" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/fontawesome.css" integrity="sha384-vd1e11sR28tEK9YANUtpIOdjGW14pS87bUBuOIoBILVWLFnS+MCX9T6MMf0VdPGq" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <style type="text/css">
  	input,textarea{
  		border: 1px solid rgba(0,0,0,.3);
  		border-radius:5px;
  		width:100%;
  	}
  	.tk td{
  		text-align: center;
  	}
  </style>
</head>
<body>
	<section class="container-fluid mt-5">
	<a href="hdcontroller?tk=tk" class="h6">Thống kê ĐTB</a>
	<table class="table table-border">
		<tr colspans="10"><h3 class="text-center">HOẠT ĐỘNG THIỆN NGUYỆN</h3><span><a href="hdcontroller?ttac=them" class="btn btn-primary ml-auto btn-sm">Thêm</a></span></tr>
		<tr>
			<td class="h6">Mã hd</td>
			<td class="h6">Tên hd</td>
			<td class="h6">Mô tả</td>
			<td class="h6">Ngày giờ bắt đầu</td>
			<td class="h6">Ngày giờ kết thúc</td>
			<td class="h6">SL tối thiểu</td>
			<td class="h6">SL tối đa</td>
			<td class="h6">Thời hạn ĐK</td>
			<td class="h6">Trạng thái</td>
			<td class="h6">Trưởng đoàn</td>
			<td class="h6">Thao tác</td>
		<tr>
		<%
			ArrayList<hdbean> dshd =(ArrayList<hdbean>)request.getAttribute("dshd");
			for (hdbean hd : dshd ){%>
			<tr>
				<td><%=hd.getMahd() %></td>
				<td><%=hd.getTenhd() %></td>
				<td><%=hd.getMotahd() %></td>
				<td><%=hd.getNgbd() %></td>
				<td><%=hd.getNgkt() %></td>
				<td><%=hd.getSltt() %></td>
				<td><%=hd.getSltd() %></td>
				<td><%=hd.getThdk() %></td>
				<td><%=hd.getTt() %></td>
				<td><%=hd.getMatv() %></td>
				<td><a href="hdcontroller?smhd=<%=hd.getMahd()%>"><i class="fa fa-edit"></i></a>
				&ensp;<a href="hdcontroller?xmhd=<%=hd.getMahd()%>"><i class="fa fa-trash-alt"></i></a></td>
			</tr>
			<%}	%>
	</table>
	</section>
	
<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
      <%hdbean shd = (hdbean)request.getAttribute("smhd"); 
      	if(shd==null){
      %>
        <h4 class="modal-title">Thêm hoạt động thiện nguyện</h4>
        <%}else{ %>
        <h4 class="modal-title">Sửa hoạt động thiện nguyện</h4>
        <%} %>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
	<form action="hdcontroller" method="post" class="subb" onsubmit="window.location.reload();">
      <!-- Modal body -->
      <div class="modal-body">
      	<table class=" mx-auto">
	        <tr><td>Mã hd </td><td><input type="text" value="<%=(shd!=null?shd.getMahd():"") %>" name="mahd" required></td></tr>
	        <tr><td>Tên hd </td><td><input type="text" value="<%=(shd!=null?shd.getTenhd():"") %>" name="tenhd" required></td></tr>
	        <tr><td>Mô tả</td><td><textarea rows="" cols="" name="mthd" required><%=(shd!=null?shd.getMotahd():"") %></textarea></td></tr>
	        <tr><td>Ngày giờ bắt đầu</td><td><input type="text" value="<%=(shd!=null?shd.getNgbd():"") %>" name="ngbd" required></td></tr>
	        <tr><td>Ngày giờ kết thúc</td><td><input type="text" name="ngkt" value="<%=(shd!=null?shd.getNgkt():"") %>" required></td></tr>
	        <tr><td>Số lượng tối thiểu</td><td><input type="number" value="<%=(shd!=null?shd.getSltt():"") %>" name="sltt" required></td></tr>
	        <tr><td>Số lượng tối đa</td><td><input type="number" value="<%=(shd!=null?shd.getSltd():"") %>" name="sltd" required></td></tr>
	        <tr><td>Thời hạn đăng ký</td><td><input type="date" value="<%=(shd!=null?shd.getThdk():"") %>" name="thdk" required></td></tr>
	        <tr><td>Trạng thái</td><td><input type="text" name="tt" value="<%=(shd!=null?shd.getTt():"") %>" required></td></tr>
	        <tr><td>Trưởng đoàn</td><td><input type="text" name="matv" value="<%=(shd!=null?shd.getMatv():"") %>" required></td></tr>
	         
        </table>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger mr-auto" data-dismiss="modal">Hủy</button>
        <%if(shd==null){ %>
        <button type="submit" class="btn btn-primary them" name="btnthem">Thêm</button>
        <%}else{ %>
        <button type="submit" class="btn btn-primary them" name="btnsua">Sửa</button>
        <%} %>
      </div>
	</form>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal2">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
      	<h4>Thống kê ĐTB</h4>
      </div>
      <div class="modal-body">
      	<table class="tk" width="100%">
      		<tr class="border-bottom">
      			<td class="h6">Mã TV</td>
      			<td class="h6">Họ Tên</td>
      			<td class="h6">ĐTB</td>
      		</tr>
      		<% ArrayList<tkbean> dtb = (ArrayList<tkbean>)request.getAttribute("dtb"); 
      			if(dtb!=null)
      			for(tkbean i : dtb){
      		%>
      		<tr>
      			<td><%=(dtb!=null?i.getMatv():"") %></td>
      			<td><%=(dtb!=null?i.getHttv():"") %></td>
      			<td><%=(dtb!=null?i.getDtb():"") %></td>
      		</tr>
      		<%} %>
      	</table>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-danger mr-auto" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
      
<script>
<% if(shd!=null||request.getAttribute("ttac")!=null){%>
	$("#myModal").modal('show');
<%}%>
<% if(dtb!=null){ %>
	$("#myModal2").modal('show');
<%}%>
</script>
</body>
</html>