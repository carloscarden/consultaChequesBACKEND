<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<%@include file="/jsps/header.jsp" %>
<script language=javascript>
   function goToAdobe() {
     window.open("http://www.adobe.com/products/acrobat/readstep2_allversions.html","adobe");
   }
</script>

<table width="760" cellpadding="0" cellspacing="0" class="tablafondo" align="center">
<tbody>
<tr>
<td>
<html:form  action="index.do">
</td>
</tr>
</tbody>
<tbody align="center">
			 <tr>
		  	 <td class="error"><BR> 
		     
             <html:errors property="errores" />
		   
		  </td>
		  </tr>
</tbody>
	<TR align="center">
                <TD colspan="2" class="tit"><BR><BR><BR> Consulta de Haberes</TD>
</TR>
            
            <TR align="center">
            
               <TD colspan="2">
               <BR>
              <h4 align="center">Haga Click en el Boton Aceptar Para Empezar</h4></TD>
            </TR>
           
            <TR>
              <TD align="center">
                 
                 <BR><BR><BR> 
                 <html:image page="/images/aceptar.gif"  property="aceptarButton" />   
                 <BR><BR><BR><BR><BR><BR><BR><BR><BR> 
                     <table width="95%"  height="10%" align = "center" >
	<TR>
		<TD align = "right" class="texto_negro" height="15">
		    <font size="1">
			Para visualizar y poder imprimir los Haberes, deberá tener
	        </font>	
			&nbsp;
			<!--a href="http://www.latinamerica.adobe.com/products/acrobat/readstep2.html">
		    <!-- IMG border="0" src="../images/adoberojo.gif" width="117" height="39"> </a -->
			<!-- html:link href="http://www.latinamerica.adobe.com/products/acrobat/readstep2.html" onclick="goToAdobe()" -->
            <html:img border="0" page="/images/adoberojo.gif" onclick="goToAdobe()"/>
		</TD>
	</TR>
   </table>
                 
                 
                 
              </TD>
     
      
  <center>
</html:form>


<%@include file="/jsps/footer.jsp" %>
</table>
