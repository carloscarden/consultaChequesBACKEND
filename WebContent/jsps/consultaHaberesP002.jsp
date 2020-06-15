
<%@include file="/jsps/header.jsp" %>



<table cellpadding="10" cellspacing="0" width="760" class="tablafondo" align="center">
<html:form action="consultaHaberesP002.do" >
<tr>
<td>
<span class="error"> <html:errors property="errores" /> </span>
</td>
</tr>
    <tr>
	<td align="center">
	<table width="550" cellspacing="0" cellpadding="5" class="tabla2">
     <tr>
         <td> 
             <span class="texto"> Ingrese Apellido y Nombre, o parte de el</span></td>
         <td> 
              <html:text property="apyn"  size="40" maxlength="40" />
        </td>
     </tr>
    </table><br><br><br><br>
	</td>
	</tr>
		<tr>
		<td align="center"> 
    	<table width="300" cellpadding="0" cellspacing="0">
       	<td><html:image page="/images/aceptar.gif"  property="aceptarButton" /></td>
        <td><html:image page="/images/cancelar.gif"  property="cancelarButton" /></td>
        </table><br><br><br><br><br><br><br>
		</td>
		</tr>
</table>	
	
</html:form>
</html>
<%@include file="/jsps/footer.jsp" %>
