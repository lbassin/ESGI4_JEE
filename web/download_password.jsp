<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <h2 class="uk-text-center">Breizhlink</h2>
                <form method="post">
                    <div class="uk-margin">
                        <input name="password" class="uk-input" type="password" placeholder="Password">
                    </div>
                    <div class="uk-margin uk-text-center">
                        <button type="submit" class="uk-button uk-button-default">Get link</button>
                    </div>
                    <% if (request.getAttribute("error") != null) { %>
                    <div class="uk-alert-danger" uk-alert>
                        <p>
                            <%= request.getAttribute("error") %>
                        </p>
                    </div>
                    <% } %>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/foot.jsp"/>
