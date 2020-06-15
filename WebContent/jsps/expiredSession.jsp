<%@include file="/jsps/header.jsp" %>
<table width="760" border="0" cellspacing="0" cellpadding="0" class="tablafondo" align="center">
  <tr>
    <td><html:form action="expiredSession.do" >
<center>
 <html:messages id="msg" property="systemError" message="true" header="message.header" footer="message.footer">
   <li> <bean:write name="msg"/> </li>
 </html:messages>  
 
   <div id="cpaneCentral">

      Verifique su autorizacion llamando a la mesa de ayuda 
                             <br>
                             de la Direccion de Tecnologia de la Informacion de la D.G.C. y E.
                             <br>
                         Muchas Gracias
                             <br>
                             <a href="http://abc.gov.ar"> Ingreso al portal ABC </a>
                        </div>
</center>
</html:form
></td>
  </tr>
</table>


<%@include file="/jsps/footer.jsp" %>

