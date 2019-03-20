
package sv.edu.udb.www.converter;
import sv.edu.udb.www.model.TipousuariosModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.edu.udb.www.entities.TipousuarioEntity;


@FacesConverter(forClass= TipousuarioEntity.class)
public class TipoUsuarioConverter implements Converter {
    TipousuariosModel modelo= new TipousuariosModel();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value ==null || value.isEmpty()){
         return null;
        } try{        
        TipousuarioEntity tipo= modelo.encontrarTipoUsuario(value);
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
         if(value instanceof TipousuarioEntity){
         
             return((TipousuarioEntity ) value).getIdTipoUsuario();
         }else{
         
         return"";
         }
         
    }
    
}
