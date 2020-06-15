
<%@include file="/jsps/header.jsp" %>

<SCRIPT LANGUAGE = "JavaScript"> 

function modificar_boxes(chequear,cantidad){
for (i=0; i < cantidad ; i++ ){
if (chequear){
document.forms[0].checkBox[i].checked=true;
}else{
document.forms[0].checkBox[i].checked=false;
}}}

</SCRIPT>
<table width="760" border="0" cellspacing="0" cellpadding="0" class="tablafondo" align="center">
  <html:form action="consultaHaberesP004.do" > <tr>
    <td><br> <br><span class="error">
     <html:errors property="errores" />
   </span>
   </td>
  </tr>
  <tr>
    <td align="center"><br>
     <table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><html:image page="/images/aceptar.gif"  property="aceptarButton" /></td>
    <td>&nbsp;&nbsp;</td>
    <td><html:image page="/images/cancelar.gif"  property="cancelarButton" /></td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td><INPUT TYPE="button" NAME="marcar" VALUE="Marcar todos" onClick="modificar_boxes(true,checkBox.length)" class="buttom2"/></td>
    <td>&nbsp;&nbsp;</td>
    <td><INPUT TYPE="button" NAME="desmarcar" VALUE="Desmarcar todos" onClick="modificar_boxes(false,checkBox.length)" class="buttom2"></td>
  </tr>
 </table>
  <br>
 
  	<table width="740" cellspacing="0" cellpadding="3" class="tabla1">
  	 <logic:iterate id="result" name="cheques" indexId="index"> 
	<tr>
	<Td colspan="13" class="th2">Apellido y Nombre: <bean:write name="result" property="apellido"/> - Documento: <bean:write name="result" property="documento"/></Td>
      </TR>
		  <tr>
        <TH>&nbsp;</TH>
        <TH>Sec.</TH>
        <TH>Per&iacute;odo</TH>
        <TH>Fecha Afec.</TH>
        <TH>Foja</TH> 
        <TH>Cargo</TH> 
        <TH>Orden de Pago</TH>                        
        <TH>Fecha Pago</TH>                     
        <TH>L&iacute;quido</TH>                        
        <TH>Depend</TH>
        <TH>Distrito</TH>
        <TH>T.Org.</TH>
        <TH>Esc.</TH>
      </TR>
      <TR>
        <Td class="td1">
        <html:multibox property="checkBox" value="${index}"/></Td> 
        <Td class="td1">&nbsp;<bean:write name="result" property="secuencia"/></td>
        <Td class="td1">&nbsp;<bean:write name="result" property="periodo"/></td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="result" property="fechaafec"/></td>
        <Td align="right" class="td1">
          &nbsp;<bean:write name="result" property="foja"/></td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="result" property="cargo"/></td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="result" property="dopag"/></td>
          
         <Td align="right" class="td1">
          &nbsp;
         <logic:notEqual name="result" property="fpago" value="null">
          <bean:write name="result" property="fpago"/></td>
         </logic:notEqual> 
          
          
          
        <Td align="right" class="td1">
          &nbsp;<bean:write name="result" property="liquido"/></td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="result" property="dep"/></td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="result" property="dis"/></td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="result" property="tor"/></td>
        <Td align="right" class="td1">
         &nbsp;<bean:write name="result" property="escu"/></td>
     </logic:iterate> 
	 </TR>
      </table> 
  </td>
  	  </tr>
  <tr>
    <td align="center"><br><br>
    <table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><html:image page="/images/aceptar.gif"  property="aceptarButton" /></td>
    <td>&nbsp;&nbsp;</td>
    <td><html:image page="/images/cancelar.gif"  property="cancelarButton" /></td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td><INPUT TYPE="button" NAME="marcar" VALUE="Marcar todos" onClick="modificar_boxes(true,checkBox.length)" class="buttom2"/></td>
    <td>&nbsp;&nbsp;</td>
    <td><INPUT TYPE="button" NAME="desmarcar" VALUE="Desmarcar todos" onClick="modificar_boxes(false,checkBox.length)" class="buttom2"></td>
  </tr>
</table>
<br><br><br>
</td>
  </tr>
</table>

</html:form>
</html>

<%@include file="/jsps/footer.jsp" %>
