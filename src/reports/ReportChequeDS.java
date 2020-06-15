package reports;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.SimpleFormatter;

import model.ChequesParaImprimir;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ReportChequeDS implements JRDataSource {
	private int idx;

	private ChequesParaImprimir bean;

	private Vector data;

	public ReportChequeDS(Vector data) {
		this.idx = 0;
		this.data = data;
	}

	public Object getFieldValue(JRField jRField)
			throws JRException {

		String field = jRField.getName();
        
		if (field.equals("periodo".toUpperCase())) {
			return bean.getDetalleCheque().getPeriodo();
	    }	
		if (field.equals("dependencia".toUpperCase())) {
			if (bean.getDetalleCheque().getDep_r() == null) {
	 			   return new Short("0");	
			}
			return new Short(bean.getDetalleCheque().getDep_r());
	    }	
		if (field.equals("dependencia_art".toUpperCase())) {
			if (bean.getDetalleCheque().getDep_a() == null) {
	 			   return new Short("0");	
			}
			return new Short(bean.getDetalleCheque().getDep_a());
	    }	
		if (field.equals("dependencia_int".toUpperCase())){
			if (bean.getDetalleCheque().getDep_i() == null) {
	 			   return new Short("0");	
			}
			return new Short(bean.getDetalleCheque().getDep_i());
		}	
		if (field.equals("tipo_org".toUpperCase()))
			return bean.getDetalleCheque().getTor_r();
		if (field.equals("tipo_org_int".toUpperCase()))
			return bean.getDetalleCheque().getTor_i();
		if (field.equals("tipo_org_art".toUpperCase()))
			return bean.getDetalleCheque().getTor_a();
		
		if (field.equals("distrito".toUpperCase())) {
			if (bean.getDetalleCheque().getDisNro_r() == null) {
 			   return new Short("0");	
			}
			return new Short(bean.getDetalleCheque().getDisNro_r());
		}
		if (field.equals("distrito_art".toUpperCase())) {
			if (bean.getDetalleCheque().getDisNro_a() == null) {
 			   return new Short("0");	
			}
			return new Short(bean.getDetalleCheque().getDisNro_a());
		}
		if (field.equals("distrito_int".toUpperCase())) {
			if (bean.getDetalleCheque().getDisNro_i() == null) {
 			   return new Short("0");	
			}
			return new Short(bean.getDetalleCheque().getDisNro_i());
		}
		
		if (field.equals("nombre_distrito".toUpperCase()))
			return bean.getDetalleCheque().getDisNombre_r();
		if (field.equals("nombre_distrito_art".toUpperCase()))
			return bean.getDetalleCheque().getDisNombre_a();
		if (field.equals("nom_dist_int".toUpperCase()))
			return bean.getDetalleCheque().getDisNombre_i();
		
		if (field.equals("numero".toUpperCase())) {
			if (bean.getDetalleCheque().getEscu_r() == null) {
				return new Short("0"); 
			}
			return new Short(bean.getDetalleCheque().getEscu_r());
	    }	
		if (field.equals("numero_art".toUpperCase())) {
			if (bean.getDetalleCheque().getEscu_a() == null) {
				return new Short("0"); 
			}
			return new Short(bean.getDetalleCheque().getEscu_a());
    	}	
		if (field.equals("numero_int".toUpperCase())) {
			if (bean.getDetalleCheque().getEscu_i() == null) {
				return new Short("0"); 
			}
			return new Short(bean.getDetalleCheque().getEscu_i());
		}	
		if (field.equals("turnos".toUpperCase())) {
			if (bean.getDetalleCheque().getTurnos_r() == null) {
				return new Short("0"); 
			}
			return new Short(bean.getDetalleCheque().getTurnos_r());
		}	
		if (field.equals("turnos_int".toUpperCase())) {
			if (bean.getDetalleCheque().getTurnos_i() == null) {
				return new Short("0"); 
			}
			return new Short(bean.getDetalleCheque().getTurnos_i());
		}	
		if (field.equals("cod_mov".toUpperCase()))
			return bean.getDetalleCheque().getCodMov_r();
		if (field.equals("cod_mov_int".toUpperCase()))
			return bean.getDetalleCheque().getCodMov_i();
		if (field.equals("secciones".toUpperCase())) {
		    if (bean.getDetalleCheque().getSecciones_r() == null) {
		    	return new Short("0");
			}	
			return new Short(bean.getDetalleCheque().getSecciones_r());
		}	
		if (field.equals("secciones_int".toUpperCase())) {
		    if (bean.getDetalleCheque().getSecciones_i() == null) {
		    	return new Short("0");
			}	
			return new Short(bean.getDetalleCheque().getSecciones_i());
		}
		if (field.equals("rural".toUpperCase())) {
		    if (bean.getDetalleCheque().getRural_r() == null) {
		    	return new Short("0");
			}	
			return new Short(bean.getDetalleCheque().getRural_r());
		}
		if (field.equals("rural_art".toUpperCase())) {
		    if (bean.getDetalleCheque().getRural_a() == null) {
		    	return new Short("0");
			}	
			return new Short(bean.getDetalleCheque().getRural_a());
		}	
		if (field.equals("rural_int".toUpperCase())) {
		    if (bean.getDetalleCheque().getRural_i() == null) {
		    	return new Short("0");
			}	
			return new Short(bean.getDetalleCheque().getRural_i());
		}	
		if (field.equals("ccticas".toUpperCase()))
			return bean.getDetalleCheque().getCaracteristicas_r();
		if (field.equals("ccticas_int".toUpperCase()))
			return bean.getDetalleCheque().getCaracteristicas_i();
		
		if (field.equals("dob_escol_escu".toUpperCase())) 
			return bean.getDetalleCheque().getDobleEscolaridadEstab_r();
		
		if (field.equals("dob_escol_escu_int".toUpperCase())) 
			return bean.getDetalleCheque().getDobleEscolaridadEstab_i();
		
		if (field.equals("dob_escol_escu_a".toUpperCase())) 
			return bean.getDetalleCheque().getDobleEscolaridadEstab_a();
		
		
		if (field.equals("dob_escol_int".toUpperCase())) 
			return bean.getDetalleCheque().getDobleEscolaridadCargo_i();
		if (field.equals("dob_escol_cargo".toUpperCase()))
			return bean.getDetalleCheque().getDobleEscolaridadCargo_r();
		if (field.equals("fecafec".toUpperCase())) {
		    if (bean.getDetalleCheque().getFechaAfec() == null) {
		    	return "      ";
			}	
			return bean.getDetalleCheque().getFechaAfec();
		}	
		if (field.equals("apynom".toUpperCase()))
			return bean.getDetalleCheque().getApellidoNombre();
		if (field.equals("sexo".toUpperCase()))
			return bean.getDetalleCheque().getSexo();
		if (field.equals("numdoc".toUpperCase()))
			return bean.getDetalleCheque().getDocumento();
		if (field.equals("secu".toUpperCase())) {
			if (bean.getDetalleCheque().getSecuencia() == null) {
				return new Short("0"); 
			}
			return new Short(bean.getDetalleCheque().getSecuencia());
		}	
		if (field.equals("opid".toUpperCase())) {
		    if (bean.getDetalleCheque().getOpid() == null) {
		    	return new Integer(0);
			}	
			return new Integer(bean.getDetalleCheque().getOpid());
		}	
		if (field.equals("nrocheq".toUpperCase())) {
		    if (bean.getDetalleCheque().getNrocheq() == null) {
		    	return new Integer(0);
			}	
			return new Integer(bean.getDetalleCheque().getNrocheq());
	    }	
		if (field.equals("rev".toUpperCase()))
			return bean.getDetalleCheque().getRev();
		if (field.equals("cat".toUpperCase()))
			return bean.getDetalleCheque().getCategoria_r();
		if (field.equals("cat_int".toUpperCase()))
			return bean.getDetalleCheque().getCategoria_i();
		if (field.equals("hs".toUpperCase())) {
			if (bean.getDetalleCheque().getHs_r() == null) {
				return new BigDecimal("0"); 
			}
			return new BigDecimal(bean.getDetalleCheque().getHs_r());
		}	
		if (field.equals("hs_int".toUpperCase())) {
			if (bean.getDetalleCheque().getHs_i() == null) {
				return new BigDecimal("0"); 
			}
			return new BigDecimal(bean.getDetalleCheque().getHs_i());
		}
		if (field.equals("item".toUpperCase())) {
			if (bean.getDetalleCheque().getItem() == null) {
				return new Integer("0"); 
			}
			return new Integer(bean.getDetalleCheque().getItem());
		}	
		if (field.equals("apart".toUpperCase())) {
			if (bean.getDetalleCheque().getApartado() == null) {
				return new Integer("0"); 
			}
			return new Integer(bean.getDetalleCheque().getApartado());
		}	
		if (field.equals("foja".toUpperCase()))
			return bean.getDetalleCheque().getFoja();
		if (field.equals("cargo".toUpperCase()))
			return bean.getDetalleCheque().getCargo();
		if (field.equals("antig".toUpperCase()))
			return bean.getDetalleCheque().getAntiguedad();
		if (field.equals("pesos".toUpperCase())) {
			if (bean.getCodigosCheque() == null) {
				return new BigDecimal("0"); 
			}
			if (bean.getCodigosCheque().getImporte() == null) {
				return new BigDecimal("0"); 
			}
			return new BigDecimal(bean.getCodigosCheque().getImporte());
		}	
		if (field.equals("codigo".toUpperCase())) {
			if (bean.getCodigosCheque() == null) {
				return new String(" "); 
			}
			return bean.getCodigosCheque().getCodigo();
		}	
		if (field.equals("descripcion_codigo".toUpperCase())) {
			if (bean.getCodigosCheque() == null) {
				return new String(" "); 
			}
			return bean.getCodigosCheque().getDescripcion();
		}
		if (field.equals("liquido".toUpperCase())) {
			if (bean.getDetalleCheque().getLiquido() == null) {
				return new BigDecimal("0"); 
			}
			return new BigDecimal(bean.getDetalleCheque().getLiquido());
		}	
		if (field.equals("reg".toUpperCase()))
			return bean.getDetalleCheque().getReg();
		if (field.equals("nombre_opago".toUpperCase()))
			return bean.getDetalleCheque().getDopag();
		if (field.equals("subvencion".toUpperCase())) {
			if (bean.getDetalleCheque().getSubvencion_r() == null) {
				  return new Integer("0");	
			}
			return new Integer(bean.getDetalleCheque().getSubvencion_r());
	    }	
		if (field.equals("subvencion_art".toUpperCase())) {
			if (bean.getDetalleCheque().getSubvencion_a() == null) {
				  return new Integer("0");	
			}
			return new Integer(bean.getDetalleCheque().getSubvencion_a());
	    }	
		if (field.equals("subvencion_int".toUpperCase())) {
			if (bean.getDetalleCheque().getSubvencion_i() == null) {
			  return new Integer("0");	
			}
			return new Integer(bean.getDetalleCheque().getSubvencion_i());
		}
		if (field.equals("nopagado".toUpperCase())) {
			if (bean.getDetalleCheque().getNopagado() == null) {
				return new String(" "); 
			}
			return bean.getDetalleCheque().getNopagado();
		}
		
		
		
			if (field.equals("fpago".toUpperCase())) {
				if (! bean.getDetalleCheque().getFpago().equals("null")) {
					  String fecha = bean.getDetalleCheque().getFpago().substring(0,10);
					  return fecha.substring(8,10)+"/"+fecha.substring(5,7)+"/"+fecha.substring(0,4);
				}	  
			}

		return null; // Column not found... 
	}

	public boolean next() throws JRException {
		try {
			this.bean = (ChequesParaImprimir) this.data.elementAt(this.idx);
			this.idx++;
			return true;
		} catch (Exception ex) {
		}
		return false;
	}


	/**
	 * @return
	 */
	public Vector getData() {
		return data;
	}

	/**
	 * @return
	 */
	public int getIdx() {
		return idx;
	}


	public ChequesParaImprimir getBean() {
		return bean;
	}

	public void setBean(ChequesParaImprimir bean) {
		this.bean = bean;
	}

	/**
	 * @param vector
	 */
	public void setData(Vector vector) {
		data = vector;
	}

	/**
	 * @param i
	 */
	public void setIdx(int i) {
		idx = i;
	}

}
