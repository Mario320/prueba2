/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.www.model;
import java.math.BigDecimal;
import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import sv.edu.udb.www.entities.ColaboradorEntity;
/**
 *
 * @author Kido
 */
public class ColaboradorModel {
     public List<ColaboradorEntity>listarColaboradores(){
    //obtengo una instsancia de EntityManager
    EntityManager em = JpaUtil.getEntityManager();
    try{
    Query consulta = em.createNamedQuery("ColaboradorEntity.findAll");
    //El metodo getResultList() de la clase Query permite obtener
    //la lista de resultados de una consulta de seleccion
    List<ColaboradorEntity> lista=consulta.getResultList();
    em.close();
    return lista;
    }catch(Exception e){
    em.close();
    return null;
    }
    }// fin metodo
    
    public int ingresarColaborador(ColaboradorEntity colaborador){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(colaborador);
            tran.commit();
            em.close();
            return 1;
        } catch(Exception e){
            em.close();
            return 0;
        }
    
    }// fin metodo insertar
   public int modificarColaborador(ColaboradorEntity colaborador){
       EntityManager em = JpaUtil.getEntityManager();
       EntityTransaction tra = em.getTransaction();
       try{
       tra.begin();//iniciando transacion
       em.merge(colaborador);//actualiznado el objeto en la BD
       tra.commit(); //confirmando la transaccion
       em.close();
       return 1;
       }catch(Exception e){
           em.close();
           return 0;
       }
   }// fin del metodo modificar colaborador
   public int eliminarColaborador(String idColaborador){
       EntityManager em = JpaUtil.getEntityManager();
       int filasBorradas = 0;
       try{
       //Recuperando el objeto a eliminar
       ColaboradorEntity col = em.find(ColaboradorEntity.class, idColaborador);
       if(col !=null){
           EntityTransaction tran= em.getTransaction();
           tran.begin();//Iniciando transaccion
           em.remove(col);//Borrando la instancia
           tran.commit();//confirmando la transaccion
           filasBorradas=1;
       }em.close();
       return filasBorradas;
       
       
       }catch(Exception e){
           em.close();
           return 0;
       }
   }//fin metodo
   
   public ColaboradorEntity encontrarColaborador(String idColaborador){
        EntityManager em = JpaUtil.getEntityManager();
        //recuperando el objeto a modificar
    // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
      EntityTransaction tran= em.getTransaction();
       tran.begin();//Iniciando transaccion
         Query consulta = em.createNamedQuery("ColaboradorEntity.findByIdColaborador");
               consulta.setParameter("idColaborador", idColaborador);
     
     ColaboradorEntity col=(ColaboradorEntity) consulta.getSingleResult();
     
            col.getIdColaborador();
            col.getNombre();
            col.getApellido();
            col.getCorreo();
            col.getTelefono();
            
            
             System.out.println(col.getApellido());
       tran.commit();//confirmando la transaccion
            em.close();
     
     return col;
     
   }// fin de encontrar colaborador
}
