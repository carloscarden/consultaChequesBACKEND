/*
 * Created on Nov 16, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package reglaNegocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CambDoc;
import model.CambDocPer;
import model.ChequesParaImprimir;
import model.DatPer;
import model.Dep;
import model.DetCheque;
import model.DetCodigo;
import model.DetPeriodo;
import model.Ecargo;
import model.Estab;
import model.HibernateUtil;
import model.Org;
import model.Pers;
import model.Rev;
import model.VDetalle;
import model.VEDetalle;
import model.VEInfoCheq;
import model.VInfoCheq;

public class ReglaNegocio {
	Vector vParaImprimir = new Vector();

	public ReglaNegocio() {
		super();
	}

	public ArrayList cargoFecha() {
		ArrayList al = new ArrayList();
		String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String año = fecha.substring(0, 4);
		
		int fechaCombo = Integer.parseInt(año);
		for (int i = 1991; i <= Integer.parseInt(año); i++) {
			al.add(String.valueOf(fechaCombo));
			fechaCombo--;
		}

		return al;
	}

	public void cargarEstabPorDocumento(Vector vPersonas,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		PreparedStatement st = null;
		Connection conn = null;
		try {
			conn = HibernateUtil.currentSession().connection();
			String query = "select  *  from (select distinct p.nombre,p.docu, e.dependencia, d.distrito,d.descripcion , e.tipo_org, e.numero, c.reg ,'v' prov"
					+ " from( ((dge.cargo c inner join dge.pers p on c.pin=p.pin)"
					+ " inner join dge.estab e on e.escuid = c.escuid) inner join dge.distrito d on d.distrito = e.distrito)"
					+ " where p.docu = ? and p.vigh = '01/12/9999'  and c.vigh = '01/12/9999'  and e.vigh = '01/12/9999'"
					+ " union "
					+ " select distinct apynom nombre,docu,0 dependencia, dist distrito, d1.descripcion, ' '  tipo_org, escue numero,' ' reg ,   'e' prov"
					+ " from dge.ecargo e1 inner join dge.distrito d1 on d1.distrito = e1.dist where e1.docu = ? ) as tt order by prov desc fetch first 1 rows only";
			st = conn.prepareStatement(query);

			for (int i = 0; i < vPersonas.size(); i++) {
				DatPer pers = (DatPer) vPersonas.get(i);
				obtenerDatosEstab(pers, st);
			}

			st.close();
			session.setAttribute("resulpersonas", vPersonas);
			HibernateUtil.closeSession();
		} catch (Exception e) {
			try {
				st.close();
				HibernateUtil.closeSession();
			} catch (Exception e1) {

			}
		}

	}

	public void obtenerDatosEstab(DatPer pers, PreparedStatement st)
			throws Exception {

		ResultSet rs = null;
		try {
			st.setString(1, pers.getDocumento());
			st.setString(2, pers.getDocumento());
			rs = st.executeQuery();

			if (rs.next()) {
				pers.setDependencia(rs.getInt("dependencia"));
				pers.setDescDistrito(rs.getString("descripcion"));
				pers.setNumDistrito(rs.getInt("distrito"));
				pers.setTipo_org(rs.getString("tipo_org"));
				pers.setEscuela(rs.getInt("numero"));
				pers.setReg(rs.getString("reg"));
			}
			rs.close();

		} catch (Exception e) {
			rs.close();
		}
	}

	public Vector obtenerPersonas(String apyn, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		factory.dao.DAOFactory dao = new factory.impl.ImplementationDAOFactory();
		ArrayList conjPersonas = dao.getPersDAO().readAll(apyn);
		ArrayList conjEcargos = dao.getEcargoDAO().readApyn(apyn);

		Vector vpersonas = new Vector();
		Vector vdocumento = new Vector();

		for (int i = 0; i < conjPersonas.size(); i++) {
			Pers p = (Pers) conjPersonas.get(i);
			DatPer dp = new DatPer();
			dp.setApellido(p.getNombre());
			dp.setDocumento(p.getDocu());
			vpersonas.addElement(dp);
			vdocumento.addElement(p.getDocu());
		}

		for (int i = 0; i < conjEcargos.size(); i++) {
			Ecargo e = (Ecargo) conjEcargos.get(i);
			String documento = e.getDocu();
			DatPer dp = new DatPer();
			dp.setApellido(e.getApynom());
			dp.setDocumento(documento);
			if (documento.startsWith("0")) {
				String documentof = "F";
				documentof = documentof + e.getDocu().substring(1, 8);

				String documentom = "M";
				documentom = documentom + e.getDocu().substring(1, 8);

				if (!vdocumento.contains(documentof)
						&& !vdocumento.contains(documentom))
					vpersonas.addElement(dp);
			} else {
				if (!vdocumento.contains(documento))
					vpersonas.addElement(dp);
			}
		}
		return vpersonas;

	}

	public void obtenerCheques(ArrayList vcdoc, String documento,
			String secuencia, String anio, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		factory.dao.DAOFactory dao = new factory.impl.ImplementationDAOFactory();
		Vector vcheques = new Vector();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

		if (Integer.parseInt(anio) > 1999) {
			for (int j = 0; j < vcdoc.size(); j++) {
				CambDocPer cdp = new CambDocPer();
				cdp = (CambDocPer) vcdoc.get(j);
				ArrayList conjCheques = dao.getVInfoCheqDAO().readAll(
						cdp.getDocumento(), secuencia, cdp.getPeriodo());

				for (int i = 0; i < conjCheques.size(); i++) {
					VInfoCheq cheq = (VInfoCheq) conjCheques.get(i);
					DetPeriodo dp = new DetPeriodo();
					String fecha = String.valueOf(cheq.getPerOpago())
							.substring(0, 4)
							+ "/"
							+ String.valueOf(cheq.getPerOpago())
									.substring(4, 6);
					dp.setPeriodo(fecha);
					dp.setDocumento(cheq.getDocu());
					dp.setSecuencia(String.valueOf(cheq.getSecu()));
					fecha = String.valueOf(cheq.getFecAfec()).substring(0, 4)
							+ "/"
							+ String.valueOf(cheq.getFecAfec()).substring(4, 6);

					dp.setFechaafec(fecha);
					dp.setApellido(cheq.getNombrePers());
					dp.setFoja("0");
					dp.setCargo("0");
					dp.setDep(cheq.getDependencia().getDescr());
					dp.setDis(cheq.getNombreDistrito());
					dp.setTor(cheq.getTipoOrg().getDescr());
					dp.setEscu(String.valueOf(cheq.getNumero()));

					/*
					 * cargo establecimiento designado
					 */

					if ((cheq.getEscuidEscart() != null)
							&& (cheq.getEscuidEscart().intValue() == cheq
									.getEscuid())) {
						dp.setDep(cheq.getDependencia().getDescr());
						dp.setDis(cheq.getNombreDistrito());
						dp.setTor(cheq.getTipoOrg().getDescr());
						dp.setEscu(String.valueOf(cheq.getNumero()));
					}
					/*
					 * cargo establecimiento interino
					 */
					if (cheq.getEscuidInt() != null) {
						if (cheq.getEscuidCheque() == cheq.getEscuidInt()
								.intValue()) {
							Dep dep = (Dep) dao.getDepDAO().read(
									cheq.getDependenciaInt().intValue());
							dp.setDep(dep.getDescr());
							dp.setDis(cheq.getNomDistInt());
							Org org = (Org) dao.getOrgDAO().read(
									cheq.getTipoOrgInt());
							dp.setTor(org.getDescr());
							dp.setEscu(String.valueOf(cheq.getNumeroInt()));
						}
					}
					dp.setOpag(String.valueOf(cheq.getOpid()));
					dp.setDopag(String.valueOf(cheq.getOpid()) + " - "
							+ cheq.getNombreOpago());
					dp.setNrocheq(String.valueOf(cheq.getNroCheq()));
					dp.setLiquido(String.valueOf(cheq.getLiquido()));
					dp.setFecafec(String.valueOf(cheq.getFecAfec()));
					dp.setCat(cheq.getCat().getCat());

					if (cheq.getFpago() != null)
						dp.setFpago(sd.format(((cheq.getFpago()))));

					vcheques.addElement(dp);
				}
			}
		} else {
			ArrayList conjECheques = dao.getVEInfoCheqDAO().readAll(documento,
					secuencia, anio);
			for (int i = 0; i < conjECheques.size(); i++) {
				VEInfoCheq cheq = (VEInfoCheq) conjECheques.get(i);

				DetPeriodo dp = new DetPeriodo();
				String fecha = String.valueOf(cheq.getPerOpago()).substring(0,
						4)
						+ "/"
						+ String.valueOf(cheq.getPerOpago()).substring(4, 6);
				dp.setPeriodo(fecha);
				dp.setDocumento(cheq.getDocu());
				dp.setSecuencia(String.valueOf(cheq.getSecu()));
				dp.setFechaafec(" ");
				dp.setApellido(cheq.getNombrePers());
				dp.setFoja(String.valueOf(cheq.getFoja()));
				dp.setCargo(String.valueOf(cheq.getCargo()));

				dp.setDep("OFICIAL");
				dp.setDis(cheq.getNombreDistrito());
				dp.setTor(" ");
				dp.setEscu(String.valueOf(cheq.getNumero()));

				dp.setOpag(String.valueOf(cheq.getOpid()));
				dp.setDopag(String.valueOf(cheq.getOpid()) + " - "
						+ cheq.getNombreOpago());
				dp.setNrocheq(String.valueOf(cheq.getNroCheq()));
				dp.setLiquido(String.valueOf(cheq.getLiquido()));
				dp.setCat(cheq.getCat());
				dp.setApart(String.valueOf(cheq.getApart()));
				dp.setItem(String.valueOf(cheq.getItem()));
				vcheques.addElement(dp);
			}

		}

		session.setAttribute("cheques", vcheques);
	}

	public void obtenerDetalleChequeParaImp(Vector cheques, String[] check)
			throws Exception {
		for (int i = 0; i < check.length; i++) {
			String element = check[i];

			int j = Integer.parseInt(element);
			DetPeriodo dp = (DetPeriodo) cheques.elementAt(j);
			String fecha = dp.getPeriodo().substring(0, 4)
					+ dp.getPeriodo().substring(5, 7);
			obtenerDetalleCheque(dp.getDocumento(), dp.getSecuencia(), fecha,
					dp.getFecafec(), dp.getOpag(), dp.getNrocheq(), dp.getCat(),dp.getCargo(),
					dp.getItem(),dp.getApart(),dp.getEscu());
		}

	}

	public void obtenerDetalleCheque(String documento, String secuencia,
			String fecha, String fecAfec, String opid, String nroCheq,
			String cat, String cargo,String item, String apart,String numero) throws Exception {

		factory.dao.DAOFactory dao = new factory.impl.ImplementationDAOFactory();
		Vector vcheques = new Vector();
		DetCheque dc = new DetCheque();
		Vector vcodigos = new Vector();
		String anio = fecha.substring(0, 4);
		int fechaAfec;
		if (fecAfec != null)
			fechaAfec = Integer.parseInt(fecAfec);
		else
			fechaAfec = 0;
		int numeroCheque;
		if (nroCheq != null)
			numeroCheque = Integer.parseInt(nroCheq);
		else
			numeroCheque = 0;

		
		
		int ordenPago = Integer.parseInt(opid);
		int secu = Integer.parseInt(secuencia);
		if (Integer.parseInt(anio) > 1999) {
			VInfoCheq cheq = (VInfoCheq) dao.getVInfoCheqDAO().read(documento,
					secu, fecha, fechaAfec, ordenPago, numeroCheque);
			/*
			 * cargo parte comun
			 */

			String str = String.valueOf(cheq.getPerOpago()).substring(0, 4)
					+ "/" + String.valueOf(cheq.getPerOpago()).substring(4, 6);
			dc.setPeriodo(str);
			dc.setFechaAfec(String.valueOf(fechaAfec));
			dc.setDocumento(cheq.getDocu());
			dc.setSecuencia(String.valueOf(cheq.getSecu()));
			dc.setApellidoNombre(cheq.getNombrePers());
			dc.setFoja("0");
			dc.setCargo("0");
			dc.setOpid(String.valueOf(cheq.getOpid()));
			dc.setDopag(cheq.getNombreOpago());
			dc.setAntiguedad(cheq.getAntig());
			dc.setReg(cheq.getReg().getDescr());
			dc.setRev(cheq.getRev().getDescr());
			dc.setNrocheq(String.valueOf(cheq.getNroCheq()));
			dc.setMovilidad(cheq.getMovilidad());
			dc.setPresentismo(cheq.getPresentismo());
			dc.setInasistencias(String.valueOf(cheq.getInas()));
			dc.setLiquido(String.valueOf(cheq.getLiquido()));
			dc.setFpago(String.valueOf(cheq.getFpago()));
			dc.setSexo(cheq.getSexo());
			if (cheq.getPerOpago() < 200501) {
				if (cheq.getTipoCheque().equals("N")
						|| cheq.getTipoCheque().equals("D")
						|| cheq.getTipoCheque().equals("O")) {
					dc.setNopagado("NO");
				} else {
					dc.setNopagado("SI");
				}
			} else
				dc.setNopagado("  ");

			/*
			 * cargo parte real
			 */

			dc.setItem(String.valueOf(cheq.getItem()));
			dc.setApartado(String.valueOf(cheq.getApart()));

			dc.setRural_r(String.valueOf(cheq.getRural()));
			dc.setCategoria_r(cheq.getCat().getCat());

			dc.setSecciones_r(String.valueOf(cheq.getSecciones()));
			dc.setTurnos_r(String.valueOf(cheq.getTurnos()));
			dc.setHs_r(String.valueOf(cheq.getHs()));

			/*
			 * cargo establecimiento designado
			 */
			dc.setDep_r(String.valueOf(cheq.getDependencia().getDep()));
			dc.setDisNro_r(String.valueOf(cheq.getDistrito()));
			dc.setDisNombre_r(cheq.getNombreDistrito());
			dc.setTor_r(cheq.getTipoOrg().getOrg());
			dc.setEscu_r(String.valueOf(cheq.getNumero()));
			dc.setCaracteristicas_r(cheq.getCcticas());
			dc.setCodMov_r(cheq.getCodMov());
			dc.setDobleEscolaridadCargo_r("N");
			if (cheq.getDobEscolCargo().equals("1"))
				dc.setDobleEscolaridadCargo_r("S");
			
			dc.setDobleEscolaridadEstab_r("N");
			for (int i = 0; i < cheq.getCcticas().length(); i++) {
				if (cheq.getCcticas().substring(i, i + 1).equals("C")
						|| cheq.getCcticas().substring(i, i + 1).equals("U")||
				   cheq.getCcticas().substring(i, i + 1).equals("O")
					    || cheq.getCcticas().substring(i, i + 1).equals("K")||
				   cheq.getCcticas().substring(i, i + 1).equals("J")
						|| cheq.getCcticas().substring(i, i + 1).equals("I")||
				   cheq.getCcticas().substring(i, i + 1).equals("L")
						|| cheq.getCcticas().substring(i, i + 1).equals("M")||
				   cheq.getCcticas().substring(i, i + 1).equals("N")
						|| cheq.getCcticas().substring(i, i + 1).equals("9"))
					dc.setDobleEscolaridadEstab_r("S");
			}
			dc.setSubvencion_r(String.valueOf(cheq.getSubvencion()));

			/*
			 * cargo parte int
			 */
			if (cheq.getEscuidInt() != null) {
				dc.setRural_i(String.valueOf(cheq.getRuralInt()));
				dc.setCategoria_i(cheq.getCatInt());
				dc.setSecciones_i(String.valueOf(cheq.getSeccionesInt()));
				dc.setTurnos_i(String.valueOf(cheq.getTurnosInt()));
				dc.setHs_i(String.valueOf(cheq.getHsInt()));

				/*
				 * cargo establecimiento interino
				 */

				Dep dep = (Dep) dao.getDepDAO().read(
						cheq.getDependenciaInt().intValue());
				dc.setDep_i(String.valueOf(dep.getDep()));
				dc.setDisNro_i(String.valueOf(cheq.getDistritoInt()));
				dc.setDisNombre_i(cheq.getNomDistInt());
				Org org = (Org) dao.getOrgDAO().read(cheq.getTipoOrgInt());
				dc.setTor_i(org.getOrg());
				dc.setEscu_i(String.valueOf(cheq.getNumeroInt()));
				dc.setCaracteristicas_i(cheq.getCcticasInt());
				dc.setCodMov_i(cheq.getCodMovInt());
				dc.setDobleEscolaridadCargo_i("N");
				if (cheq.getDobEscolInt().equals("1"))
					dc.setDobleEscolaridadCargo_i("S");

				dc.setDobleEscolaridadEstab_i("N");
				for (int i = 0; i < cheq.getCcticasInt().length(); i++) {
					if (cheq.getCcticasInt().substring(i, i + 1).equals("C")
							|| cheq.getCcticasInt().substring(i, i + 1).equals("U")||
					   cheq.getCcticasInt().substring(i, i + 1).equals("O")
						    || cheq.getCcticasInt().substring(i, i + 1).equals("K")||
					   cheq.getCcticasInt().substring(i, i + 1).equals("J")
							|| cheq.getCcticasInt().substring(i, i + 1).equals("I")||
					   cheq.getCcticasInt().substring(i, i + 1).equals("L")
							|| cheq.getCcticasInt().substring(i, i + 1).equals("M")||
					   cheq.getCcticasInt().substring(i, i + 1).equals("N")
							|| cheq.getCcticasInt().substring(i, i + 1).equals("9"))
						dc.setDobleEscolaridadEstab_i("S");
				}

				dc.setSubvencion_i(String.valueOf(cheq.getSubvencionInt()));
			}

			/*
			 * cargo establecimiento articulado
			 */

			if (cheq.getEscuidEscart() != null) {
				Estab estab = (Estab) dao.getEstabDAO().read(
						cheq.getEscuidEscart().intValue(), cheq.getVigOpago());
				dc.setDep_a(String.valueOf(estab.getDependencia().getDep()));
				dc.setDisNombre_a(estab.getDistrito().getDescripcion());
				dc.setDisNro_a(String
						.valueOf(estab.getDistrito().getDistrito()));
				dc.setTor_a(estab.getTipo_org().getOrg());
				dc.setEscu_a(String.valueOf(estab.getNumero()));
				dc.setRural_a(String.valueOf(estab.getRural()));
				dc.setDobleEscolaridadCargo_i("N");
				dc.setDobleEscolaridadEstab_a(dc.getDobleEscolaridadEstab_r());
				dc.setSubvencion_a(String.valueOf(estab.getSubvencion()));
			}

			/*
			 * cargo codigos e importes del cheque
			 */

			ArrayList det = dao.getVDetalleDAO().readAll(cheq.getLiqid());
			if (det.size() == 0) {
				ChequesParaImprimir cpi = new ChequesParaImprimir();
				cpi.setCodigosCheque(null);
				cpi.setDetalleCheque(dc);
				vParaImprimir.add(cpi);
			}
			for (int i = 0; i < det.size(); i++) {
				VDetalle edet = (VDetalle) det.get(i);
				if (Integer.parseInt(edet.getCodigo()) < 3000) {
					DetCodigo dcod = new DetCodigo();
					dcod.setCodigo(edet.getBod() + edet.getCodigo());
					dcod.setDescripcion(edet.getDescripcioncodigo());
					dcod.setImporte(String.valueOf(edet.getPesos()));
					ChequesParaImprimir cpi = new ChequesParaImprimir();
					cpi.setCodigosCheque(dcod);
					cpi.setDetalleCheque(dc);
					vParaImprimir.add(cpi);
				}
			}

		} else {
			VEInfoCheq cheq = (VEInfoCheq) dao.getVEInfoCheqDAO().read(
					documento, secu, ordenPago, fecha, nroCheq, cat,cargo,item,apart,numero);
			String str = String.valueOf(cheq.getPerOpago()).substring(0, 4)
					+ "/" + String.valueOf(cheq.getPerOpago()).substring(4, 6);
			dc.setPeriodo(str);
			dc.setDocumento(cheq.getDocu());
			dc.setSecuencia(String.valueOf(cheq.getSecu()));
			dc.setApellidoNombre(cheq.getNombrePers());
			dc.setFoja(String.valueOf(cheq.getFoja()));
			dc.setCategoria_r(cheq.getCat());

			// Agregado por reclamo de MM docu 10078295, solo cuando la
			// secuencia sea 0-- DPP
			if (((cheq.getApart() >= 6) && (cheq.getApart() <= 9))
					|| ((cheq.getApart() >= 20) && (cheq.getApart() <= 24))) {
				if (cheq.getSecu() == 0) {
					try {
						if (Integer.parseInt(cheq.getCat()) > 0) {
							dc.setCategoria_r("PF");
							dc.setHs_r(cheq.getCat());
						}
					} catch (Exception e) {
						dc.setCategoria_r(cheq.getCat());
					}
				} else
					dc.setCategoria_r(cheq.getCat());
			}

			dc.setCargo(String.valueOf(cheq.getCargo()));

			dc.setAntiguedad(cheq.getAntig());

			Rev rev = (Rev) dao.getRevDAO().read(cheq.getCaracRevOpago());
			if (rev == null)
				dc.setRev(cheq.getCaracRevOpago());
			else
				dc.setRev(rev.getDescr());
			dc.setDopag(cheq.getNombreOpago());
			dc.setOpid(String.valueOf(cheq.getOpid()));
			dc.setNrocheq(String.valueOf(cheq.getNroCheq()));
			dc.setLiquido(String.valueOf(cheq.getLiquido()));
			dc.setFpago(String.valueOf(cheq.getFpago()));

			if (cheq.getEmitirCheq().equals("N")
					|| cheq.getEmitirCheq().equals("D")
					|| cheq.getEmitirCheq().equals("O")) {
				dc.setNopagado("NO");
			} else {
				dc.setNopagado("SI");
			}
			/*
			 * cargo parte real
			 */

			dc.setDep_r("0");
			dc.setDisNombre_r(cheq.getNombreDistrito());
			dc.setTor_r(" ");
			dc.setEscu_r(String.valueOf(cheq.getNumero()));
			dc.setDisNro_r(String.valueOf(cheq.getDistrito()));
			dc.setItem(String.valueOf(cheq.getItem()));
			dc.setApartado(String.valueOf(cheq.getApart()));

			/*
			 * cargo codigos e importes del cheque
			 */

			ArrayList det = dao.getVEDetalleDAO().readAll(cheq.getLiqid(),
					cheq.getPerOpago());
			if (det.size() == 0) {
				ChequesParaImprimir cpi = new ChequesParaImprimir();
				cpi.setCodigosCheque(null);
				cpi.setDetalleCheque(dc);
				vParaImprimir.add(cpi);
			}

			for (int i = 0; i < det.size(); i++) {
				VEDetalle edet = (VEDetalle) det.get(i);
				if (Integer.parseInt(edet.getCodigo()) < 3000) {
					DetCodigo dcod = new DetCodigo();
					dcod.setCodigo(edet.getBod() + edet.getCodigo());
					dcod.setDescripcion(edet.getDescripcioncodigo());
					dcod.setImporte(String.valueOf(edet.getPesos()));
					ChequesParaImprimir cpi = new ChequesParaImprimir();
					cpi.setCodigosCheque(dcod);
					cpi.setDetalleCheque(dc);
					vParaImprimir.add(cpi);

				}
			}
		}
	}

	public ArrayList obtenerCambDoc(String documento, String anio,HttpServletRequest request, HttpServletResponse response, boolean cambioDocumento)
			throws Exception {
		
		HttpSession session = request.getSession();

		factory.dao.DAOFactory dao = new factory.impl.ImplementationDAOFactory();
		ArrayList<CambDocPer> result = new ArrayList<CambDocPer>();
		Vector vpersonas = new Vector();
		ArrayList cdocfinal = dao.getCambDocDAO().readAllFinal(documento);
		

		// Recupero Solo Documento Ingresado
		if(cambioDocumento){
			for (int i = 1; i < 13; i++) {
				CambDocPer cdocper = new CambDocPer();
				cdocper.setDocumento(documento);
				NumberFormat nf = NumberFormat.getIntegerInstance();
				nf.setMinimumIntegerDigits(2);
				nf.setMaximumIntegerDigits(2);
				cdocper.setPeriodo(anio + nf.format(new Integer(i)));
				result.add(cdocper);
			}

		}else{
		
		
		if (cdocfinal.size() == 0) {
			ArrayList cdocintermedio = dao.getCambDocDAO().readAllIntermedio(documento);
			for (int i = 0; i < cdocintermedio.size(); i++) {
				CambDoc cdoc = (CambDoc) cdocintermedio.get(i);
				int puntsig = cdoc.getIdcambdoc();

				while (puntsig != 0) {
					cdoc = (CambDoc) dao.getCambDocDAO().read(puntsig);
					puntsig = cdoc.getIdsig();
				}
				if (cdoc != null) {
					Pers pers = (Pers) dao.getPersDAO().read(cdoc.getDocunew());
					DatPer dp = new DatPer();
					dp.setApellido(pers.getNombre());
					dp.setDocumento(pers.getDocu());

					if (!vpersonas.contains(dp)) {
						vpersonas.addElement(dp);
					}
				}
			}

			if (vpersonas.size() == 0) {
				/*
				 * caso 3 : docu. ingresado sin cambio de documento
				 */
				for (int i = 1; i < 13; i++) {
					CambDocPer cdocper = new CambDocPer();
					cdocper.setDocumento(documento);
					NumberFormat nf = NumberFormat.getIntegerInstance();
					nf.setMinimumIntegerDigits(2);
					nf.setMaximumIntegerDigits(2);
					cdocper.setPeriodo(anio + nf.format(new Integer(i)));
					result.add(cdocper);
				}
			}
		} else {

			/*
			 * caso 1 : encontro el docu. ingresado como fin de la tabla en
			 * cambdoc
			 */
			for (int i = 0; i < cdocfinal.size(); i++) {
				CambDoc cdoc = (CambDoc) cdocfinal.get(i);
				int puntant = cdoc.getIdcambdoc();
				do {

					for (int j = 1; j < 13; j++) {
						NumberFormat nf = NumberFormat.getIntegerInstance();
						nf.setMinimumIntegerDigits(2);
						nf.setMaximumIntegerDigits(2);

						int fecha = Integer.parseInt(anio
								+ nf.format(new Integer(j)) + "01");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
						int vigd = Integer.parseInt(sdf.format(cdoc.getVigd()));
						int vigh = Integer.parseInt(sdf.format(cdoc.getVigh()));

						// Este IF estaba comentado, es decir siempre trataba de
						// insertarlo en resul
						// a partir de 06/07/2007 lo descomente por un reclamo
						// (24040932) DPP

						// Nueva modificacion a partir de 01/01/2008 para q si o
						// si inserte el documento
						// ingresado , por reclamo (16862324)

						if (documento.equals(cdoc.getDocunew())) {
							CambDocPer cdocper = new CambDocPer();
							cdocper.setDocumento(cdoc.getDocunew());
							cdocper.setPeriodo(String.valueOf(fecha).substring(
									0, 6));
							if (!result.contains(cdocper)) {
								result.add(cdocper);
							}

						} 
						else if ((fecha >= vigd) && (fecha <= vigh)) {
							CambDocPer cdocper = new CambDocPer();
							cdocper.setDocumento(cdoc.getDocunew());
							cdocper.setPeriodo(String.valueOf(fecha).substring(
									0, 6));
							if (!result.contains(cdocper)) {
								result.add(cdocper);
							}
						}
					}
					puntant = cdoc.getIdant();
					cdoc = (CambDoc) dao.getCambDocDAO().read(puntant);

				} while (puntant != 0);
			}

		}
		}
		session.setAttribute("resulpersonas", vpersonas);
		return result;
	}

	public Vector getVParaImprimir() {
		return vParaImprimir;
	}

	public void setVParaImprimir(Vector paraImprimir) {
		vParaImprimir = paraImprimir;
	}
}
