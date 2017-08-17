package br.com.cacomp.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.cacomp.domain.Documentos;
 
@ManagedBean
public class FileUploadView {
     
    private UploadedFile fileIdentidade;
    private UploadedFile fileFormulario;
    private UploadedFile fileComprovante;
    private Documentos docs;
 
    public UploadedFile getFileIdentidade() {
        return fileIdentidade;
    }
 
    public void setFileIdentidade(UploadedFile file) {
        this.fileIdentidade = file;
    }
    public UploadedFile getFileFormulario() {
        return fileFormulario;
    }
 
    public void setFileFormulario(UploadedFile file) {
        this.fileFormulario = file;
    }
    public UploadedFile getFileComprovante() {
        return fileComprovante;
    }
 
    public void setFileComprovante(UploadedFile file) {
        this.fileComprovante = file;
    }
     
    public Documentos getDocs() {
		return docs;
	}

	public void setDocs(Documentos docs) {
		this.docs = docs;
	}
	
	public void prepararNovo(){
		docs = new Documentos();
		/*byte[] b1 = getBytes(fileIdentidade);
		byte[] b2 = getBytes(fileFormulario);
		byte[] b3 = getBytes(fileComprovante);
		*/
		docs.setIdentidade(fileIdentidade);
		docs.setRequisicao(fileFormulario);
		docs.setComprovante(fileComprovante);
	}
	
	public void upload() throws IOException {
    	//String filename = new File(getFile().getFileName()).getName();
    	//System.out.println("nome: "+filename);
    	DocumentosBean docc = new DocumentosBean();
    	if((fileIdentidade != null && fileFormulario != null) && (fileComprovante != null)) {
    		prepararNovo();
        	docc.novo(docs);
        	//FacesMessage message = new FacesMessage("Arquivos Enviados com Sucesso.");
            //FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
        	FacesMessage message = new FacesMessage("Problemas no Envio, Tente Novamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	
	public byte[] getBytes(File file) {
	     int             len     = (int)file.length();  
	      byte[]          sendBuf = new byte[len];
	      FileInputStream inFile  = null;
	      try {
	         inFile = new FileInputStream(file);         
	         inFile.read(sendBuf, 0, len);  
	      } catch (FileNotFoundException fnfex) {
	      } catch (IOException ioex) {
	      }
	 return sendBuf;
	}
}