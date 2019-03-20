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
import sv.edu.udb.www.entities.BitacoraEntity;
/**
 *
 * @author Kido
 */
public class BitacoraModel {
     public List<BitacoraEntity>listarAvances(){
    //obtengo una instsancia de EntityManager
    EntityManager em = JpaUtil.getEntityManager();
    try{
    Query consulta = em.createNamedQuery("BitacoraEntity.findAll");
    //El metodo getResultList() de la clase Query permite obtener
    //la lista de resultados de una consulta de seleccion
    List<BitacoraEntity> lista=consulta.getResultList();
    em.close();
    return lista;
    }catch(Exception e){
    em.close();
    return null;
    }
    }// fin metodo
    
    public int ingresarAvance(BitacoraEntity avance){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(avance);
            tran.commit();
            em.close();
            return 1;
        } catch(Exception e){
            em.close();
            return 0;
        }
    
    }// fin metodo insertar
   public int modificarAvance(BitacoraEntity avance){
       EntityManager em = JpaUtil.getEntityManager();
       EntityTransaction tra = em.getTransaction();
       try{
       tra.begin();//iniciando transacion
       em.merge(avance);//actualiznado el objeto en la BD
       tra.commit(); //confirmando la transaccion
       em.close();
       return 1;
       }catch(Exception e){
           em.close();
           return 0;
       }
   }// fin del metodo modificar colaborador
   
   public int eliminarAvance(String idBitacora){
       EntityManager em = JpaUtil.getEntityManager();
       int filasBorradas = 0;
       try{
       //Recuperando el objeto a eliminar
       BitacoraEntity col = em.find(BitacoraEntity.class, idBitacora);
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
   
   public BitacoraEntity encontrarColaborador(String idBitacora){
        EntityManager em = JpaUtil.getEntityManager();
        //recuperando el objeto a modificar
    // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
      EntityTransaction tran= em.getTransaction();
       tran.begin();//Iniciando transaccion
         Query consulta = em.createNamedQuery("BitacoraEntity.findByIdBitacora");
               consulta.setParameter("IdBitacora", idBitacora);
     
     BitacoraEntity bit=(BitacoraEntity) consulta.getSingleResult();
     
                      
            
            
       tran.commit();//confirmando la transaccion
            em.close();
     
     return bit;
     
   }// fin de encontrar colaborador
}
