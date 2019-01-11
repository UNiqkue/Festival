<#import "parts/pattern.ftl" as c>

<@c.page>
List of speakers

<table>
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
