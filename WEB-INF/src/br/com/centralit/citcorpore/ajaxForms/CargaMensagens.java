package br.com.centralit.citcorpore.ajaxForms;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import br.com.centralit.citajax.html.AjaxFormAction;
import br.com.centralit.citajax.html.DocumentHTML;
import br.com.centralit.citajax.util.Constantes;
import br.com.centralit.citcorpore.bean.DicionarioDTO;
import br.com.centralit.citcorpore.bean.UsuarioDTO;
import br.com.centralit.citcorpore.negocio.DicionarioService;
import br.com.centralit.citcorpore.util.CITCorporeUtil;
import br.com.centralit.citcorpore.util.WebUtil;
import br.com.citframework.service.ServiceLocator;

@SuppressWarnings("rawtypes")
public class CargaMensagens extends AjaxFormAction {

	@Override
	public void load(DocumentHTML document, HttpServletRequest request, HttpServletResponse response) throws Exception {

		UsuarioDTO usuario = WebUtil.getUsuario(request);
		if (usuario == null) {
			document.alert("Sess�o expirada! Favor efetuar logon novamente!");
			document.executeScript("window.location = '" + Constantes.getValue("SERVER_ADDRESS") + request.getContextPath() + "'");
			return;
		}

		br.com.centralit.citcorpore.util.Upload upload = new br.com.centralit.citcorpore.util.Upload();

		HashMap hshRetorno[] = null;

		try {
			hshRetorno = upload.doUploadAll(request);
		} catch (Exception e) {
		}

		if (hshRetorno != null) {

			Collection fileItems = hshRetorno[1].values();
			String fileName = "";
			FileItem fi;
			if (fileItems != null && !fileItems.isEmpty()) {
				File arquivo = null;
				Iterator it = fileItems.iterator();
				while (it.hasNext()) {
					fi = (FileItem) it.next();

					if (fi.getName().length() < 1) {
						document.alert("Favor Selecionar um Arquivo!");
						document.executeScript("JANELA_AGUARDE_MENU.hide();");
						return;
					}

					String extensao = br.com.centralit.citcorpore.util.Util.getFileExtension(fi.getName());
					if (!extensao.equalsIgnoreCase("xml")) {
						document.alert("Favor selecionar uma extens�o de aquivo v�lido: Exemplo: arquivo.xml!");
						document.executeScript("JANELA_AGUARDE_MENU.hide();");
						return;
					}
					fileName = fi.getName();
					arquivo = new File(CITCorporeUtil.caminho_real_app + "tempFiles/" + fileName);
					fi.write(arquivo);
					arquivo = null;
					System.gc();
				}

				DicionarioService dicionarioService = (DicionarioService) ServiceLocator.getInstance().getService(DicionarioService.class, null);

				Thread.sleep(5000);
				System.out.println("Vai carregar o arquivo de Mensagens..." + CITCorporeUtil.caminho_real_app + "tempFiles/" + fileName);
				arquivo = new File(CITCorporeUtil.caminho_real_app + "tempFiles/" + fileName);
				dicionarioService.gerarCarga(arquivo);
				document.alert("Carga gerada com sucesso!");
			} else {
				document.alert("N�o foi possivel gerar a carga!");
				return;
			}
			document.executeScript("JANELA_AGUARDE_MENU.hide();");
		}
	}

	@Override
	public Class getBeanClass() {
		// TODO Auto-generated method stub
		return DicionarioDTO.class;
	}

}
