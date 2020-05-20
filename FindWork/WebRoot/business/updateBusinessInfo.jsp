<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>完善企业信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
  	
  	<!-- 完善企业信息 -->
  	 <div class="container" style="margin-top: 50px;">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-primary ">
                <div class="panel-heading">
                    <a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left"
                            style="color: white;"></span> </a>
                    完善企业信息
                </div>
                
                <div class="panel-body">
                
                	<!-- 提示信息 -->
                	<s:if test="errorMessage == null">
    		
			    	</s:if>
			    	<s:else>
			    		<div class="alert alert-danger" role="alert">${errorMessage }</div>
			    	</s:else>
                	
                
                    <!-- 修改表单 -->
                    <s:url id="business_update" action="business_update" namespace="/" />
                    
                    <form class="form-horizontal" action="${business_update }" method="post" enctype="multipart/form-data">
                    	
                    	<input type="hidden" name="business.id" value="${business.id }">

                       <div class="d-inline-block">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["business.name"][0] }</label>
                            </div>
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-3">${fieldErrors["business.city"][0] }</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">企业名称</label>
                                    <input type="text" name="business.name" value="${business.name }" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">所在城市</label>
                                    <select name="business.city"  class="form-control">
                                        <option value="shantou">汕头</option>
                                        <option value="zhuhai" >珠海</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["business.telephone"][0] }</label>
                            </div>
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-3">${fieldErrors["business.email"][0] }</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">联系电话</label>
                                    <input type="text" name="business.telephone" value="${business.telephone }" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6 ">
                                    <label for="" class="control-label col-md-4">邮箱</label>
                                    <input type="text" name="business.email"  value="${business.email }" class="form-control " size="30">
                                </div>
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["business.password"][0] }</label>
                            </div>
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-3">${fieldErrors["business.confirmPassword"][0] }</label>
                            </div>
                        </div>

                       <%--  <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">登录密码</label>
                                    <input type="password" name="business.password"  value="${business.password }" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6 ">
                                    <label for="" class="control-label col-md-4">确认密码</label>
                                    <input type="password" name="business.confirmPassword" value="${business.confirmPassword }" class="form-control " size="30">
                                </div>
                            </div>
                        </div> --%>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["license"][0] }</label>
                        </div>

                        <div class="row col-md-offset-2">
                            <div class="col-xs-6 col-md-3">
                                <a href="#" class="thumbnail">
                                    <img src="<%=request.getContextPath() %>/${business.getLicense_path() }" alt="...">
                                </a>
                                
                               
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputFile" class="control-label col-md-2">上传营业执照</label>
                            <!-- TODO -->
                            <input type="file" name="license" id="exampleInputFile">
                        </div>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["business.address"][0] }</label>
                        </div>

                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业地址</label>
                            <div class="col-md-9" style="padding: 0;">
                                <input type="text" name="business.address"  value="${business.address }" class="form-control">
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["business.description"][0] }</label>
                        </div>

                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业描述</label>
                            <div class="col-md-9" style="padding: 0;">
                                <textarea name="business.description"  class="form-control" id="" cols="30" rows="10">${business.description }</textarea>
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["business.url"][0] }</label>
                        </div>

                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业详情链接</label>
                            <div class="col-md-9" style="padding: 0;">
                                <input type="text" name="business.url" value="${business.url }" class="form-control">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">加入时间</label>
                                    <input type="text" name=""  value="${business.create_at }" class="form-control" size="25" readonly="readonly">
                                </div>
                                <div class="form-group col-md-6 ">
                                    <label for="" class="control-label col-md-4">系统角色</label>
                                    <input type="text" name="" value="${business.getRole().name }" class="form-control " size="30" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">审核状态</label>
                                    <s:if test="business.check_flag == 0">
                                    	<s:set name="check_status" value="%{'待审核'}" scope="action"></s:set>
                                    </s:if>
                                    <s:if test="business.check_flag == 1">
                                    	<s:set name="check_status" value="%{'已通过审核'}" scope="action"></s:set>
                                    </s:if>
                                    <s:if test="business.check_flag == -1">
                                    	<s:set name="check_status" value="%{'未通过审核'}" scope="action"></s:set>
                                    </s:if>
                                    <input type="text" name=""  value="${check_status }" class="form-control" size="25" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        
                        <div class="btn-group" style="float: right;">
                            <button type="submit" class="btn btn-primary">修改</button>
                            <button type="reset" class="btn btn-default">重置</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </div>
    
    <!-- 引入底部 -->
    <jsp:include page="/common/footer.jsp"/>
    
  </body>
</html>
