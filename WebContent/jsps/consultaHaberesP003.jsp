
<%@include file="/jsps/header.jsp" %>
<table width="760" cellpadding="0" cellspacing="0" class="tablafondo" align="center">
<html:form action="consultaHaberesP003.do" >
<tr>
<td>
   <span class="error">
     <html:errors property="errores" />
   </span><br><br>
</td>
</tr> 
<tr>
<td>    
	<table  width="80%" cellspacing="0" cellpadding="3" class="tabla1" align="center">
      <TR>
        <TH width="10%" height="20">&nbsp;</TH>
        <TH width="60%" height="20"><font size="2">APELLIDO Y NOMBRE</font></TH>
        <TH width="30%" height="20"><font size="2">DOCUMENTO</font></TH>
        <TH width="30%" height="20"><font size="2">DEP</font></TH>
        <TH width="30%" height="20"><font size="2">DISTRITO</font></TH>
        <TH width="30%" height="20"><font size="2">NOMBRE DIST.</font></TH>
        <TH width="30%" height="20"><font size="2">TIPO ORG.</font></TH>
        <TH width="30%" height="20"><font size="2">ESCUELA</font></TH>
        <TH width="30%" height="20"><font size="2">REG. ESTAT.</font></TH>

      </TR>
      <logic:iterate id="result" name="resulpersonas" indexId="index">
      <TR>
        <Td class="td1">
           <html:radio property="radio" value="${index}"/>
        </Td > 
        <Td class="td1">
          &nbsp;<bean:write name="result" property="apellido"/>
        </Td > 
        <Td class="td1">
           &nbsp;<bean:write name="result" property="documento"/>
		</Td >    
        <Td class="td1">
           &nbsp;<bean:write name="result" property="dependencia"/>
		</Td >    
        <Td class="td1">
           &nbsp;<bean:write name="result" property="numDistrito"/>
		</Td >    
        <Td class="td1">
           &nbsp;<bean:write name="result" property="descDistrito"/>
		</Td >    
        <Td class="td1">
           &nbsp;<bean:write name="result" property="tipo_org"/>
		</Td >    
        <Td class="td1">
           &nbsp;<bean:write name="result" property="escuela"/>
		</Td >    
        <Td class="td1">
           &nbsp;<bean:write name="result" property="reg"/>
		</Td >    

      </TR>
      </logic:iterate>
  </table> 
  <br><br>
</td>
</tr>
    <tr>
	<TD>
       <table width="300" align="center" cellpadding="0" cellspacing="0">
	   <tr>
	   <td>
	    <html:image page="/images/aceptar.gif"  property="aceptarButton" />    
       </td>
	   <td> 
		<html:image page="/images/cancelar.gif"  property="cancelarButton" />    
       </td>
    </tr>
	</table>
	<br><br><br><br><br><br>
 
</html:form>
</html>
</table>
<%@include file="/jsps/footer.jsp" %>
