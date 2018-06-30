<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <h2 class="uk-text-center">Breizhlink</h2>
                <form method="post" action="/url">
                    <fieldset class="uk-fieldset">
                        <div class="uk-margin">
                            <input name="url" class="uk-input" type="text" placeholder="URL">
                        </div>
                        <div class="uk-margin">
                            <label>
                                <input class="uk-checkbox" type="checkbox" name="with-password">
                                Sécuriser avec un mot de passe
                            </label>
                        </div>
                        <div class="uk-margin">
                            <input name="password" class="uk-input" type="password" placeholder="Mot de passe"
                                   style="display: none;">
                        </div>
                        <div class="uk-margin uk-text-center">
                            <button id="submit" class="uk-button uk-button-default">Raccourcir</button>
                        </div>
                    </fieldset>
                </form>
                <div class="uk-margin" id="response">

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

        request.addEventListener("load", function (response) {
            button.disabled = false;
            document.querySelector('#response').innerHTML = response.target.responseText;
        }, false);

        console.log(document.querySelector('[name=url]').value);
        console.log(document.querySelector('[name=password]').value);

        request.open('POST', '/url', false);
        request.send("");
    });
</script>


<jsp:include page="/WEB-INF/layout/foot.jsp"/>
