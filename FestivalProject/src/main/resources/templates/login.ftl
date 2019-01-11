<#import "parts/pattern.ftl" as c>
<#import "parts/loginform.ftl" as l>

<@c.page>
${festival?ifExists}
<@l.login "/login" false/>
</@c.page>
