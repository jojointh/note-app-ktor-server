<#macro page>
    <!DOCTYPE HTML>
    <!--
    	Phantom by HTML5 UP
    	html5up.net | @ajlkn
    	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
    -->
    <html>
    	<head>
    		<title><#if page_title??>${page_title}<#else>Phantom</#if></title>
    		<meta charset="utf-8" />
    		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    		<link rel="stylesheet" href="assets/css/main.css" />
    		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
    	</head>
    	<body class="is-preload">
    		<!-- Wrapper -->
    			<div id="wrapper">

    				<!-- Header -->
    					<header id="header">
    						<div class="inner">

    							<!-- Logo -->
    								<a href="/" class="logo">
    									<span class="symbol"><img src="assets/images/logo.svg" alt="" /></span><span class="title">Phantom</span>
    								</a>

    						</div>
    					</header>

    				<!-- Main -->
    					<div id="main">
    						<div class="inner">
    						    <#nested>
    						</div>
    					</div>

    				<!-- Footer -->
    					<footer id="footer">
    						<div class="inner">
    							<section>
    								<h2>Follow</h2>
    								<ul class="icons">
    									<li><a href="#" class="icon brands style2 fa-facebook-f"><span class="label">Facebook</span></a></li>
    									<li><a href="#" class="icon brands style2 fa-github"><span class="label">GitHub</span></a></li>
    									<li><a href="#" class="icon solid style2 fa-phone"><span class="label">Phone</span></a></li>
    									<li><a href="#" class="icon solid style2 fa-envelope"><span class="label">Email</span></a></li>
    								</ul>
    							</section>
    							<ul class="copyright">
    								<li>&copy; Untitled. All rights reserved</li>
    								<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
    								<li><a href="/privacy">Privacy Policy</a></li>
    							</ul>
    						</div>
    					</footer>

    			</div>

    		<!-- Scripts -->

    	</body>
    </html>
</#macro>