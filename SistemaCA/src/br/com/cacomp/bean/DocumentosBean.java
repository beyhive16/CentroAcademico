package br.com.cacomp.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;

import br.com.cacomp.DAO.DocumentosDAO;
import br.com.cacomp.domain.Documentos;
import br.com.cacomp.util.Mensagens;

@ManagedBean(name = "MBDocumentos")
@ViewScoped
public class DocumentosBean {
	
	public void novo(Documentos docs) throws IOException{
		System.out.println("entrou no novo");
		try {
			DocumentosDAO docsDAO = new DocumentosDAO();
			docsDAO.salvar(docs);
			Mensagens.addMsgSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void excluir(Documentos docsTEMP){
		try {
			//System.out.println("identidade: "+docsTEMP.getIdentidade()+" requisicao: "+docsTEMP.getRequisicao()+" comprovante: "+docsTEMP.getComprovante());
			DocumentosDAO docsDAO = new DocumentosDAO();
			docsDAO.excluir(docsTEMP);
			Mensagens.addMsgSucesso("Excluido com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	public void fileUploadAction(FileUploadEvent event) {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
           
            String realPath = context.getRealPath("/");
 
 // Aqui cria o diretorio caso não exista
            File file = new File(realPath + "/documentosUpload/");
            file.mkdirs();
            
            byte[] arquivo = event.getFile().getContents();
            String caminho = realPath + "/documentosUpload/" + event.getFile().getFileName();    
      
 // esse trecho grava o arquivo no diretório
            FileOutputStream fos = new FileOutputStream(caminho);
            fos.write(arquivo);
            fos.close();
            

        } catch (Exception ex) {
            System.out.println("Erro no upload de imagem" + ex);
        }
    }
	
}
