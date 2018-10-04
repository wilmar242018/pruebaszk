/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.personaDAO;
import DTO.personaDTO;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author Pc-Personal
 */
public class personaControlador extends Window {

    private personaDAO personaDAO = new personaDAO();
    private personaDTO personaDTO = new personaDTO();
    

    public void oncreatemethod() {
        // validaCtas();
    }

    public void insertar() {
        
        System.out.println("datoPersona" + getPersonaDTO().toString());
        personaDAO.insertar(personaDTO);
        System.out.println("ya insertamos, compruebe ");
    }

    public void consultar() {
        Textbox aa = (Textbox) getFellow("documento");
        getPersonaDTO().setCEDULA(aa.getValue());
        setPersonaDTO(personaDAO.consultar(getPersonaDTO()));
        System.out.println("datos del tercero:" + getPersonaDTO().toString());
        Textbox bb = (Textbox) getFellow("nombre");
        bb.setValue(getPersonaDTO().getNOMBRE());
        Textbox cc = (Textbox) getFellow("telefono");
        cc.setValue(getPersonaDTO().getTELEFONO());
        Textbox dd = (Textbox) getFellow("direccion");
        dd.setValue(getPersonaDTO().getDIRECCION());
    }

    public void actualiza() {
        Textbox aaes1 = (Textbox) getFellow("nombre");
        getPersonaDTO().setNOMBRE(aaes1.getValue());
        Textbox aaci1 = (Textbox) getFellow("telefono");
        getPersonaDTO().setTELEFONO(aaci1.getValue());
        Textbox aade1 = (Textbox) getFellow("direccion");
        getPersonaDTO().setDIRECCION(aade1.getValue());
        System.out.println("datoPersona" + getPersonaDTO().toString());
        personaDAO.actualiza(getPersonaDTO());
        System.out.println("ya actualizamos, compruebe ");
    }

    public void borrar() {
        Textbox aa = (Textbox) getFellow("documento");
        getPersonaDTO().setCEDULA(aa.getValue());
        personaDAO.borrar(getPersonaDTO());
    }

    public void limpia() {
        Textbox aaa = (Textbox) getFellow("documento");
        aaa.setValue("");
        Textbox bbb = (Textbox) getFellow("nombre");
        bbb.setValue("");
        Textbox ccc = (Textbox) getFellow("telefono");
        ccc.setValue("");
        Textbox ddd = (Textbox) getFellow("direccion");
        ddd.setValue("");
    }

    public personaDAO getPersonaDAO() {
        return personaDAO;
    }

    public void setPersonaDAO(personaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public personaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(personaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

}
