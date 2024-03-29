/**
 * 
 */
package br.com.centralit.citcorpore.negocio;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import br.com.centralit.citcorpore.metainfo.bean.CamposObjetoNegocioDTO;
import br.com.centralit.citcorpore.metainfo.bean.ObjetoNegocioDTO;
import br.com.centralit.citcorpore.metainfo.integracao.VisaoDao;
import br.com.centralit.citcorpore.metainfo.negocio.CamposObjetoNegocioService;
import br.com.centralit.citcorpore.metainfo.negocio.ObjetoNegocioService;
import br.com.centralit.citcorpore.metainfo.util.DataBaseMetaDadosUtil;
import br.com.centralit.citcorpore.util.CITCorporeUtil;
import br.com.centralit.citcorpore.util.Enumerados;
import br.com.centralit.citcorpore.util.ParametroUtil;
import br.com.citframework.excecao.LogicException;
import br.com.citframework.excecao.ServiceException;
import br.com.citframework.integracao.CrudDAO;
import br.com.citframework.service.CrudServicePojoImpl;
import br.com.citframework.service.ServiceLocator;
import br.com.citframework.util.SQLConfig;

/**
 * 
 * @author flavio.santana
 *
 */
public class DataBaseMetaDadosServiceEjb  extends CrudServicePojoImpl implements DataBaseMetaDadosService {

	private ObjetoNegocioService objetoNegocioService;
	private CamposObjetoNegocioService camposObjetoNegocioService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected CrudDAO getDao() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void validaCreate(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validaUpdate(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validaDelete(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validaFind(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void corrigeTabelaComplexidade() throws ServiceException, Exception{
		
		List<ObjetoNegocioDTO> respList = (List<ObjetoNegocioDTO>) getObjetoNegocioService().findByNomeTabelaDB("complexidade");
		
		Integer idCampoNegContrato = null;
		Integer idCampoNegComplexidade = null;
		if (respList != null && !respList.isEmpty()) {
			for (ObjetoNegocioDTO objetoNegocioDTO : respList) {
				List<CamposObjetoNegocioDTO> listIdContrato = (List<CamposObjetoNegocioDTO>) getCamposObjetoNegocioService().findByIdObjetoNegocioAndNomeDB(objetoNegocioDTO.getIdObjetoNegocio(),
						"IDCONTRATO");
				for (CamposObjetoNegocioDTO camposObjetoNegocioDTO : listIdContrato) {
					idCampoNegContrato = camposObjetoNegocioDTO.getIdCamposObjetoNegocio();
				}

				List<CamposObjetoNegocioDTO> listComplexidade = (List<CamposObjetoNegocioDTO>) getCamposObjetoNegocioService().findByIdObjetoNegocioAndNomeDB(objetoNegocioDTO.getIdObjetoNegocio(),
						"COMPLEXIDADE");
				for (CamposObjetoNegocioDTO camposObjetoNegocioDTO2 : listComplexidade) {
					idCampoNegComplexidade = camposObjetoNegocioDTO2.getIdCamposObjetoNegocio();
				}

				if (idCampoNegContrato != null && idCampoNegComplexidade != null) {
					getCamposObjetoNegocioService().updateComplexidade(idCampoNegContrato, idCampoNegComplexidade);
				}

			}
		}
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void corrigeTabelaSla() throws ServiceException, Exception{
		
		List<ObjetoNegocioDTO> respList = (List<ObjetoNegocioDTO>) getObjetoNegocioService().findByNomeTabelaDB("SLAREQUISITOSLA");
		
		Integer idCampoNegContrato = null;
		Integer idCampoNegComplexidade = null;
		
		if (respList != null && !respList.isEmpty()) {
			for (ObjetoNegocioDTO objetoNegocioDTO : respList) {
				List<CamposObjetoNegocioDTO> listIdContrato = (List<CamposObjetoNegocioDTO>) getCamposObjetoNegocioService().findByIdObjetoNegocioAndNomeDB(objetoNegocioDTO.getIdObjetoNegocio(),
						"IDREQUISITOSLA");
				for (CamposObjetoNegocioDTO camposObjetoNegocioDTO : listIdContrato) {
					idCampoNegContrato = camposObjetoNegocioDTO.getIdCamposObjetoNegocio();
				}

				List<CamposObjetoNegocioDTO> listComplexidade = (List<CamposObjetoNegocioDTO>) getCamposObjetoNegocioService().findByIdObjetoNegocioAndNomeDB(objetoNegocioDTO.getIdObjetoNegocio(),
						"IDACORDONIVELSERVICO");
				for (CamposObjetoNegocioDTO camposObjetoNegocioDTO2 : listComplexidade) {
					idCampoNegComplexidade = camposObjetoNegocioDTO2.getIdCamposObjetoNegocio();
				}

				if (idCampoNegContrato != null && idCampoNegComplexidade != null) {
					getCamposObjetoNegocioService().updateComplexidade(idCampoNegContrato, idCampoNegComplexidade);
				}

			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void corrigeTabelaFluxoServico() throws Exception {
		List<ObjetoNegocioDTO> respList = (List<ObjetoNegocioDTO>) getObjetoNegocioService().findByNomeTabelaDB("FLUXOSERVICO");
		
		Integer idCampoNegServicoContrato = null;
		Integer idCampoNegIdTipoFluxo = null;
		Integer idCampoNegFase = null;
		
		if (respList != null && !respList.isEmpty()) {
			for (ObjetoNegocioDTO objetoNegocioDTO : respList) {
				List<CamposObjetoNegocioDTO> listIdServicoContrato = (List<CamposObjetoNegocioDTO>) getCamposObjetoNegocioService().findByIdObjetoNegocioAndNomeDB(
						objetoNegocioDTO.getIdObjetoNegocio(), "IDSERVICOCONTRATO");
				for (CamposObjetoNegocioDTO camposObjetoNegocioDTO : listIdServicoContrato) {
					idCampoNegServicoContrato = camposObjetoNegocioDTO.getIdCamposObjetoNegocio();
				}

				List<CamposObjetoNegocioDTO> listTipoFluxo = (List<CamposObjetoNegocioDTO>) getCamposObjetoNegocioService().findByIdObjetoNegocioAndNomeDB(objetoNegocioDTO.getIdObjetoNegocio(),
						"IDTIPOFLUXO");
				for (CamposObjetoNegocioDTO camposObjetoNegocioDTO2 : listTipoFluxo) {
					idCampoNegIdTipoFluxo = camposObjetoNegocioDTO2.getIdCamposObjetoNegocio();
				}

				List<CamposObjetoNegocioDTO> listFase = (List<CamposObjetoNegocioDTO>) getCamposObjetoNegocioService().findByIdObjetoNegocioAndNomeDB(objetoNegocioDTO.getIdObjetoNegocio(), "IDFASE");
				for (CamposObjetoNegocioDTO camposObjetoNegocioDTO2 : listFase) {
					idCampoNegFase = camposObjetoNegocioDTO2.getIdCamposObjetoNegocio();
				}

				if (idCampoNegServicoContrato != null && idCampoNegIdTipoFluxo != null) {
					getCamposObjetoNegocioService().updateFluxoServico(idCampoNegServicoContrato, idCampoNegIdTipoFluxo, idCampoNegFase);
				}
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Collection getDataBaseMetaDadosUtil() throws Exception { 
		DataBaseMetaDadosUtil dataBaseMetaDadosUtil = new DataBaseMetaDadosUtil();
		VisaoDao visaoDao = new VisaoDao();
		Connection con = (Connection) visaoDao.getTransactionControler().getTransactionObject();
		String DB_SCHEMA = ParametroUtil.getValorParametroCitSmartHashMap(Enumerados.ParametroSistema.DB_SCHEMA,"");
		if(CITCorporeUtil.SGBD_PRINCIPAL.equalsIgnoreCase(SQLConfig.SQLSERVER)) {
			DB_SCHEMA = null;
		} else if (DB_SCHEMA == null || DB_SCHEMA.trim().equalsIgnoreCase("")){
		    DB_SCHEMA = "citsmart";
		}
		Collection colObsNegocio = dataBaseMetaDadosUtil.readTables(con, DB_SCHEMA, DB_SCHEMA, null, true);		
		con.close();
		con = null;
		
		return colObsNegocio;
	}
	
	@SuppressWarnings("rawtypes")
	@Deprecated
	public String carregaTodosMetaDados() throws Exception {
		
		DataBaseMetaDadosUtil dataBaseMetaDadosUtil = new DataBaseMetaDadosUtil();
		VisaoDao visaoDao = new VisaoDao();
		Connection con = (Connection) visaoDao.getTransactionControler().getTransactionObject();
		String DB_SCHEMA = ParametroUtil.getValorParametroCitSmartHashMap(Enumerados.ParametroSistema.DB_SCHEMA,"");
		if(CITCorporeUtil.SGBD_PRINCIPAL.equalsIgnoreCase(SQLConfig.SQLSERVER)) {
			DB_SCHEMA = null;
		} else if (DB_SCHEMA == null || DB_SCHEMA.trim().equalsIgnoreCase("")){
		    DB_SCHEMA = "citsmart";
		}

		//Desabilitando as tabelas para garantir que as que n�o existam mais n�o fiquem ativas
		desabilitaTabelas();
		
		Collection colObsNegocio = dataBaseMetaDadosUtil.readTables(con, DB_SCHEMA, DB_SCHEMA, null, true);		
		con.close();
		con = null;
		
		String carregados = "";
		if(!colObsNegocio.isEmpty()) {
			for (Iterator it = colObsNegocio.iterator(); it.hasNext();){
				ObjetoNegocioDTO objetoNegocioDTO = (ObjetoNegocioDTO)it.next();
				
				System.out.println("-----: Objeto de Negocio: " + objetoNegocioDTO.getNomeTabelaDB());
				carregados += objetoNegocioDTO.getNomeTabelaDB() + "<br>";
				
				Collection colObjs = getObjetoNegocioService().findByNomeTabelaDB(objetoNegocioDTO.getNomeTabelaDB());
				if (colObjs == null || colObjs.size() == 0){
					System.out.println("----------: Criando....  " + objetoNegocioDTO.getNomeTabelaDB());
					getObjetoNegocioService().create(objetoNegocioDTO); 
				}else{
					ObjetoNegocioDTO objetoNegocioAux = (ObjetoNegocioDTO)((List)colObjs).get(0);
					objetoNegocioDTO.setIdObjetoNegocio(objetoNegocioAux.getIdObjetoNegocio());
					System.out.println("----------: Atualizando....  " + objetoNegocioDTO.getNomeTabelaDB() + "    Id Interno: " + objetoNegocioAux.getIdObjetoNegocio());
					getObjetoNegocioService().update(objetoNegocioDTO);
				}
			}
			
			corrigeTabelaComplexidade();
			corrigeTabelaSla();
			corrigeTabelaFluxoServico();
			
			carregados = "<b>Finalizado!</b> <br><b>Tabelas carregadas:</b> <br>" + carregados;			
		} else {
			carregados += "N�o foi poss�vel carregar metadados para o Schema:" + DB_SCHEMA;
		}
		
		return carregados;
	}
	
	@SuppressWarnings("rawtypes")
	public String carregaTodosMetaDados(Collection colecao) throws Exception {

		//Desabilitando as tabelas para garantir que as que n�o existam mais n�o fiquem ativas
		desabilitaTabelas();
		
		Collection colObsNegocio = colecao;
		String carregados = "";
			for (Iterator it = colObsNegocio.iterator(); it.hasNext();){
				ObjetoNegocioDTO objetoNegocioDTO = (ObjetoNegocioDTO)it.next();
				
				System.out.println("-----: Objeto de Negocio: " + objetoNegocioDTO.getNomeTabelaDB());
				carregados += objetoNegocioDTO.getNomeTabelaDB() + "<br>";
				
				Collection colObjs = getObjetoNegocioService().findByNomeTabelaDB(objetoNegocioDTO.getNomeTabelaDB());
				if (colObjs == null || colObjs.size() == 0){
					System.out.println("----------: Criando....  " + objetoNegocioDTO.getNomeTabelaDB());
					getObjetoNegocioService().create(objetoNegocioDTO); 
				}else{
					ObjetoNegocioDTO objetoNegocioAux = (ObjetoNegocioDTO)((List)colObjs).get(0);
					objetoNegocioDTO.setIdObjetoNegocio(objetoNegocioAux.getIdObjetoNegocio());
					System.out.println("----------: Atualizando....  " + objetoNegocioDTO.getNomeTabelaDB() + "    Id Interno: " + objetoNegocioAux.getIdObjetoNegocio());
					getObjetoNegocioService().update(objetoNegocioDTO);
				}
			}
			
			corrigeTabelaComplexidade();
			corrigeTabelaSla();
			corrigeTabelaFluxoServico();
			
			carregados = "<b>Finalizado!</b> <br><b>Tabelas carregadas:</b> <br>" + carregados;			
		
		return carregados;
	}
	
	@SuppressWarnings("unchecked")
	public void desabilitaTabelas() throws LogicException, ServiceException, Exception{
		
		List<ObjetoNegocioDTO> listObjetoNegocio = (List<ObjetoNegocioDTO>) getObjetoNegocioService().list();
		
		for (ObjetoNegocioDTO objetoNegocioDTO : listObjetoNegocio) {
			objetoNegocioDTO.setSituacao("I");
			getObjetoNegocioService().updateDisable(objetoNegocioDTO);
		}
		
	}
	
	private ObjetoNegocioService getObjetoNegocioService() throws ServiceException, Exception{
		if(objetoNegocioService == null){
			return (ObjetoNegocioService) ServiceLocator.getInstance().getService(ObjetoNegocioService.class, null);
		}else{
			return objetoNegocioService;
		}
	}
	
	private CamposObjetoNegocioService getCamposObjetoNegocioService() throws ServiceException, Exception {
		if(camposObjetoNegocioService == null){
			return (CamposObjetoNegocioService) ServiceLocator.getInstance().getService(CamposObjetoNegocioService.class, null);
		}else{
			return camposObjetoNegocioService;
		}
	}
	
}
