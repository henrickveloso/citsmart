<%@ taglib uri="/tags/cit" prefix="cit"%>
<%@page import="br.com.centralit.citcorpore.util.WebUtil"%>
<%@page import="br.com.centralit.citcorpore.bean.UsuarioDTO"%>
<%@page import="br.com.citframework.dto.Usuario"%>
<%@ taglib uri="/tags/i18n" prefix="i18n"%>

<!doctype html public "✰">
<html>
<head>
	<%
	    response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", -1);
	%>
	<%@include file="/include/security/security.jsp"%>
	<!--[if lt IE 7]> <html lang="en-us" class="no-js ie6"> <![endif]-->
	<!--[if IE 7]>    <html lang="en-us" class="no-js ie7"> <![endif]-->
	<!--[if IE 8]>    <html lang="en-us" class="no-js ie8"> <![endif]-->
	<!--[if IE 9]>    <html lang="en-us" class="no-js ie9"> <![endif]-->
	<!--[if gt IE 8]><!-->
	<html lang="en-us" class="no-js">
	<!--<![endif]-->
	<!--<![endif]-->
	<title>CIT Corpore</title>
	<%@include file="/include/noCache/noCache.jsp"%>
	<%@include file="/include/header.jsp"%>
	<%@include file="/include/javaScriptsComuns/javaScriptsComuns.jsp"%>
	
	<style type="text/css">
	.table {
		border-left: 1px solid #ddd;
	}
	
	.table th {
		border: 1px solid #ddd;
		padding: 4px 10px;
		border-left: none;
		background: #eee;
	}
	
	.table td {
		border: 1px solid #ddd;
		padding: 4px 10px;
		border-top: none;
		border-left: none;
		
	}
	#tblip{
		width: 90% !important;
		margin-left: -20px;
	}
	#tblip .marcaTodos{
		display: block;
		float: left;
		width: 150px;
	}
	#tblip .pesquisarNetMap{
		display: block;
		float: right;
		width: 150px;
	}
	#tblip .quantIP{
		display: block;
		float: left;
		width: 350px;
	}	
	#totalIP{
		width: 59% !important;
		margin-left: -20px;	
	}
	</style>
	<script>
	function inventarioManual() {
		
		JANELA_AGUARDE_MENU.show();
		$('#loading_overlay').show();
		document.form.fireEvent("inventarioManual");
	}
	
	function netMapManual(){
		JANELA_AGUARDE_MENU.show();
		$('#loading_overlay').show();
		document.form.fireEvent("netMapManual");

	}

	function marcarTodosCheckbox() {
		var itens = document.form.ips;
		var marcar = document.form.marcatodos;
		for ( var i = 0; i < itens.length; i++) {
			if (marcar.checked) {
				if (!itens[i].checked) {
					itens[i].checked = true;
				}
			} else {
				itens[i].checked = false;
			}
		}
	}
	
	$(function() {
		$("#POPUP_RESULTADO_INVENTARIO").dialog({
			autoOpen : false,
			width : 600,
			height : 400,
			modal : true
		});
	});
</script>

</head>
<cit:janelaAguarde id="JANELA_AGUARDE_MENU"  title="" style="display:none;top:325px;width:300px;left:500px;height:50px;position:absolute;">
</cit:janelaAguarde>
	<body>
		<div id="wrapper"><%@include file="/include/menu_vertical.jsp"%>
		<!-- Conteudo -->
		<div id="main_container" class="main_container container_16 clearfix">
		<%@include file="/include/menu_horizontal.jsp"%>
		
		<div class="flat_area grid_16">
		<h2><i18n:message key="inventario.invetario" /></h2>
		</div>
		
		<div class="box grid_16 tabs">
		<ul class="tab_header clearfix">
			<li><a href="#tabs-1"><i18n:message key="inventario.cadastro" />
			</a></li>
		
		</ul>
		<a href="#" class="toggle">&nbsp;</a>
		<div class="toggle_container">
			<div id="tabs-1" class="block">
				<div class="section" style="width: ">
					<form name='form' action='<%=CitCorporeConstantes.CAMINHO_SERVIDOR%><%=request.getContextPath()%>/pages/inventario/inventario'>
						<div class="columns clearfix">
						<!-- <h2 class="section"></h2> -->
						<h4><i18n:message key="inventario.cbcIps" /> </h4>
						<input type='hidden' name='idEmpresa' value="<%=WebUtil.getIdEmpresa(request)%>" />
						
						<div class="columns clearfix">
							<div>
								<fieldset >
									<div id="ipMac" ></div>
								</fieldset>
	
						   </div>
						</div>						
						</div>
						<div style="width: 500px" >&nbsp;</div>
						<button type='button' name='btnGravar' class="light" onclick='inventarioManual();'>
							<img src="<%=br.com.citframework.util.Constantes.getValue("CONTEXTO_APLICACAO")%>/template_new/images/icons/small/grey/pencil.png">
							<span><i18n:message key="inventario.gerarInventario" /> </span>
						</button>
						<button type='button' name='btnLimpar' class="light" onclick='document.form.clear();'>
							<img src="<%=br.com.citframework.util.Constantes.getValue("CONTEXTO_APLICACAO")%>/template_new/images/icons/small/grey/clear.png">
							<span><i18n:message key="citcorpore.comum.limpar" /> </span>
						</button>
						<div id="POPUP_RESULTADO_INVENTARIO" title="Resultado Invent�rio">
							<div id="resultado">
							
							</div>

						</div>
					</form>
				</div>
			</div>
		<!-- ## FIM - AREA DA APLICACAO ## --></div>
		</div>
		</div>
		<!-- Fim da Pagina de Conteudo --></div>
		<%@include file="/include/footer.jsp"%>
	</body>
	
</html>