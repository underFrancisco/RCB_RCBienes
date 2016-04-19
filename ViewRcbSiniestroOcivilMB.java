package mx.com.qualitas.rcb.mb;

import mx.com.qualitas.rcb.dto.RcbSiniestroOcivilDTO;
import mx.com.qualitas.rcb.service.RcbSiniestroOcivilService;

import mx.com.qualitas.rcb.support.*;
/*::::::::::::::::::::::::: PRUEBA PARA VER LOS CAMBIOS:::::::::::::::::::::*/
import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataAccessException;

@ManagedBean(name = "viewRcbSiniestroOcivil")
@ViewScoped

/**
 *
 * Clase RcbSiniestroOcivilMB que responde a los eventos de pagina generados por
 * los componentes JSF para la entidad RCB_SINIESTRO_OCIVIL
 */
@SuppressWarnings("serial")
public class ViewRcbSiniestroOcivilMB extends ViewMB {

    private static final Logger log = LogManager.getLogger(ViewRcbSiniestroOcivilMB.class.getName());

    private String rcbTipoSiniestro = "";

    public String getRcbTipoSiniestro() {
        return rcbTipoSiniestro;
    }

    public void setRcbTipoSiniestro(String rcbTipoSiniestro) {
        this.rcbTipoSiniestro = rcbTipoSiniestro;
    }

    protected List<RcbSiniestroOcivilDTO> lstRcbSiniestroOcivil = new ArrayList<RcbSiniestroOcivilDTO>();

    protected RcbSiniestroOcivilDTO rcbSiniestroOcivil = new RcbSiniestroOcivilDTO();

    public RcbSiniestroOcivilDTO getRcbSiniestroOcivil() {
        return this.rcbSiniestroOcivil;
    }

    public void setRcbSiniestroOcivil(RcbSiniestroOcivilDTO rcbSiniestroOcivil) {
        this.rcbSiniestroOcivil = rcbSiniestroOcivil;
    }

    protected RcbSiniestroOcivilDTO rcbSiniestroOcivilTmp = new RcbSiniestroOcivilDTO();

    public RcbSiniestroOcivilDTO getRcbSiniestroOcivilTmp() {
        return this.rcbSiniestroOcivilTmp;
    }

    public void setRcbSiniestroOcivilTmp(RcbSiniestroOcivilDTO rcbSiniestroOcivilTmp) {
        this.rcbSiniestroOcivilTmp = rcbSiniestroOcivilTmp;
    }

    @ManagedProperty(value = "#{rcbSiniestroOcivilService}")
    protected RcbSiniestroOcivilService rcbSiniestroOcivilService;

    public void setRcbSiniestroOcivilService(RcbSiniestroOcivilService rcbSiniestroOcivilService) {
        this.rcbSiniestroOcivilService = rcbSiniestroOcivilService;
    }

    public List<RcbSiniestroOcivilDTO> getLstRcbSiniestroOcivil() {
        return lstRcbSiniestroOcivil;
    }

//    @ManagedProperty(value = "#{rcbSiniestroGralService}")
//    protected RcbSiniestroGralService rcbSiniestroGralService;
//    protected List<RcbSiniestroGralOCivilReporte> lstRcbSiniestroGral = new ArrayList<RcbSiniestroGralOCivilReporte>();
//    public void setRcbSiniestroGralService(RcbSiniestroGralService rcbSiniestroGralService) {
//        this.rcbSiniestroGralService = rcbSiniestroGralService;
//    }
//    public List<RcbSiniestroGralOCivilReporte> getLstRcbSiniestroGral() {
//        return lstRcbSiniestroGral;
//    }
    /**
     * Este codigo se genero con Arquitecto MVC. Atiende las peticiones de
     * evento de consulta de objetos RcbSiniestroOcivil
     */
    public String busquedaRcbSiniestroOcivil() {

        try {
            lstRcbSiniestroOcivil = rcbSiniestroOcivilService.selectByExampleRcbSiniestroOcivil(this.criterio);
        } catch (DataAccessException e) {
            log.error(e);
            MessageUtils.addMsg(FacesMessage.SEVERITY_ERROR, "message.error.busqueda", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
        }
        return null;
    }

    /**
     * Este codigo se genero con Arquitecto MVC. Atiende las peticiones de
     * evento de alta de objetos de la tabla usuario
     */
    public String agregaRcbSiniestroOcivil() {

        try {
            this.rcbSiniestroOcivilService.insertRcbSiniestroOcivil(rcbSiniestroOcivil);
            busquedaRcbSiniestroOcivil();
            rcbSiniestroOcivil = new RcbSiniestroOcivilDTO();
            inserta = Boolean.FALSE;
            MessageUtils.addMsg(FacesMessage.SEVERITY_WARN, "message.inserta", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
        } catch (DataIntegrityViolationException e) {
            log.error(e);
            MessageUtils.addMsg(FacesMessage.SEVERITY_ERROR, "message.error.inserta", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil.existe"));
            return null;
        } catch (DataAccessException e) {
            log.error(e);
            MessageUtils.addMsg(FacesMessage.SEVERITY_ERROR, "message.error.inserta", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
            return null;
        }
//            return "buscaRcbSiniestroOcivil?faces-redirect=true";
        RequestContext.getCurrentInstance().addCallbackParam("exito", true);
        return null;

    }

    /**
     * Este codigo se genero con Arquitecto MVC. Atiende las peticiones de
     * evento para actulizar un objeto RcbSiniestroOcivil mediante la llave
     * primaria
     */
    public String actualizaRcbSiniestroOcivil() {

        try {
            this.rcbSiniestroOcivilService.updateRcbSiniestroOcivil(rcbSiniestroOcivil);
            busquedaRcbSiniestroOcivil();
            rcbSiniestroOcivil = new RcbSiniestroOcivilDTO();
            MessageUtils.addMsg(FacesMessage.SEVERITY_WARN, "message.actualiza", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
        } catch (DataAccessException e) {
            log.error(e);
            MessageUtils.addMsg(FacesMessage.SEVERITY_ERROR, "message.error.actualiza", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
            return null;
        }
//            return "buscaRcbSiniestroOcivil?faces-redirect=true";
        RequestContext.getCurrentInstance().addCallbackParam("exito", true);

        return null;
    }

    @PostConstruct
    public void inicio() {
        rcbSiniestroOcivil = new RcbSiniestroOcivilDTO();
        inserta = Boolean.FALSE;
        setDocumentoTitulo("Siniestros de Obra Civil");

        try {
            lstRcbSiniestroOcivil = rcbSiniestroOcivilService.selectByExampleRcbSiniestroOcivil(this.criterio);
        } catch (DataAccessException e) {
            log.error(e);
        }

    }

    public void inicioInserta() {
        rcbSiniestroOcivil = new RcbSiniestroOcivilDTO();
        inserta = Boolean.TRUE;

        try {
            //rcbSiniestroOcivil.setIdSiniestroGral(rcbSiniestroOcivilService.siguienteFolio());

        } catch (DataAccessException e) {
            log.error(e);
        }

    }

    /**
     * Este codigo se genero con Arquitecto MVC. Atiende las peticiones de
     * evento para consulta de un elemento en la tabla RCB_SINIESTRO_OCIVIL
     * mediante la llave primaria
     */
    public String seleccionaRcbSiniestroOcivil() {
        try {
            rcbSiniestroOcivil = this.rcbSiniestroOcivilService.getById(rcbSiniestroOcivil.getIdSiniestroGral());

        } catch (DataAccessException e) {
            log.error(e);
            MessageUtils.addMsg(FacesMessage.SEVERITY_ERROR, "message.error.busqueda", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
            return null;
        }
//            return "buscaRcbSiniestroOcivil?faces-redirect=true";
        return null;
    }

    /**
     * Este codigo se genero con Arquitecto MVC. Atiende las peticiones de
     * evento para actulizar un objeto RcbSiniestroOcivil mediante la llave
     * primaria
     */
    public String inactivaRcbSiniestroOcivil() {
        try {
            this.rcbSiniestroOcivilService.deleteRcbSiniestroOcivil(rcbSiniestroOcivil);
            busquedaRcbSiniestroOcivil();
            rcbSiniestroOcivil = new RcbSiniestroOcivilDTO();
            MessageUtils.addMsg(FacesMessage.SEVERITY_WARN, "message.elimina", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
        } catch (DataAccessException e) {
            log.error(e);
            MessageUtils.addMsg(FacesMessage.SEVERITY_ERROR, "message.error.elimina", MessageUtils.getResourceText("rotulo.rcbSiniestroOcivil"));
            return null;
        }
//            return "buscaRcbSiniestroOcivil?faces-redirect=true";
        return null;
    }

}
