/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.converter;
import sv.edu.udb.www.model.CasoModel;
import sv.edu.udb.www.entities.CasoEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Kido
 */
@FacesConverter(forClass= CasoEntity.class)
public class CasoConverter implements Converter {
    CasoModel modelo= new CasoModel();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value ==null || value.isEmpty()){
         return null;
        } try{
        
        CasoEntity tipo= modelo.encontrarCaso(value);
        return tipo;
        }catch(Exception e){
        return null;
        }
    }// fin

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         //To change body of generated methods, choose Tools | Templates.
         if(value==null){
         return "";
         }
         if(value instanceof CasoEntity){
         
             return((CasoEntity ) value).getReferencia();
         }else{
         
         return"";
         }
         
    }
    
}
