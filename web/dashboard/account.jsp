<%@ page import="utils.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl"></div>
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <form method="post">
                    <fieldset class="uk-fieldset">

                        <div class="uk-margin">
                            <div class="uk-position-relative">
                                        <span class="uk-form-icon">
                                            <canvas uk-icon="icon: user" width="20" height="20" class="uk-icon"
                                                    hidden="true"></canvas>
                                        </span>
                                <input name="username"
                                       class="uk-input"
                                       type="text"
                                       placeholder="Nom d'utilisateur"
                                       value="<%= ((User)request.getAttribute("user")).getUsername() %>"
                                >
                            </div>
                        </div>

                        <div class="uk-margin">
                            <div class="uk-position-relative">
                                        <span class="uk-form-icon">
                                            <canvas uk-icon="icon: user" width="20" height="20" class="uk-icon"
                                                    hidden="true"></canvas>
                                        </span>
                                <input name="email"
                                       class="uk-input"
                                       type="email"
                                       placeholder="Email"
                                       value="<%= ((User)request.getAttribute("user")).getEmail() %>"
                                >
                            </div>
                        </div>

                        <div class="uk-margin">
                            <div class="uk-position-relative">
                                        <span class="uk-form-icon">
                                            <canvas uk-icon="icon: lock" width="20" height="20" class="uk-icon"
                                                    hidden="true"></canvas>
                                        </span>
                                <input name="password" class="uk-input" type="password" placeholder="Mot de passe">
                            </div>
                        </div>

                        <div class="uk-margin">
                            <div class="uk-position-relative">
                                        <span class="uk-form-icon">
                                            <canvas uk-icon="icon: lock" width="20" height="20" class="uk-icon"
                                                    hidden="true"></canvas>
                                        </span>
                                <input name="confirm-password" class="uk-input" type="password"
                                       placeholder="Confirmer le mot de passe">
                            </div>
                        </div>

                        <center>
                            <div class="uk-margin">
                                <button type="submit" class="uk-button uk-button-primary">
                                    Enregistrer
                                </button>
                            </div>
                        </center>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
</div>

<jsp:include page="/WEB-INF/layout/foot.jsp"/>
