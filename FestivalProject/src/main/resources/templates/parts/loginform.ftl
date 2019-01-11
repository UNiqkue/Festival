<#include "security.ftl">

<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Имя пользователя:</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User name" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Пароль:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email:</label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="some@some.com" />
        </div>
    </div>
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">Phone Number:</label>
         <div class="col-sm-6">
             <input type="tel" name="phoneNumber" class="form-control" placeholder="+375/80-29/44/25-xxx-xx-xx" />
         </div>
     </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a class="btn btn-light" role="button" href="/registration">Регистрация</a></#if>
    <button class="btn btn-success" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
     <button class="btn btn-primary" type="submit"><#if (user?? || isAdmin)>Выйти<#else>Войти</#if></button>
</form>
</#macro>
