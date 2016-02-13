<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/client/">
<title>registration</title>
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
<meta name="description" content="Your description">
<meta name="keywords" content="Your keywords">
<meta name="author" content="Your name">
<meta name="format-detection" content="telephone=no"/>
<!-- Theme CSS -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Main CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Elements CSS -->
<link rel="stylesheet" href="css/elements.css">
<!-- Theme Color -->
<link rel="stylesheet" href="css/theme-color.css" type="text/css" >
<!--[if lt IE 9]>
	<script src="docs-assets/js/ie8-responsive-file-warning.js"></script>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

	<div style='text-align:center'><a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." /></a></div>  
  <![endif]-->
  
   <script type="text/javascript">
   function validate(){
	   var pass=document.getElementById("pass").value;
	   var cpass=document.getElementById("cpass").value;
	   
	   if(pass==cpass)
		   {
		   document.getElementById("passsuccess").innerHTML="password match";
		   document.getElementById("passerror").innerHTML="";
		   if(document.getElementById("emailer").innerHTML==""){
		   $(document).ready(function(){
			   $('#register').attr('disabled','disabled');
		   });
		   }
		   else if(document.getElementById("emailer").innerHTML=="Already registered"){
			   $('#register').attr('disabled','disabled');
		   }
		   else if((document.getElementById("emailer").innerHTML=="Available")){
			   $('#register').removeAttr('disabled');
		   }
		   }
	   
	   else{
		   document.getElementById("passsuccess").innerHTML="";
		   document.getElementById("passerror").innerHTML="password does not match";
		   $('#register').attr('disabled','disabled');
	   }
   }
   function loadEmail()
   {
	   var email=document.getElementById("email").value;
	   var xmlhttp=new XMLHttpRequest();
	   xmlhttp.onreadystatechange=function()
	   {
		   if (xmlhttp.readyState == 4) 
			{
				var jsonArray = JSON.parse(xmlhttp.responseText); 
				//alert(JSON.stringify(jsonArray));
				if(jsonArray.length > 0){
					document.getElementById("emailer").innerHTML="Already registered";
					if(document.getElementById("passerror").innerHTML=="" && document.getElementById("passsuccess").innerHTML==""){
					$(document).ready(function(){
						$('#register').attr('disabled','disabled');	
						submitstat=1;
					});
					}
					else if(document.getElementById("passerror").innerHTML=="password does not match"){
						$('#register').attr('disabled','disabled');
					}
					else{
						$('#register').attr('disabled','disabled');
					}
					
					
				}
				else{
					document.getElementById("emailer").innerHTML="Available";
					if(document.getElementById("passerror").innerHTML=="password does not match"){
						$('#register').attr('disabled','disabled');
					}
					else if(document.getElementById("passerror").innerHTML=="" && document.getElementById("passsuccess").innerHTML==""){
							$('#register').attr('disabled','disabled');	
						}
					else if(document.getElementById("passsuccess").innerHTML=="password match"){
					$('#register').removeAttr('disabled');
					
				}
			}
		}
  }
	   xmlhttp.open("get","${pageContext.request.contextPath}/regController?flag=loadEmail&email="+email, true)
		xmlhttp.send();
   }
   function loadCity() 
  	{
	   var state=document.getElementById("state");	
		var xmlhttp = new XMLHttpRequest();
		
		removeAllCity();
		
		xmlhttp.onreadystatechange = function()
		{
			if (xmlhttp.readyState == 4) 
			{
				var jsonArray = JSON.parse(xmlhttp.responseText);
				
				for(var i=0; i<jsonArray.length ; i++)
				{
					var createOption=document.createElement("option");
					
					createOption.value=jsonArray[i].cid;
					createOption.text=jsonArray[i].cityName;
					document.basicForm.city.options.add(createOption);
				}
			}
		}
		
		xmlhttp.open("get","${pageContext.request.contextPath}/regController?flag=loadCity&stateId="+state.value, true)
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
  
  	function removeAllCity() {
  		var removeCity=document.basicForm.city.options.length;
		for(i=removeCity ; i>0 ; i-- )
		{
			document.basicForm.city.remove(i);
		}
	}
   
   function loadState() 
   	{
		var country=document.getElementById("country");	
		var xmlhttp = new XMLHttpRequest();
		
		removeAllState();
		removeAllCity();
		
		xmlhttp.onreadystatechange = function()
		{
			if (xmlhttp.readyState == 4) 
			{
				var jsonArray = JSON.parse(xmlhttp.responseText);
				
				for(var i=0; i<jsonArray.length ; i++)
				{
					var createOption=document.createElement("option");
					
					createOption.value=jsonArray[i].stateId;
					createOption.text=jsonArray[i].stateName;
					document.basicForm.state.options.add(createOption);
				}
			}
		}
		
		xmlhttp.open("get","${pageContext.request.contextPath}/regController?flag=loadState&countryId="+country.value, true)
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
   
   	function removeAllState() {
   		var removeState=document.basicForm.state.options.length;
		for(i=removeState ; i>0 ; i-- )
		{
			document.basicForm.state.remove(i);
		}
	}
   </script>
</head>
<body>
<!--======= Side Navigation =======-->
<nav id="owl-lateral-nav">
  <h4 class="side-menu-title">Catogery</h4>
  <ul class="owl-navigation">
    <li class="item-has-children"> <a href="#0">Services</a>
      <ul class="sub-menu">
        <li><a href="#0">Brand</a></li>
        <li><a href="#0">Web Apps</a></li>
        <li><a href="#0">Mobile Apps</a></li>
      </ul>
    </li>
    <!-- item-has-children -->
    <li class="item-has-children"> <a href="#0">Products</a>
      <ul class="sub-menu">
        <li><a href="#0">Product 1</a></li>
        <li><a href="#0">Product 2</a></li>
        <li><a href="#0">Product 3</a></li>
        <li><a href="#0">Product 4</a></li>
        <li><a href="#0">Product 5</a></li>
      </ul>
    </li>
    <!-- item-has-children -->
    <li class="item-has-children"> <a href="#0">Stockists</a>
      <ul class="sub-menu">
        <li><a href="#0">London</a></li>
        <li><a href="#0">New York</a></li>
        <li><a href="#0">Milan</a></li>
        <li><a href="#0">Paris</a></li>
      </ul>
    </li>
    <!-- item-has-children -->
  </ul>
  <!-- owl-navigation -->
  <ul class="owl-navigation owl-single-item-wrapper">
    <li><a href="#0">Tour</a></li>
    <li><a href="#0">Login</a></li>
    <li><a href="#0">Register</a></li>
    <li><a href="#0">Pricing</a></li>
    <li><a href="#0">Support</a></li>
  </ul>
  <!-- owl-single-item-wrapper -->
  <ul class="owl-navigation owl-single-item-wrapper">
    <li><a class="current" href="#0">Journal</a></li>
    <li><a href="#0">FAQ</a></li>
    <li><a href="#0">Terms &amp; Conditions</a></li>
    <li><a href="#0">Careers</a></li>
    <li><a href="#0">Students</a></li>
  </ul>
  <!-- owl-single-item-wrapper -->
  <div class="social-top"> <a href="#" class="fa fa-twitter"></a> <a href="#" class="fa fa-facebook"></a> <a href="#" class="fa fa-vimeo"></a> <a href="#" class="fa fa-rss"></a> <a href="#" class="fa fa-github"></a> </div>
  <!-- socials -->
</nav>
<div class="page-wrapper">
  <!--======= Logo, Main Navigation, Search and Side navigation button=======-->
<jsp:include page="defaultheader.jsp"></jsp:include>
  <div class="page-title-container">
    
    <div class="page-title">
      <div class="container">
        <h1 class="title-center entry-title">Register</h1>
      </div>
    </div>
    <ul class="breadcrumbs">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="#">Pages</a></li>
      <li class="active">Register</li>
    </ul>
  </div>

    <div class="third">
      <h2 class="section-title">Register now</h2>
      <div class="container">
        <div class="row">
          <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <div class="box-style cont-pad">
             
                <form id="basicForm" name="basicForm" action="<%=request.getContextPath()%>/regController" method="post" class="form-horizontal">
 
                  
    <div class="form-group">
                    <label class="col-sm-3 control-label">First Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" name="firstname" class="form-control" placeholder="Enter your First name..." required />
                    </div> 
                  </div>
                  
                   <div class="form-group">
                    <label class="col-sm-3 control-label">Last Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" name="lastname" class="form-control" placeholder="Enter your Last name..." required />
                    </div> 
                  </div>    
                  
                   <div class="form-group">
                    <label class="col-sm-3 control-label">Email <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="email" name="email" id="email" class="form-control" onchange="loadEmail()" placeholder="Enter your User name..." required />
                   <label class="text-danger" id="emailer"></label>
                    </div> 
                  </div>       
                  
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Password<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="password" name="password" id="pass" class="form-control" placeholder="Enter your Password..." required />
                    </div> 
                  </div>     
                  
                   <div class="form-group">
                    <label class="col-sm-3 control-label">Confirm Password<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="password" name="confirmpassword" id="cpass" onchange="validate()" class="form-control" placeholder="Enter your Confirm Password..." required />
                    	 <label class="text-danger" id="passerror"></label>
                    	 <label class="text-success" id="passsuccess"></label>
                    </div> 
                  </div>    
                  
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Date Of Birth<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                   
                      <div class="form-group">
					 <div class="col-sm-8">
                      <input type="text" name="date" class="form-control" placeholder="dd/mm/yyyy" required />
                    </div> 
 </div>     
 </div>
 </div>
 
               
                 <div class="form-group">
                    <label class="col-sm-3 control-label">Gender<span class="text-danger">*</span></label>
<span class="text-danger"></span>
<div class="col-sm-8">
<label class="rdiobox">
<input id="gender" type="radio" required="" value="male" name="gender" aria-required="true">
<span>Male</span>
</label>
<label class="rdiobox">
<input id="gender" type="radio" value="female" name="gender">
<span>Female</span>
</label>
<label class="error" for="platform"></label>
</div>
</div>  

                  <div class="form-group">
                    <label class="col-sm-3 control-label">CountryName<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
										<select id="country" class="select2 select2-hidden-accessible"
											required="" data-placeholder="Choose One" style="width: 100%"
											name="country" aria-required="true" tabindex="-1"
											aria-hidden="true" onchange="loadState()">
											<option value="0">Select Country</option>
											<c:forEach items="${sessionScope.countryList}" var="i">
												<option value="${i.id}">${i.countryName}</option>
											</c:forEach>
										</select> <label class="error" for="state"></label>
    </div>
                  </div>
                  
 
                  <div class="form-group">
                    <label class="col-sm-3 control-label">State Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
										<select id="state" class="select2 select2-hidden-accessible"
											required="" data-placeholder="Choose One" style="width: 100%"
											name="state" aria-required="true" tabindex="-1"
											aria-hidden="true" onchange="loadCity()">
											<option value="0">Select State</option>
<%-- 											<c:forEach items="${sessionScope.loadStateList}" var="i"> --%>
<%-- 												<option value="${i.stateId}">${i.stateName}</option> --%>
<%-- 											</c:forEach> --%>
										</select> <label class="error" for="state"></label>
    </div>
                  </div>
                   
              <div class="form-group">
                    <label class="col-sm-3 control-label">City Name <span class="text-danger">*</span></label>
                    <div class="col-sm-8">
										<select id="city" class="select2 select2-hidden-accessible"
											required="" data-placeholder="Choose One" style="width: 100%"
											name="city" aria-required="true" tabindex="-1"
											aria-hidden="true">
											<option value="0">Select City</option>
<%-- 											<c:forEach items="${sessionScope.cityList}" var="i"> --%>
<%-- 												<option value="${i.cid}">${i.cityName}</option> --%>
<%-- 											</c:forEach> --%>
										</select> <label class="error" for="state"></label>
    </div>
                  </div>
                  
                
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Address<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <textarea rows="5" class="form-control" name="address" placeholder="Type your Address..." required></textarea>
                    </div>
                  </div>   
                  
                  <div class="form-group">
                    <label class="col-sm-3 control-label">Contact number<span class="text-danger">*</span></label>
                    <div class="col-sm-8">
                      <input type="text" name="contact" class="form-control" placeholder="contact number" required />
                    </div> 
                  </div>    
 					
 					
                  <hr>

                  <div class="row">
                    <div class="col-sm-9 col-sm-offset-3">
                      <button class="btn btn-success btn-quirk btn-wide mr5" name="register" id="register" disabled="disabled">Submit</button>
                      <input type="hidden" name="flag" value="InsertUser">
                      <button type="reset" class="btn btn-quirk btn-wide btn-default">Reset</button>
                    </div>
                  </div>

                </form>
            </div>
          </div>
          <!-- Modal -->
          <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                  <h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
                </div>
                <div class="modal-body">
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
                </div>
              </div>
              <!-- /.modal-content -->
            </div>
          </div>
        </div>
      </div>
    </div>

  <div id="cd-nav"> <a href="#0" class="cd-nav-trigger">Menu <span></span></a>
    <div id="cd-pop-form">
      <div class="cd-wrap-form">
        <!-- contact form -->
        <h3>Contact Us</h3>
        <form class="form1">
          <div class="success">
            <div class="success_txt">Contact form submitted!<br />
              <strong> We will be in touch soon.</strong></div>
          </div>
          <fieldset>
          <label class="name col-md-12">
          <input type="text" value="Name:">
          <span class="error">*This is not a valid name.</span> <span class="empty">*This field is required.</span> </label>
          <label class="email col-md-12">
          <input type="text" value="E-mail:">
          <span class="error">*This is not a valid email address.</span> <span class="empty">*This field is required.</span> </label>
          <label class="message col-md-12">
          <textarea>Message</textarea>
          <span class="error">*The message is too short.</span> <span class="empty">*This field is required.</span> </label>
          <div class="clear"></div>
          <div class="link-form col-md-12"><a class="flat sm purple" href="#" data-type="submit">Sumit comment</a> <a class="flat sm green" href="#" data-type="reset">Clear</a> </div>
          </fieldset>
        </form>
      </div>
    </div>
  </div>
 <jsp:include page="footer.jsp"></jsp:include>
</div>
<!-- Javascript -->
<script type="text/javascript" src="js/jquery.js"></script>
<!-- Twitter Bootstrap -->
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- Jquery UI -->
<script type="text/javascript" src="js/jquery-ui.js"></script>
<!-- All Plugins -->
<script type="text/javascript" src="js/plugins.js"></script>
<!-- Menu Navigation -->
<script type="text/javascript" src="js/owlmenu.js"></script>
<!-- Carousels -->
<script type="text/javascript" src="js/owl.carousel.js"></script>
<!--Isotop, Masonry -->
<script type="text/javascript" src="js/masonry.js"></script>
<!-- Custom  -->
<script type="text/javascript" src="js/custom.js"></script>
<!--==============================Style Switcher =================================-->
<link rel="stylesheet" href="css/switcher.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/color1.css" type="text/css" id="theme" />
<script type="text/javascript" src="js/switcher.js"></script>
</body>
</html>