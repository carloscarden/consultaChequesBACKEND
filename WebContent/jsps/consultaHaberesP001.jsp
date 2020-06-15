<%@include file="/jsps/header.jsp" %>




<table width="760" cellpadding="0" cellspacing="0" class="tablafondo" align="center">
<html:form action="consultaHaberesP001.do" >
<tr>
<td>
<span class="error"><html:errors property="errores" /> </span>
<br><br></td>
</tr>
     <tr>
	 <td align="center">
       
         <table width="318" border="0" cellpadding="10" cellspacing="0" class="tabla2">
           <tr>
              <td width="50%" height="37"> 
                <span class="texto"> N&uacute;mero de Documento :</span>
              </td>
              <td width="50%"> 
               <html:text property="documento"  size="8" maxlength="8" />    
              </td>
           </tr>
            <tr>
              <td width="50%" height="37"> 
                <span class="texto"> Secuencia :</span>
              </td>
              <td width="50%"> 
               <html:text property="secuencia"  size="3" maxlength="3" />    
              </td>
           </tr>
           <tr>
             <td width="50%"> 
              <span class="texto"> Período a Consultar :</span></td>
         <td width="50%"> 
           <html:select property="selectFdesde">
             <html:options property="conjFdesde"/> 
            </html:select>           </td>
         </tr>
                    <tr>
             <td width="50%"> 
              <span class="texto">Recuperar Solo Documento Ingresado</span></td>
         <td width="50%"> 
			<html:checkbox property="checkCD"  />
           </td>
         </tr>
         
         
         
         
         	
       </table>       
         <br><br><br>
	   </td>
	 </tr> 
	 

     	<tr>   
		<td align="center">
	      
	        <table width="500" class="tabla3">
	          <tr> 
	            <td> 
	              <div align="center"> <span class="textwhite"> 
                  Para el documento menor que 10.000.000 ingrese el sexo delante del número - <br>
                  Solo para períodos mayores a 1999.
                  <br>
                  Sexo
	                F: femenino
	                M: masculino
                  <br>	                
	              Solo ingrese secuencia si desea una busqueda puntual  
                </span></div>        </td>
          </tr>
  </table>
  <br><br>
          </td>
		</tr>
     <tr>   
	   <td align="center">
		<table width="303">
		<td width="144">
		 <html:image page="/images/aceptar.gif"  property="aceptarButton"/> </td>   
        <td width="147"><html:image page="/images/buscarapellido.gif"  property="buscarButton" /></td>    
       </table>
	   <br><br><br><br><br><br>
       </td>
    </tr>

</html:form>
</html>
<%@include file="/jsps/footer.jsp" %>
</table>
