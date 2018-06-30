<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
        <div class="uk-child-width-1-2@m uk-grid-small uk-grid-match" uk-grid>
            <a href="/dashboard/account" style="text-decoration: none !important;">
                <div class="uk-card uk-card-primary uk-card-body">
                    <h3 class="uk-card-title">Mon compte</h3>
                    <p>Vous pouvez consulter et editer vos informations.</p>
                </div>
            </a>
            <a href="/dashboard/url" style="text-decoration: none !important;">
                <div class="uk-card uk-card-secondary uk-card-body">
                    <h3 class="uk-card-title">Mes URLs</h3>
                    <p>Vous pouvez consulter ou créer des URLs raccourcies.</p>
                </div>
            </a>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/foot.jsp"/>
