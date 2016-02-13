<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/client/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <!--<link rel="shortcut icon" href="../images/favicon.png" type="image/png">-->

  <title>Add Object</title>

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
  <script type="text/javascript">
  function loadExtention()
  {
	var category=document.getElementById("category").value;
	var xmlhttp=new XMLHttpRequest();
    removeAllExtension();
    xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4) 
		{
			var jsonObj = JSON.parse(xmlhttp.responseText);
		
			for(i=0 ; i<jsonObj.length ; i++)
			{
				var createOption=document.createElement("option");
				
				
				createOption.value=jsonObj[i].extensionId;
				createOption.text=jsonObj[i].extensionName;
				
				document.basicForm.extension.options.add(createOption);
				
				
			}
		}
    }
    
    xmlhttp.open("get","${pageContext.request.contextPath}/objectController?flag=loadExtension&categoryId="+category,true);
	xmlhttp.send();
	/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
	/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
		0: request not initialized
		1: server connection established
		2: request received
		3: processing request
		4: request finished and response is ready */
  }
  
function removeAllExtension()
{
	var re=document.basicForm.extension.options.length;

	for(i=re;i>0;i--)
	{
		document.basicForm.extension.remove(i);
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
        <li><a href="index.html"><i class="fa fa-home mr5"></i> Home</a></li>
        <li><a href="general-forms.html">Forms</a></li>
        <li class="active">Bucket</li>
      </ol>

      <div class="row" style="background: white">

        <div class="col-md-12" >
          <div class="panel">
              <div class="panel-heading nopaddingbottom">
                <h4 class="panel-title">Create a bucket-select a bucket name and region</h4>
                <p>A bucket is a container for a object stored in Amazon S3.When creating a bucket you can choose a region to optimize for latency minimize cost or address regulatory requirements.  </p>
              </div>
              <div class="panel-body ">
                <hr>
                <form id="basicForm" name="basicForm" action="form-validation.html" class="form-horizontal">
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Bucket Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
        <select id="bucket" class="select2 select2-hidden-accessible" required="" data-placeholder="Choose One" style="width: 100%" name="bucketName" aria-required="true" tabindex="-1" aria-hidden="true">
            <option value="0">Select Bucket</option>
            <c:forEach items="${sessionScope.bucketList}" var="i">
            <option value="${i.id}">${i.bucketName}</option>
            </c:forEach>
            </select>
        <label class="error" for="bucket"></label>
    </div>
                  </div>
                   <div class="form-group">
                    <label class="col-sm-3 control-label">Select Category <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
        <select id="category" class="select2 select2-hidden-accessible" required="" onchange="loadExtention()" data-placeholder="Choose One" style="width: 100%" name="category" aria-required="true" tabindex="-1" aria-hidden="true">
     <option value="0">Select Category</option>
     <c:forEach items="${sessionScope.categoryList}" var="i">
     <option value="${i.id}">${i.categoryName}</option>
     
     </c:forEach>
     </select>
        <label class="category" for="country"></label>
    </div>
                  </div>
                  
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Select Extension <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <select id="extension" class="select2 select2-hidden-accessible" required="" data-placeholder="Choose One" style="width: 100%" name="extension" aria-required="true" tabindex="-1" aria-hidden="true">
                      <option value="">choose Extension</option>
                      </select>
     					
        <label class="category" for="extension"></label>
                    </div> 
                  </div>
 <div class="form-group">
                    <label class="col-sm-3 control-label">Object Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" name="objectName" class="form-control" placeholder="Enter your object name..." required />
                    </div> 
                  </div>
                   <div class="form-group">
                    <label class="col-sm-3 control-label">Object <span class="text-danger">*</span></label>
                     <button class="btn btn-success btn-quirk btn-wide mr5" style="margin-left: 12px;">Browse</button>
</div>
                  <hr>

                  <div class="row">
                    <div class="col-sm-9 col-sm-offset-3">
                      <button class="btn btn-success btn-quirk btn-wide mr5">Submit</button>
                      <input type="hidden" name="flag" value="insertObject"/>
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





.<script src="js/quirk.js"></script>
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

