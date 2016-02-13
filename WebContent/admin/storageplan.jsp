<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

  <title>Storage Plan</title>

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
        <li><a href="index.jsp"><i class="fa fa-home mr5"></i> Home</a></li>
        <li><a href="general-forms.html">Forms</a></li>
        <li class="active">Storage Plan</li>
      </ol>

      <div class="row" style="background: white">

        <div class="col-md-12" >
          <div class="panel">
              <div class="panel-heading nopaddingbottom">
                <h4 class="panel-title"> Storage Plan</h4>
                
              </div>
              <div class="panel-body ">
                <hr>
                <form method="post" id="basicForm" action="<%=request.getContextPath()%>/StoragePlanController" class="form-horizontal">
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Plan Name<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" id="storageId" name="planName" class="form-control" placeholder="Enter your Plan name..." required />
                    </div> 
                  </div>
                  
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Data Size<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" id="dataStze"name="dataSize" class="form-control" placeholder="Enter your Data Size ..." required />
                    </div> 
                  </div>
                  
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Price<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" id="price" name="price" class="form-control" placeholder="Enter your Price ..." required />
                    </div> 
                  </div>
                  
                   <div class="form-group">
                    <label class="col-sm-3 control-label">Description <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <textarea rows="5" id="planDescription" name="planDescription" class="form-control" placeholder="Type your Description..." required></textarea>
                    </div>
                  </div>
                  
   
   
    </div>

</div>
                  <hr>

                  <div class="row">
                    <div class="col-sm-9 col-sm-offset-3">
                      <input type="submit" value="submit" class="btn btn-success btn-quirk btn-wide mr5">
                      <input type="hidden" name="flag" value="InsertStorage">
                   
                      <button type="reset" class="btn btn-quirk btn-wide btn-default">Cancel</button>
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

</body>
</html>