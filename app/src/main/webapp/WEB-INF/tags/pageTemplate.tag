<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true"%>
<%@ attribute name="extraScripts" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<html lang="pt-BR">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="pt-BR"> <!--<![endif]-->

<compress:html removeComments="true" enabled="true" removeIntertagSpaces="true" removeMultiSpaces="true" compressJavaScript="true" compressCss="true">
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
        <title>${title } - E-Shopper</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <c:url value="/resources" var="classPath" />
        <c:url value="/wro" var="wroPath" />
        <link href="${wroPath}/vendor.css" rel="stylesheet">
        <link href="${classPath }/css/price-range.css" rel="stylesheet">
        <link href="${classPath }/css/animate.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:400,300,400italic,500,700,100"/>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans:400,800,300,600,700"/>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Abel"/>
	    <link href="${wroPath}/main.css" rel="stylesheet">
	    <link href="${classPath }/css/responsive.css" rel="stylesheet">
	    <link rel="shortcut icon" href="${classPath}/images/favicon.ico" type="image/x-icon" />
		<!--[if lt IE 9]>
    	<script src="${classPath }/js/html5shiv.js"></script>
    	<script src="${classPath }/js/respond.min.js"></script>
    	<![endif]-->       
        <script async src="${classPath }/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
     	
	    <%@include file="/WEB-INF/views/template/header.jsp" %>
	   	
		<div class="container">
			<div class="row">
	   			<jsp:doBody />
	   		</div>
	   	</div>
	   		
		<%@include file="/WEB-INF/views/template/footer.jsp" %>
  		
     	<script src="${wroPath}/vendor.js"></script>
        <script src="${classPath }/js/vendor/jquery.scrollUp.min.js"></script>
        <script src="${classPath }/js/vendor/price-range.js"></script>
        <script src="${wroPath }/main.js"></script>
        <jsp:invoke fragment="extraScripts"></jsp:invoke>
        
        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. 
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='//www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>-->
    </body>
</compress:html>
</html>

