<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UI Admin - Clean and responsive administration panel</title>

    <meta charset="UTF-8">
    <meta name="description" content="Clean and responsive administration panel">
    <meta name="keywords" content="Admin,Panel,HTML,CSS,XML,JavaScript">
    <meta name="author" content="Erik Campobadal">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/uikit/css/uikit.css" rel="stylesheet">


</head>
<body>


<div uk-sticky="media: 960" class="uk-navbar-container tm-navbar-container uk-sticky" style="">
    <div class="uk-container uk-container-expand">
        <nav class="uk-navbar">
            <div class="uk-navbar-left">
                <a href="../" class="uk-navbar-item uk-logo">
                    <b>Breizhlink</b>
                </a>
            </div>
            <div class="uk-navbar-right">
                <ul class="uk-navbar-nav uk-visible@m">
                    <li class="uk-active"><a href="">Accueil</a></li>
                    <li><a href="">Présentation</a></li>
                </ul>
                <div class="uk-navbar-item uk-visible@m"><a href="" class="uk-button uk-button-default tm-button-default uk-icon">
                    Se connecter
                    <canvas uk-icon="icon: sign-in" width="20" height="20" class="uk-icon" hidden="true"></canvas>
                </a></div>
                <a uk-navbar-toggle-icon="" href="#offcanvas" uk-toggle=""
                   class="uk-navbar-toggle uk-hidden@m uk-navbar-toggle-icon uk-icon">
                    <svg width="20" height="20" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" ratio="1">
                        <rect y="9" width="20" height="2"></rect>
                        <rect y="3" width="20" height="2"></rect>
                        <rect y="15" width="20" height="2"></rect>
                    </svg>
                </a></div>
        </nav>
    </div>
</div>


<div class="content-background">
    <div class="uk-section-large">
        <div class="uk-container uk-container-large">
            <div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
                <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
                <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <center>
                                <h2>Breizhlink</h2><br/>
                            </center>
                            <form method="post" action="/login">
                                <fieldset class="uk-fieldset">

                                    <div class="uk-margin">
                                        <div class="uk-position-relative">
                                            <span class="uk-form-icon">
                                                <canvas uk-icon="icon: user" width="20" height="20" class="uk-icon" hidden="true"></canvas>
                                            </span>
                                            <input name="email" class="uk-input" type="email" placeholder="Email">
                                        </div>
                                    </div>

                                    <div class="uk-margin">
                                        <div class="uk-position-relative">
                                            <span class="uk-form-icon">
                                                <canvas uk-icon="icon: lock" width="20" height="20" class="uk-icon" hidden="true"></canvas>
                                            </span>
                                            <input name="password" class="uk-input" type="password" placeholder="Mot de passe">
                                        </div>
                                    </div>

                                    <center>
                                        <div class="uk-margin">
                                            <a href="#">Mot de passe oublié ?</a>
                                        </div>

                                        <div class="uk-margin">
                                            <button type="submit" class="uk-button uk-button-primary">
                                                Se connecter
                                            </button>
                                        </div>
                                    </center>

                                    <hr/>

                                    <center>
                                        <p>
                                            Pas encore de compte ?
                                        </p>
                                        <a href="register.html" class="uk-button uk-button-default">
                                            S'enregistrer
                                        </a>
                                    </center>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
            </div>
        </div>
    </div>
</div>


<div id="offcanvas" uk-offcanvas="mode: push; overlay: true" class="uk-offcanvas" style="">
    <div class="uk-offcanvas-bar">
        <div class="uk-panel">
            <ul class="uk-nav uk-nav-default tm-nav">
                <li class="uk-nav-header">General</li>
                <li><a href="../index">Home</a></li>
                <li><a href="../pro">Pro</a></li>
                <li><a href="../changelog">Changelog</a></li>
                <li><a href="../download">Download</a></li>
            </ul>
            <ul class="uk-nav uk-nav-default tm-nav uk-margin-top">
                <li class="uk-nav-header">Getting started</li>
                <li exact=""><a href="./introduction">Introduction</a></li>
                <li exact=""><a href="./installation">Installation</a></li>
                <li exact=""><a href="./less">Less</a></li>
                <li exact=""><a href="./sass">Sass</a></li>
                <li exact=""><a href="./javascript">JavaScript</a></li>
                <li exact=""><a href="./webpack">Webpack</a></li>
                <li exact=""><a href="./custom-icons">Custom icons</a></li>
                <li exact=""><a href="./avoiding-conflicts">Avoiding conflicts</a></li>
                <li exact=""><a href="./rtl">RTL support</a></li>
                <li exact=""><a href="./migration">Migration</a></li>
            </ul>
            <ul class="uk-nav uk-nav-default tm-nav uk-margin-top">
                <li class="uk-nav-header">Components</li>
                <li exact=""><a href="./accordion">Accordion</a></li>
                <li exact=""><a href="./alert">Alert</a></li>
                <li exact=""><a href="./align">Align</a></li>
                <li exact=""><a href="./animation">Animation</a></li>
                <li exact=""><a href="./article">Article</a></li>
                <li exact=""><a href="./background">Background</a></li>
                <li exact=""><a href="./badge">Badge</a></li>
                <li exact=""><a href="./base">Base</a></li>
                <li exact=""><a href="./breadcrumb">Breadcrumb</a></li>
                <li exact=""><a href="./button">Button</a></li>
                <li exact=""><a href="./card">Card</a></li>
                <li exact=""><a href="./close">Close</a></li>
                <li exact=""><a href="./column">Column</a></li>
                <li exact=""><a href="./comment">Comment</a></li>
                <li exact=""><a href="./container">Container</a></li>
                <li exact=""><a href="./countdown">Countdown</a></li>
                <li exact=""><a href="./cover">Cover</a></li>
                <li exact=""><a href="./description-list">Description List</a></li>
                <li exact=""><a href="./divider">Divider</a></li>
                <li exact=""><a href="./dotnav">Dotnav</a></li>
                <li exact=""><a href="./drop">Drop</a></li>
                <li exact=""><a href="./dropdown">Dropdown</a></li>
                <li exact=""><a href="./flex">Flex</a></li>
                <li exact=""><a href="./form">Form</a></li>
                <li exact=""><a href="./grid">Grid</a></li>
                <li exact=""><a href="./grid-parallax">Grid Parallax</a></li>
                <li exact=""><a href="./heading">Heading</a></li>
                <li exact=""><a href="./icon">Icon</a></li>
                <li exact=""><a href="./iconnav">Iconnav</a></li>
                <li exact=""><a href="./inverse">Inverse</a></li>
                <li exact=""><a href="./label">Label</a></li>
                <li exact=""><a href="./lightbox">Lightbox</a></li>
                <li exact=""><a href="./link">Link</a></li>
                <li exact=""><a href="./list">List</a></li>
                <li exact=""><a href="./margin">Margin</a></li>
                <li exact=""><a href="./marker">Marker</a></li>
                <li exact=""><a href="./modal">Modal</a></li>
                <li exact=""><a href="./nav">Nav</a></li>
                <li exact=""><a href="./navbar">Navbar</a></li>
                <li exact=""><a href="./notification">Notification</a></li>
                <li exact=""><a href="./offcanvas">Off-canvas</a></li>
                <li exact=""><a href="./overlay">Overlay</a></li>
                <li exact=""><a href="./padding">Padding</a></li>
                <li exact=""><a href="./pagination">Pagination</a></li>
                <li exact=""><a href="./parallax">Parallax</a></li>
                <li exact=""><a href="./placeholder">Placeholder</a></li>
                <li exact=""><a href="./position">Position</a></li>
                <li exact=""><a href="./print">Print</a></li>
                <li exact=""><a href="./progress">Progress</a></li>
                <li exact=""><a href="./scroll">Scroll</a></li>
                <li exact=""><a href="./scrollspy">Scrollspy</a></li>
                <li exact=""><a href="./search">Search</a></li>
                <li exact=""><a href="./section">Section</a></li>
                <li exact=""><a href="./slidenav">Slidenav</a></li>
                <li exact=""><a href="./slider">Slider</a></li>
                <li exact=""><a href="./slideshow">Slideshow</a></li>
                <li exact=""><a href="./sortable">Sortable</a></li>
                <li exact=""><a href="./spinner">Spinner</a></li>
                <li exact=""><a href="./sticky">Sticky</a></li>
                <li exact=""><a href="./subnav">Subnav</a></li>
                <li exact=""><a href="./switcher">Switcher</a></li>
                <li exact=""><a href="./tab">Tab</a></li>
                <li exact=""><a href="./table">Table</a></li>
                <li exact=""><a href="./text">Text</a></li>
                <li exact=""><a href="./thumbnav">Thumbnav</a></li>
                <li exact=""><a href="./tile">Tile</a></li>
                <li exact=""><a href="./toggle">Toggle</a></li>
                <li exact=""><a href="./tooltip">Tooltip</a></li>
                <li exact=""><a href="./totop">Totop</a></li>
                <li exact=""><a href="./transition">Transition</a></li>
                <li exact=""><a href="./upload">Upload</a></li>
                <li exact=""><a href="./utility">Utility</a></li>
                <li exact=""><a href="./visibility">Visibility</a></li>
                <li exact=""><a href="./width">Width</a></li>
            </ul>
        </div>
    </div>
</div>


<script src="assets/uikit/js/uikit.js"></script>
<script src="assets/uikit/js/uikit-icons.js"></script>
</body>
</html>