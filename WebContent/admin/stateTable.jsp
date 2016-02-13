<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/admin/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <!--<link rel="shortcut icon" href="../images/favicon.png" type="image/png">-->

  <title>View State</title>

  <link rel="stylesheet" href="css/font-awesome.css">
  <link rel="stylesheet" href="css/weather-icons.css">
  <link rel="stylesheet" href="css/toggles-full.css">
  <link rel="stylesheet" href="css/dataTables.bootstrap.css">
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

  <header>
    <div class="headerpanel">

      <div class="logopanel">
        <h2><a href="index.jsp">AWS</a></h2>
      </div><!-- logopanel -->

      <div class="headerbar">

        <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>

        <div class="searchpanel">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Search for...">
            <span class="input-group-btn">
              <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
            </span>
          </div><!-- input-group -->
        </div>
</div></div>
<jsp:include page="leftpanel.jsp"/>
<jsp:include page="header.jsp"/>


  <section>

   
  <div class="mainpanel">

    <div class="contentpanel">

      <ol class="breadcrumb breadcrumb-quirk">
        <li><a href="index.html"><i class="fa fa-home mr5"></i> Home</a></li>
        <li><a href="basic-tables.html">Tables</a></li>
        <li class="active">State</li>
      </ol>

      <div class="panel">
        <div class="panel-heading">
          <h4 class="panel-title">View State</h4>
         
        </div>
        <div class="panel-body">
          <div class="table-responsive">
            <table id="dataTable1" class="table table-bordered table-striped-col">
              <thead>
                <tr>
                <th>id</th>
                  <th>State Name</th>
                  <th>Description</th>
                  <th>Country Name</th>
                  <th>Action</th>
                </tr>
              </thead>
               <tbody>
              
              <c:forEach items="${sessionScope.stateList}" var="i">
			<tr>
				<td>${i.stateId}</td>
				<td>${i.stateName}</td>
				<td>${i.stateDescription}</td>
				<td>${i.cv.countryName}</td>
				<td><div class="btn-group mb-sm"><button class="btn btn-inverse dropdown-toggle" data-toggle="dropdown" type="button" name="${i.stateId}">Action<span class="caret"></span></button>
				<ul class="dropdown-menu" role="menu"><li><a href="<%=request.getContextPath()%>/stateController?flag=EditState&stateId=${i.stateId}">Edit</a></li>
				<li><a href="<%=request.getContextPath()%>/stateController?flag=DeleteState&stateId=${i.stateId}">DELETE</a></li></ul></div></td>
				
			</tr>
			
			<c:remove var="stateList" scope="session" />
		</c:forEach>
              </tbody>
              
                  </table>
          </div>
        </div>
      </div><!-- panel -->

     
  </div><!-- mainpanel -->

</section>

<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/toggles.js"></script>
<script src="js/jquery.dataTables.js"></script>
<script src="js/dataTables.bootstrap.js"></script>
<script src="js/select2.js"></script>

<script src="js/quirk.js"></script>
<script>
$(document).ready(function() {

  'use strict';

  $('#dataTable1').DataTable();

  var exRowTable = $('#exRowTable').DataTable({
    responsive: true,
    'fnDrawCallback': function(oSettings) {
      $('#exRowTable_paginate ul').addClass('pagination-active-success');
    },
    'ajax': 'ajax/objects.txt',
    'columns': [{
      'class': 'details-control',
      'orderable': false,
      'data': null,
      'defaultContent': ''
    },
    { 'data': 'name' },
    { 'data': 'position' },
    { 'data': 'office' },
    { 'data': 'start_date'},
    { 'data': 'salary' }
    ],
    'order': [[1, 'asc']]
  });

  // Add event listener for opening and closing details
  $('#exRowTable tbody').on('click', 'td.details-control', function () {
    var tr = $(this).closest('tr');
    var row = exRowTable.row( tr );

    if ( row.child.isShown() ) {
      // This row is already open - close it
      row.child.hide();
      tr.removeClass('shown');
    } else {
      // Open this row
      row.child( format(row.data()) ).show();
      tr.addClass('shown');
    }
  });

  function format (d) {
    // `d` is the original data object for the row
    return '<h4>'+d.name+'<small>'+d.position+'</small></h4>'+
    '<p class="nomargin">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>';
  }

  // Select2
  $('select').select2({ minimumResultsForSearch: Infinity });

});
</script>
</body>
</html>
