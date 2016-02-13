<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<%-- <base href="${pageContext.request.contextPath}/admin"> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <!--<link rel="shortcut icon" href="../images/favicon.png" type="image/png">-->

  <title>Add City</title>

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
  
 <script>
 function loadState()
 {
	 var country=document.getElementById("country");
	 var xmlhttp=new XMLHttpRequest();
	 removeAllState();
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) 
			{
				var jsonObj = JSON.parse(xmlhttp.responseText);
				
				for(i=0 ; i<jsonObj.length ; i++)
				{
					var createOption=document.createElement("option");
					
					
					createOption.value=jsonObj[i].stateId;
					createOption.text=jsonObj[i].stateName;
					
					document.cityForm.state.options.add(createOption);
					
				}
			}
			
		}

		xmlhttp.open("get", "${pageContext.request.contextPath}/CityController?flag=loadState&countryId="+country.value, true);
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
	
	function removeAllState()
	{
		var removeState=document.cityForm.state.options.length;
		for(i=removeState ; i>0 ; i-- )
		{
			document.cityForm.state.remove(i);
		}
	}
 </script>
  
</head>

<body>

 <jsp:include page="header.jsp"></jsp:include>

<section>

<jsp:include page="leftpanel.jsp"></jsp:include>

  <div class="mainpanel">

    <div class="contentpanel">

      <ol class="breadcrumb breadcrumb-quirk">
        <li><a href="index.jsp"><i class="fa fa-home mr5"></i> Home</a></li>
       
        <li class="active">City</li>
      </ol>

      <div class="row" style="background: white">

        <div class="col-md-12" >
          <div class="panel">
              <div class="panel-heading nopaddingbottom">
                <h4 class="panel-title">Add city</h4>
                
              </div>
              <div class="panel-body ">
                <hr>
                <form method="post" name="cityForm" id="basicForm" action="<%=request.getContextPath()%>/CityController" class="form-horizontal">
        <div class="form-group">
                    <label class="col-sm-3 control-label">Country Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
        <select  class="select2 select2-hidden-accessible" required="" onchange="loadState()" data-placeholder="Choose One" style="width: 100%" name="country" id="country" aria-required="true" tabindex="-1" aria-hidden="true">
     <option value="0">Select Country</option>
											<c:forEach items="${sessionScope.countryList}" var="i">
												<option value="${i.id}">${i.countryName}</option>
												
											</c:forEach>
											</select>  
											  <label class="error" for="country"></label>
    </div>
                  </div>
                          
    <div class="form-group">
                    <label class="col-sm-3 control-label">State Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
        <select  class="select2 select2-hidden-accessible" required="" data-placeholder="Choose One" style="width: 100%" name="state" id="state" aria-required="true" tabindex="-1" aria-hidden="true">
     <option value="">Choose One</option>
<%-- 											<c:forEach items="${sessionScope.stateList}" var="i"> --%>
												<option value="">choose state</option>
												
<%-- 												<c:remove var="stateList" scope="session" /> --%>
<%-- 											</c:forEach>--%></select> 
        <label class="error" for="state"></label>
    </div>
                 </div>
                  
                   <div class="form-group">
                    <label class="col-sm-3 control-label">City Name <span class="text-danger">*</span></label>
                   <div class="col-sm-8">
                      <input type="text"  name="cityName" class="form-control" placeholder="Enter your City Name..." required />
                    </div> 
                  </div>
  <div class="form-group">
                    <label class="col-sm-3 control-label">Description <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <textarea rows="5" class="form-control" name="cityDescription" placeholder="Type your Description..." required></textarea>
                    </div>
                  </div>

                 
 
                  <hr>

                  <div class="row">
                    <div class="col-sm-9 col-sm-offset-3">
                      <input type="submit" value="submit" class="btn btn-success btn-quirk btn-wide mr5">
                      <input type="hidden" name="flag" value="InsertCity">
                      <button type="reset" class="btn btn-quirk btn-wide btn-default">Reset</button>
                    </div>
                  </div>

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

