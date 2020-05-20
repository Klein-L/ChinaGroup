<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/User_home_page.css" />
	<link rel="stylesheet" href="css/yufeng/header.css" />
	<link rel="stylesheet" href="resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
  </head>
  
  <body>
		<!-- 引入头部 -->
    	<jsp:include page="/common/header.jsp"/>
		
		<div class="main_body">
			<div class="div_search">
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="岗位 / 公司">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div><!-- /input-group -->
				</div><!-- /.col-lg-6 -->
			</div><!-- /.row -->
		</div>

		<div class="div_title">
			<label class="label label-danger">热门岗位</label>
			<a class="types" href="#">证券</a>
			<a class="types" href="#">C++</a>
			<a class="types" href="#">PHP</a>
			<a class="types" href="#">Web前端</a>
			<a class="types" href="#">UI设计师</a>
			<a class="types" href="#">平面设计师</a>
		</div>

		<div style="width: 100%;height: 400px;">
			<div class="offer_info">
				
				<s:if test="pts!=null">
					<s:iterator value="pts">
					<div class="type">
						<a class="offer_type" href="#"><s:property value="PTname"/></a>
						<s:iterator value="posts">
							<a class="types" href="#"><s:property value="Pname"/></a>
						</s:iterator>
					</div>
					</s:iterator>
				</s:if>
				
			</div>

			<div class="ad_info">
				<div class="row_1">
					<img class="ad_img1" src="resource/image/yufeng/adimg2.jpg" />
					<img class="ad_img2" src="resource/image/yufeng/adimg3.jpg" />
				</div>
				<div class="row_2">
					<img class="ad_img3" src="resource/image/yufeng/adimg4.jpg" />
					<img class="ad_img4" src="resource/image/yufeng/adimg5.jpg" />
				</div>
				<div class="row_3">
					<img class="ad_img5" src="resource/image/yufeng/adimg1.jpg" />
				</div>
			</div>
		</div>

		<div class="hot_jobs">

			<div class="hot_jobs_title">
				<label>______</label>
				<label>热招职位</label>
				<label>______</label>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="resource/image/yufeng/jimg2.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="resource/image/yufeng/jimg1.jpg" />
						</div>
						<div class="mid_img2">
							<img src="resource/image/yufeng/jimg3.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="#">网络工程师</a>
						<label>腾讯 | 本科</label>
						<h3>15k - 25k</h3>
					</div>
				</div>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="resource/image/yufeng/jimg5.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="resource/image/yufeng/jimg4.jpg" />
						</div>
						<div class="mid_img2">
							<img src="resource/image/yufeng/jimg6.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="#">网络工程师</a>
						<label>腾讯 | 本科</label>
						<h3>15k - 25k</h3>
					</div>
				</div>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="resource/image/yufeng/jimg7.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="resource/image/yufeng/jimg9.jpg" />
						</div>
						<div class="mid_img2">
							<img src="resource/image/yufeng/jimg8.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="#">网络工程师</a>
						<label>腾讯 | 本科</label>
						<h3>15k - 25k</h3>
					</div>
				</div>
			</div>
		</div>

		<!-- 引入底部 -->
    	<jsp:include page="/common/footer.jsp"/>
		<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</body>
</html>