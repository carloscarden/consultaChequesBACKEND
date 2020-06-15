
<%@include file="/jsps/header.jsp" %>


<table width="760" border="0" cellspacing="0" cellpadding="0" class="tablafondo" align="center">
  <html:form action="consultaHaberesP005.do" >
  <tr>
    <td align="center">
	<br>
   	<span class="error">
     <html:errors property="errores" />
   	</span>
   	<br>
   	</td>
  </tr>
  <tr>
    <td align="center">
	<h4>DATOS PERSONALES</h4> 
   <table width="650px" cellpadding="5" cellspacing="0" class="tabla1">
      <TR>
        <TH width="96">PERIODO</TH>
        <TH width="109">DOCUMENTO</TH>
        <TH width="52">SEC.</TH>
        <TH width="234">NOMBRE</TH>
        <TH width="107">ANTIGUEDAD</TH>
      </TR>   
      <TR>
        <Td align="center" class="td1">
          &nbsp;<bean:write name="detcheques" property="periodo"/>        </td>
        <Td align="center" class="td1">
          &nbsp;<bean:write name="detcheques" property="documento"/>        </td>
        <Td align="center" class="td1">
         &nbsp;<bean:write name="detcheques" property="secuencia"/>        </td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="detcheques" property="apellido"/>        </td>
        <Td align="left" class="td1">
          &nbsp;<bean:write name="detcheques" property="antiguedad"/>        </td>
      </TR>
    </table><br>
	</td>
  </tr>
  <tr>
    <td  align="center">
	<table width="700px" cellpadding="5" cellspacing="0" class="tabla1">
      <TR>
        <TH>REG. ESTAT.</TH>
        <TH>CARAC. REV.</TH>        
		<TH>NRO. CHEQUE</TH>
        <TH>MOVILIDAD</TH>
        <TH>PRESENTISMO</TH>
        <TH>INASISTENCIAS</TH>
        <TH>FOJA</TH> 
        <TH>CARGO</TH> 
      </TR>
      <TR>  
        <Td align="left" class="td1">
          &nbsp;<bean:write name="detcheques" property="reg"/>        </td>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="rev"/>        </td>
        <Td align="right" class="td1">&nbsp;<bean:write name="detcheques" property="nrocheq"/>        </td>
        <Td align="right" class="td1">&nbsp;<bean:write name="detcheques" property="movilidad"/>        </td>
        <Td align="right" class="td1">&nbsp;<bean:write name="detcheques" property="presentismo"/>        </td>
        <Td align="right" class="td1">&nbsp;<bean:write name="detcheques" property="inasistencias"/>        </td>
        <Td align="right" class="td1">&nbsp;<bean:write name="detcheques" property="foja"/>        </td>
        <Td align="right" class="td1">&nbsp;<bean:write name="detcheques" property="cargo"/>        </td>
      </TR>
    </table><br><br> 
	</td>
  </tr>
  <tr>
    <td align="center">
	 <h4>SITUACION REAL E INTERINA</h4> 

    <table width="500" cellpadding="5" cellspacing="0" class="tabla1">
     <TR>
         <Th width="177" align="center">&nbsp;</Th>   
         <Th width="153" align="center">REAL</Th>   
         <Th width="138" align="center">INTERINO</Th>   
      </TR>
      <TR>
        <TH align="left">DEPENDENCIA</TH>
          <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="dep_r"/>         </Td>   
         <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="dep_i"/>         </Td>   
      </TR>
      <TR>
        <TH align="left">DISTRITO</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="dis_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="dis_i"/>        </Td>   
      </TR>
      <TR>
        <TH align="left">TIPO ORGANIZACION</TH>
        <Td align="left" class="td1">&nbsp;
           <bean:write name="detcheques" property="tor_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="tor_i"/>        </Td>   
      </TR>
      <TR>
        <TH align="left">ESCUELA</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="escu_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="escu_i"/>        </Td>   
      </TR>
      <TR>
        <TH align="left">ITEM</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="item_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="item_i"/>        </Td>   
      </TR> 
      <TR>
        <TH align="left">APARTADO</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="apart_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="apart_i"/>        </Td>   
      </TR> 
      <TR>
        <TH align="left">RURAL</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="rural_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="rural_i"/>        </Td>   
      </TR> 
      <TR>
        <TH align="left">CATEGORIA</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="categoria_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="categoria_i"/>        </Td>   
      </TR> 
      <TR>
        <TH align="left">HORAS</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="hs_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="hs_i"/>        </Td>   
      </TR> 
      <TR>
        <TH align="left">SECCIONES</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="secciones_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="secciones_i"/>        </Td>   
      </TR> 
      <TR>
        <TH align="left">TURNOS</TH>
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="turnos_r"/>        </Td>   
        <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="turnos_i"/>        </Td>   
      </TR> 
    </table><br><br> 
	</td>
  </tr>
  <tr>
    <td align="center"><logic:notEqual name ="detcheques" property ="tor_a" value="" >       
    
        <h4>ESTABLECIMIENTO ARTICULADO</h4>
       
    
     <table width="200px" cellpadding="5" cellspacing="0" class="tabla1">   
      <TR>
        <TH align="left">DEPENDENCIA</TH>
          <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="dep_a"/>          </Td>   
      </TR>
      <TR>
        <TH align="left">DISTRITO</TH>
          <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="dis_a"/>          </Td>   
      </TR>
      <TR>
        <TH align="left">TIPO ORGANIZACION</TH>
          <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="tor_a"/>          </Td>   
      </TR>
      <TR>
        <TH align="left">ESCUELA</TH>
          <Td align="left" class="td1">&nbsp;<bean:write name="detcheques" property="escu_a"/>          </Td>   
      </TR>
    </table> </logic:notEqual><br>
	</td>
  </tr>
  <tr>
    <td align="center">
	<h4>ORDEN DE PAGO</h4>
       
   
    <table width="200" border="0" cellpadding="5" cellspacing="0" class="tabla1">
       <TR>
          <Td align="center" class="td1">&nbsp;<bean:write name="detcheques" property="dopag"/>         </Td>   
      </TR>
    </table><br><br>
	</td>
  </tr>
  <tr>
    <td align="center">
	<h4>DETALLE DE HABERES</h4>
        
      
    <table width="500" border="0" cellpadding="0" cellspacing="0" class="tabla1">
    <TR>
      <TH>CODIGO</TH>
      <TH>DESCRIPCION</TH>
      <TH>IMPORTE</TH>
    </tr>
    <logic:iterate id="result" name="detcodigos">
      <TR>
       <Td align="left" class="td1">&nbsp;
         <bean:write name="result" property="codigo"/>       </td>
       <Td align="left" class="td1">&nbsp;
         <bean:write name="result" property="descripcion"/>       </td>  
       <Td align="right" class="td1">&nbsp;
         <bean:write name="result" property="importe"/>       </td>  
    </TR>
    </logic:iterate>      
    </table><br><br>
	</td>
  </tr>
  <tr>
    <td align="center">
	<h4>LIQUIDO</h4>
   
    <table width="250px" cellpadding="5" cellspacing="0" class="tabla1">
       <TR>
         <Td align="center" class="td1">&nbsp;
          <bean:write name="detcheques" property="liquido"/>         </Td>   
       </TR>
    </table><br><br>
	</td>
  </tr>
  <tr>
    <td align="center"><html:image page="/images/aceptar.gif"  property="aceptarButton" /> <br><br></td>
  </tr></html:form>
</table>

    

</html>
<%@include file="/jsps/footer.jsp" %>
