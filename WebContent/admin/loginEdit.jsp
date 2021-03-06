<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <!--<link rel="shortcut icon" href="../images/favicon.png" type="image/png">-->

  <title>Edit Login</title>

  <link rel="stylesheet" href="css/font-awesome.css">
  <link rel="stylesheet" href="css/weather-icons.css">
  <link rel="stylesheet" href="css/toggles-full.css">
  <link rel="stylesheet" href="css/select2.css">

  <link rel="stylesheet" href="css/quirk.css">

  <script src="js/modernizr.js"></script>

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="../lib/html5shiv/html5shiv.js"></script>
  <script src="../lib/respond/respond.src.js"></script>
  <![endif]-->
</head>

<body>

 <jsp:include page="header.jsp"></jsp:include>

<section>

<jsp:include page="leftpanel.jsp"></jsp:include>

  <div class="mainpanel">

    <div class="contentpanel">

      <ol class="breadcrumb breadcrumb-quirk">
        <li><a href="index.html"><i class="fa fa-home mr5"></i> Home</a></li>
        
        <li class="active">Login</li>
      </ol>

      <div class="row" style="background: white">

        <div class="col-md-12" >
          <div class="panel">
              <div class="panel-heading nopaddingbottom">
                <h4 class="panel-title">Edit Login</h4>
                
              </div>
              <div class="panel-body ">
                <hr>
                <form method="post" action="<%=request.getContextPath()%>/loginController">
                 <c:forEach items="${sessionScope.EditLogin}" var="i">
                <h2>Please Login <small>It's free and always will be.</small></h2>
                <hr class="colorgraph">
                
                <div class="form-group">
                <label class="col-sm-3 control-label">Email <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                  <input type="email" name="email" id="email" value="${i.email }" class="form-control input-lg" placeholder="Email Address" tabindex="4">
                </div>
                </div>
                    <div class="form-group">
                    <label class="col-sm-3 control-label">Password<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" name="password" id="password" value="${i.password }" class="form-control input-lg" placeholder="Password" tabindex="5">
                    </div>
                  </div>
                  <div class="col-xs-6 col-md-6">
                    <input type="submit" value="Update" class="btn btn-primary btn-block btn-lg" tabindex="7">
                  <input type="hidden" name="flag" value="UpdateUser" />
                  <input type="hidden" name="loginid" value="${i.loginid }" />
                  </div>
                 
				   <div>
                <%
if(session.getAttribute("errorMsg")!=null)
{
String user = session.getAttribute("errorMsg").toString();
%>
<b><%= user%></b>
<%
}
%>


<div>
                <%
if(session.getAttribute("userDetails")!=null)
{
%>
<b><script type="text/javascript">alert("loged in!!!");</script></b>
<%
}
%>

                </div>
				   <hr class="colorgraph">
                </div>
				</c:forEach>
              </form>
              </div><!-- panel-body -->
          </div><!-- panel -->

        </div><!-- col-md-6 -->

    </div><!-- contentpanel -->

  </div><!-- mainpanel -->
</section>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/toggles.js"></script>
<script src="js/select2.js"></script>
<script src="js/jquery.validate.js"></script>





<script src="js/quirk.js"></script>
<script>
$(document).ready(function(){

  'use strict';

  // Basic Form
  $('#basicForm').validate({
    highlight: function(element) {
      $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function(element) {
      $(element).closest('.form-group').removeClass('has-error');
    }
  });

  // Error Message In One Container
  $('#basicForm2').validate({
	 errorLabelContainer: jQuery('#basicForm2 div.error')
  });

  // With Checkboxes and Radio Buttons
  $('#basicForm3').validate({
    highlight: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-error');
    }
  });

  // Validation with select boxes
  $('#basicForm4').validate({
    highlight: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-error');
    }
  });

  $('.select2').select2();


});
</script>
-->
</body>
</html>