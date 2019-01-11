<#import "parts/pattern.ftl" as c>
<#import "parts/loginform.ftl" as l>

<@c.page>
<div class="mb-1">Регистрация</div>
${festival?ifExists}
<@l.login "/registration" true />
</@c.page>
