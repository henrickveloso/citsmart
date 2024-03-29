package br.com.centralit.citcorpore.integracao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.centralit.citcorpore.bean.PrioridadeServicoUnidadeDTO;
import br.com.citframework.dto.IDto;
import br.com.citframework.integracao.Condition;
import br.com.citframework.integracao.CrudDaoDefaultImpl;
import br.com.citframework.integracao.Field;
import br.com.citframework.integracao.Order;
import br.com.citframework.util.Constantes;

public class PrioridadeServicoUnidadeDao extends CrudDaoDefaultImpl {
	public PrioridadeServicoUnidadeDao() {
		super(Constantes.getValue("DATABASE_ALIAS"), null);
	}
	public Collection getFields() {
		Collection listFields = new ArrayList();
		listFields.add(new Field("idUnidade" ,"idUnidade", true, false, false, false));
		listFields.add(new Field("idServicoContrato" ,"idServicoContrato", true, false, false, false));
		listFields.add(new Field("idPrioridade" ,"idPrioridade", false, false, false, false));
		listFields.add(new Field("dataInicio" ,"dataInicio", false, false, false, false));
		listFields.add(new Field("dataFim" ,"dataFim", false, false, false, false));
		return listFields;
	}
	public String getTableName() {
		return this.getOwner() + "PrioridadeServicoUnidade";
	}
	public Collection list() throws Exception {
		return null;
	}

	public Class getBean() {
		return PrioridadeServicoUnidadeDTO.class;
	}
	public Collection find(IDto arg0) throws Exception {
		return null;
	}
	
	public Collection findByIdServicoContrato(Integer idServicoContrato) throws Exception {
	    List condicao = new ArrayList();
	    List ordenacao = new ArrayList();
	    
	    condicao.add(new Condition("idServicoContrato", "=", idServicoContrato));
	    ordenacao.add(new Order("idUnidade"));
	    
	    return super.findByCondition(condicao, ordenacao);
	}
	
	public PrioridadeServicoUnidadeDTO restore(Integer idServicoContrato, Integer idUnidade) throws Exception {
		List condicao = new ArrayList();
		condicao.add(new Condition("idServicoContrato", "=", idServicoContrato));
		condicao.add(new Condition("idUnidade", "=", idUnidade));
		condicao.add(new Condition("dataFim", "=", null));
		
		Collection col = super.findByCondition(condicao, null);
		if (col == null || col.size() == 0) return null;
		return (PrioridadeServicoUnidadeDTO) ((List) col).get(0);
	}		
	
}
