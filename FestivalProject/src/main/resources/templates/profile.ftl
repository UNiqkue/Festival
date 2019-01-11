<#import "parts/pattern.ftl" as c>

<@c.page>
<h5>${username}</h5>
${festival?ifExists}
<form method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Емейл:</label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Пароль:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Номер телефона:</label>
        <div class="col-sm-6">
            <input type="tel" name="phoneNumber" class="form-control" placeholder="+375/80-29/44/25-xxx-xx-xx" value="${phoneNumber!''}"/>
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Сохранить</button>
</form>
</@c.page>
