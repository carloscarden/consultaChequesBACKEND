<%@include file="/jsps/header.jsp" %>


<table width="760" border="0" cellspacing="0" cellpadding="0" class="tablafondo" align="center">
<html:form action="consultaHaberesP006.do" >
  <tr>
    <td align="center"><br>
	<span class="error">
     <html:errors property="errores" />
   </span><br>
   </td>
  </tr>
  <tr>
    <td align="center">
	<h4>PERSONA CON CAMBIOS DE DOCUMENTO - ELIJA EL DESEADO</h4>
    <BR><BR>
    <table width="550" cellpadding="5" cellspacing="0" class="tabla1" >
      <TR>
        <TH >&nbsp;</TH>
        <TH >APELLIDO Y NOMBRE</TH>
        <TH >DOCUMENTO</TH>
      </TR>
      <logic:iterate id="result" name="resulpersonas" indexId="index">
      <TR>
        <Td height="28" class="td1">
           <html:radio property="radio" value="${index}"/>
        </Td> 
        <Td class="td1">&nbsp;
          <bean:write name="result" property="apellido"/>
        </td>
        <Td class="td1">
          &nbsp;<bean:write name="result" property="documento"/>
        </td>
      </TR>
      </logic:iterate>
    </table> <br><br>
	</td>
  </tr>
  <tr>
    <td align="center">
	<table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><html:image page="/images/aceptar.gif"  property="aceptarButton" /></td>
    <td align="center"><html:image page="/images/cancelar.gif"  property="cancelarButton" /></td>
  </tr>
</table><br><br>
</td>
  </tr></html:form>
</table>



</html>
<%@include file="/jsps/footer.jsp" %>
