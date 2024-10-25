<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<div style="border-color: green;color:red;size:40">
<bean:message key="title"/>
</div> 

<html:form action="regis" >
<pre>
<bean:message key="id"/>       :<html:text property="id"></html:text>
<bean:message key="name"/>     :<html:text property="name"></html:text> 
<bean:message key="email"/>    :<html:text property="email"></html:text>
<bean:message key="address"/>  :<html:textarea property="address"></html:textarea><br>

<html:submit property="submit"><bean:message key="save"/></html:submit><br>
<html:submit property="submit"><bean:message key="update"/></html:submit><br>
<html:submit property="submit"><bean:message key="delete"/></html:submit><br>
<html:submit property="submit"><bean:message key="find"/></html:submit><br>
<html:submit property="submit"><bean:message key="findAll"/></html:submit><br>

<a href="./changelang.do?lang=en" style="border-style: dashed;color: activeborder;">ENGLISH</a>
<a href="./changelang.do?lang=ta" style="border-style: dashed;color: activeborder;">TAMIL</a>
</pre>
</html:form>
