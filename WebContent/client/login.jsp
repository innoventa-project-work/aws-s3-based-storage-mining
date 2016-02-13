<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/client/">
<%-- <base href="${pageContext.request.contextPath}/client/"> --%>
<title>AWS</title>
<meta charset="utf-8">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
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
        <h1 class="title-center entry-title">Login</h1>
      </div>
    </div>
  </div>
  <br>

        <div class="row">
          <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            
              <form method="post" action="login.jsp">
                <h2>Please Login <small>It's free and always will be.</small></h2>
                <hr class="colorgraph">
                
                <div class="form-group">
                
                  <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="4">
                </div>
                
                    <div class="form-group">
                      <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="5">
                    </div>
                  
                  <div class="col-xs-6 col-md-6">
                    <input type="submit" value="Sign In" class="btn btn-primary btn-block btn-lg" tabindex="7">
                  <input type="hidden" name="flag" value="login" />
                  </div>
                  <div class="col-xs-6 col-md-6"><a href="<%=request.getContextPath()%>/regController?flag=searchLocation" class="btn btn-success btn-block btn-lg">Registration</a></div>
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
				
              </form>
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
<link rel="stylesheet" href="demo/switcher.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/color1.css" type="text/css" id="theme" />
<script type="text/javascript" src="demo/switcher.js"></script>
<div class="switcher clearfix">
  <div class="switcher-head"> <span>Choose your Style</span>
    <div class="switcher-trigger icon-open-cls"></div>
  </div>
  <div class="switcher-body clearfix">
    <div class="switcher-op-layout">
      <select id="switcher-option-layout" name="switcher-option-layout" class="input-block-level nobottommargin">
        <option value="layout-full" selected="selected">Full Width</option>
        <option value="layout-boxed">Boxed</option>
      </select>
    </div>
    <div class="line"></div>
    <div class="switcher-op-colors">
      <p><strong>Predefined Colors:</strong></p>
      <div id="color-changer-box"> <a style="background-color: #2980B9;" href="javascript: void(0)" title="switch styling" id="color1"></a> <a style="background-color: #E74C3C;" href="javascript: void(0)" title="switch styling" id="color2"></a> <a style="background-color: #1ABC9C;" href="javascript: void(0)" title="switch styling" id="color3"></a> <a style="background-color: #F6BB42;" href="javascript: void(0)" title="switch styling" id="color4"></a> <a style="background-color: #967ADC;" href="javascript: void(0)" title="switch styling" id="color5"></a> <a style="background-color: #D770AD;" href="javascript: void(0)" title="switch styling" id="color6"></a> <a style="background-color: #8CC152;" href="javascript: void(0)" title="switch styling" id="color7"></a> <a style="background-color: #434A54;" href="javascript: void(0)" title="switch styling" id="color8"></a> </div>
      <small>* You can use Unlimited Colors</small> </div>
    <div class="line"></div>
    <div class="switcher-op-patterns">
      <p><strong>Background Patterns:</strong></p>
      <ul id="switcher-option-pattern" class="switcher-op-selectors clearfix">
        <li style="background-image: url('demo/patterns/light/pattern1.png');" data-url="demo/patterns/light/pattern1.png"></li>
        <li style="background-image: url('demo/patterns/light/pattern2.png');" data-url="demo/patterns/light/pattern2.png"></li>
        <li style="background-image: url('demo/patterns/light/pattern3.png');" data-url="demo/patterns/light/pattern3.png"></li>
        <li style="background-image: url('demo/patterns/light/pattern4.png');" data-url="demo/patterns/light/pattern4.png"></li>
        <li style="background-image: url('demo/patterns/light/pattern5.png');" data-url="demo/patterns/light/pattern5.png"></li>
        <li style="background-image: url('demo/patterns/light/pattern6.png');" data-url="demo/patterns/light/pattern6.png"></li>
        <li style="background-image: url('demo/patterns/light/pattern7.png');" data-url="demo/patterns/light/pattern7.png"></li>
        <li style="background-image: url('demo/patterns/light/pattern8.png');" data-url="demo/patterns/light/pattern8.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern1.png');" data-url="demo/patterns/dark/pattern1.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern2.png');" data-url="demo/patterns/dark/pattern2.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern3.png');" data-url="demo/patterns/dark/pattern3.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern4.png');" data-url="demo/patterns/dark/pattern4.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern5.png');" data-url="demo/patterns/dark/pattern5.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern6.png');" data-url="demo/patterns/dark/pattern6.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern7.png');" data-url="demo/patterns/dark/pattern7.png"></li>
        <li style="background-image: url('demo/patterns/dark/pattern8.png');" data-url="demo/patterns/dark/pattern8.png"></li>
      </ul>
      <small>* Only for Boxed Layout</small>
      <div class="line"></div>
      <div class="switcher-op-bgimages">
        <p><strong>Background Images:</strong></p>
        <ul id="switcher-option-bgimage" class="switcher-op-selectors clearfix">
          <li data-url="demo/bgimages/1.jpg"><img src="demo/bgimages/small/1.jpg" alt="Background Image 1" title="Background Image 1" /></li>
          <li data-url="demo/bgimages/2.jpg"><img src="demo/bgimages/small/2.jpg" alt="Background Image 2" title="Background Image 2" /></li>
          <li data-url="demo/bgimages/3.jpg"><img src="demo/bgimages/small/3.jpg" alt="Background Image 3" title="Background Image 3" /></li>
          <li data-url="demo/bgimages/4.jpg"><img src="demo/bgimages/small/4.jpg" alt="Background Image 4" title="Background Image 4" /></li>
          <li data-url="demo/bgimages/5.jpg"><img src="demo/bgimages/small/5.jpg" alt="Background Image 5" title="Background Image 5" /></li>
          <li data-url="demo/bgimages/6.jpg"><img src="demo/bgimages/small/6.jpg" alt="Background Image 6" title="Background Image 6" /></li>
          <li data-url="demo/bgimages/7.jpg"><img src="demo/bgimages/small/7.jpg" alt="Background Image 7" title="Background Image 7" /></li>
          <li data-url="demo/bgimages/8.jpg"><img src="demo/bgimages/small/8.jpg" alt="Background Image 8" title="Background Image 8" /></li>
        </ul>
        <small>* Only for Boxed Layout</small> </div>
    </div>
  </div>
</div>
</body>
</html>