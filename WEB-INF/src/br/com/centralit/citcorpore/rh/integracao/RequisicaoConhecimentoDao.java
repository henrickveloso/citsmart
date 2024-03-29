package br.com.centralit.citcorpore.rh.integracao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.centralit.citcorpore.rh.bean.RequisicaoConhecimentoDTO;
import br.com.citframework.dto.IDto;
import br.com.citframework.integracao.Condition;
import br.com.citframework.integracao.CrudDaoDefaultImpl;
import br.com.citframework.integracao.Field;
import br.com.citframework.integracao.Order;
import br.com.citframework.util.Constantes;

public class RequisicaoConhecimentoDao extends CrudDaoDefaultImpl {
	public RequisicaoConhecimentoDao() {
		super(Constantes.getValue("DATABASE_ALIAS"), null);
	}
	public Collection getFields() {
		Collection listFields = new ArrayList();
		listFields.add(new Field("idSolicitacaoServico" ,"idSolicitacaoServico", true, false, false, false));
		listFields.add(new Field("idConhecimento" ,"idConhecimento", true, false, false, false));
		listFields.add(new Field("obrigatorio" ,"obrigatorio", false, false, false, false));
		return listFields;
	}
	public String getTableName() {
		return this.getOwner() + "RH_RequisicaoConhecimento";
	}
	public Collection list() throws Exception {
		return null;
	}

	public Class getBean() {
		return RequisicaoConhecimentoDTO.class;
	}
	public Collection find(IDto arg0) throws Exception {
		return null;
	}
	public Collection findByIdSolicitacaoServico(Integer parm) throws Exception {
		List condicao = new ArrayList();
		List ordenacao = new ArrayList(); 
		condicao.add(new Condition("idSolicitacaoServico", "=", parm)); 
		ordenacao.add(new Order("idConhecimento"));
		return super.findByCondition(condicao, ordenacao);
	}
	public void deleteByIdSolicitacaoServico(Integer parm) throws Exception {
		List condicao = new ArrayList();
		condicao.add(new Condition("idSolicitacaoServico", "=", parm));
		super.deleteByCondition(condicao);
	}
}
