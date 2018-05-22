<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <h2 class="uk-text-center">Breizhlink</h2>
                <div class="uk-margin uk-text-center">
                    Lien demandé :
                </div>
                <div class="uk-margin uk-text-center">
                    <button id="submit" class="uk-button uk-button-default">S'y rendre</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.querySelector('[name=with-password]').addEventListener('change', function () {
        if (this.checked) {
            document.querySelector('[name=password]').style.display = 'block';
        } else {
            document.querySelector('[name=password]').style.display = 'none';
        }
    });

    document.querySelector('#submit').addEventListener('click', function (event) {
        event.preventDefault();
        var button = this;
        button.disabled = true;

        var request = new XMLHttpRequest();

        request.addEventListener("load", function (data) {
            button.disabled = false;
            var response = JSON.parse(data.target.responseText);
            document.querySelector('#output-short-url').style.display = 'block';
            document.querySelector('#output-short-url input').value = response.url;
        }, false);

        var params = {
            url: document.querySelector('[name=url]').value,
            password: document.querySelector('[name=password]').value
        };

        var searchParams = Object.keys(params).map(function (key) {
            return encodeURIComponent(key) + '=' + encodeURIComponent(params[key]);
        }).join('&');

        request.open('POST', '/url', false);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(searchParams);
    });
</script>


<jsp:include page="/WEB-INF/layout/foot.jsp"/>
