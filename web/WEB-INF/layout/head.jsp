<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>UI Admin - Clean and responsive administration panel</title>

        <meta charset="UTF-8">
        <meta name="description" content="Clean and responsive administration panel">
        <meta name="keywords" content="Admin,Panel,HTML,CSS,XML,JavaScript">
        <meta name="author" content="Erik Campobadal">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/assets/uikit/css/uikit.css" rel="stylesheet">
    </head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js"></script>
<div uk-sticky="media: 960" class="uk-navbar-container tm-navbar-container uk-sticky" style="">
    <div class="uk-container uk-container-expand">
        <nav class="uk-navbar">
            <div class="uk-navbar-left">
                <a href="/" class="uk-navbar-item uk-logo">
                    <b>Breizhlink</b>
                </a>
            </div>
            <div class="uk-navbar-right">
                <ul class="uk-navbar-nav uk-visible@m">
                    <li class="uk-active"><a href="/">Accueil</a></li>
                    <li><a href="">Présentation</a></li>
                </ul>
                <div class="uk-navbar-item uk-visible@m">
                    <a href="${pageContext.request.contextPath}/login" class="uk-button uk-button-default tm-button-default uk-icon"> Se connecter
                    <canvas uk-icon="icon: sign-in" width="20" height="20" class="uk-icon" hidden="true"></canvas>
                    </a>
                </div>
                <a uk-navbar-toggle-icon="" href="#offcanvas" uk-toggle="" class="uk-navbar-toggle uk-hidden@m uk-navbar-toggle-icon uk-icon">
                    <svg width="20" height="20" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" ratio="1">
                        <rect y="9" width="20" height="2"></rect>
                        <rect y="3" width="20" height="2"></rect>
                        <rect y="15" width="20" height="2"></rect>
                    </svg>
                </a>
            </div>
        </nav>
    </div>
</div>
<div class="content-background">
    <div class="uk-section-large">
        <div class="uk-container uk-container-large">