	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>企业中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </head>
  
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
  
  	<!-- 企业中心具体页面 -->
  	 <!--企业中心-->
    <div class="container">
    	<!-- 提示信息 -->
    	
    	<s:if test="message == null">
    		
    	</s:if>
    	<s:else>
    		<div class="alert alert-success" role="alert">${message }</div>
    	</s:else>
    	
    	
        <div class="col-md-8 col-md-offset-1">
            <div class="panel panel-info">
                <div class="panel-heading">企业中心</div>
                <div class="panel-body">
                    <div class="page-header">
                        <h1>以往招聘信息 <small> 总数&nbsp;<span class="badge">${count }</span></small></h1>
                      </div>
                      <!--显示以往的招聘-->
                      <table class="table table-striped">
                        <tr>
                            <th>#</th>
                            <th>岗位</th>
                            <th>学历要求</th>
                            <th>薪资范围</th>
                            <th>截止日期</th>
                            <th>操作 </th>
                        </tr>
                        <s:if test="advertises == null || advertises.size() == 0">
                        	<tr>
                        	 	<td colspan="6">您还为发布招聘信息，点击右方添加招聘信息</td>
                        	</tr>
                        </s:if>
                        <s:else>
                        <s:iterator value="advertises">
                        	<tr>
	                            <td>${id }</td>
	                            <td>${postName }</td>
	                            <td>${educationBackground }</td>
	                            <td>${lowWages }-${largeWages }</td>
	                            <td><s:property value="deadline" /></td>
	                            <td>
	                            	<s:url id="detailAdvertise" action="detailAdvertise" namespace="/">
	                            		<s:param name="advertise.id">${id }</s:param>
	                            	</s:url>
	                                <a href="${detailAdvertise }">查看详情</a>
	                            </td>
	                        </tr>
                        </s:iterator>
                        </s:else>
                      </table>
                      <!--分页-->
                      <nav aria-label="Page navigation">
                        <ul class="pagination">
                        	<s:url id="business_showBusinessCenterFirst" action="business_showBusinessCenter" namespace="/">
	                          	<s:param name="business.id">${business.id }</s:param>
	                          	<s:param name="currentPage">1</s:param>
	                          </s:url>
                          <li>
                            <a href="${business_showBusinessCenterFirst }" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <s:url id="business_showBusinessCenterBefore" action="business_showBusinessCenter" namespace="/">
                          	<s:param name="business.id">${business.id }</s:param>
                          	<s:param name="currentPage">${currentPage - 1 }</s:param>
                          </s:url>
                          <li><a href="${business_showBusinessCenterBefore }"> < </a></li>
                          <li><a href="">${currentPage }/${lastPage }</a></li>
                          <s:url id="business_showBusinessCenterNext" action="business_showBusinessCenter" namespace="/">
                          	<s:param name="business.id">${business.id }</s:param>
                          	<s:param name="currentPage">${currentPage + 1 }</s:param>
                          </s:url>
                          <li><a href="${business_showBusinessCenterNext }"> > </a></li>
                          <s:url id="business_showBusinessCenterLast" action="business_showBusinessCenter" namespace="/">
                          	<s:param name="business.id">${business.id }</s:param>
                          	<s:param name="currentPage">${lastPage }</s:param>
                          </s:url>
                          <li>
                            <a href="${business_showBusinessCenterLast }" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                      </nav>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-info">
                <div class="panel-heading">企业相关信息</div>
                <div class="panel-body">
                    <label for="">企业名称:</label>
                    &nbsp;
                    <span>${business.getName() }</span>
                    <br>
                    <label for="">所在城市:</label>
                    &nbsp;
                    <span>${business.city }</span>
                    <br>
                    <label for="">联系电话:</label>
                    &nbsp;
                    <span>${business.telephone }</span>
                    <br>
                    <div class="btn btn-group">
                    	<s:url id="business_showUpdate" action="business_showUpdatePage" namespace="/">
                    		<s:param name="business.id">${business.id }</s:param>
                    	</s:url>
                        <div class="btn btn-info"><a href="${business_showUpdate }" style="color: white;">完善信息</a></div>
                    </div>
                   <div class="btn btn-group">
                        <div class="btn btn-info"><a href="<%=request.getContextPath()%>/toAddAdvertise.action" style="color: white;">添加招聘信息</a></div>
                    </div>
                    <div class="btn btn-group">
                        <div class="btn btn-info"><a href="<%=request.getContextPath()%>/toFinAdvertise.action" style="color: white;">查看已发布的招聘</a></div>
                    </div>
                    <div class="btn btn-group">
                        <!-- <div class="btn btn-info"><a href="../postjob/weifabujob.jsp" style="color: white;">查看未发布的招聘</a></div> -->
                        <div class="btn btn-info"><a href="<%=request.getContextPath()%>/toUnFinAdvertise.action" style="color: white;">查看未发布的招聘</a></div>
                    </div>
                </div>
            </div>
        </div>
       

    </div>
    
    <!-- 引入底部 -->
    <jsp:include page="/common/footer.jsp"/>
    <script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </body>
</html>