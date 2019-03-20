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
import sv.edu.udb.www.entities.CasoEntity;
/**
 *
 * @author Kido
 */
public class CasoModel {
     public List<CasoEntity>listarCasos(){
    //obtengo una instsancia de EntityManager
    EntityManager em = JpaUtil.getEntityManager();
    try{
    Query consulta = em.createNamedQuery("CasoEntity.findAll");
    //El metodo getResultList() de la clase Query permite obtener
    //la lista de resultados de una consulta de seleccion
    List<CasoEntity> lista=consulta.getResultList();
    em.close();
    return lista;
    }catch(Exception e){
    em.close();
    return null;
    }
    }// fin metodo
    
    public int ingresarCaso(CasoEntity caso){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(caso);
            tran.commit();
            em.close();
            return 1;
        } catch(Exception e){
            em.close();
            return 0;
        }
    
    }// fin metodo insertar
   public int modificarCaso(CasoEntity caso){
       EntityManager em = JpaUtil.getEntityManager();
       EntityTransaction tra = em.getTransaction();
       try{
       tra.begin();//iniciando transacion
       em.merge(caso);//actualiznado el objeto en la BD
       tra.commit(); //confirmando la transaccion
       em.close();
       return 1;
       }catch(Exception e){
           em.close();
           return 0;
       }
   }// fin del metodo modificar colaborador
   public int eliminarCaso(String referencia){
       EntityManager em = JpaUtil.getEntityManager();
       int filasBorradas = 0;
       try{
       //Recuperando el objeto a eliminar
       CasoEntity col = em.find(CasoEntity.class, referencia);
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
   
   public CasoEntity encontrarCaso(String referencia){
        EntityManager em = JpaUtil.getEntityManager();
        //recuperando el objeto a modificar
    
      EntityTransaction tran= em.getTransaction();
       tran.begin();//Iniciando transaccion
         Query consulta = em.createNamedQuery("CasoEntity.findByReferencia");
               consulta.setParameter("referencia", referencia);
     
     CasoEntity cas=(CasoEntity) consulta.getSingleResult();
     
           
            
            
            
       tran.commit();//confirmando la transaccion
            em.close();
     
     return cas;
     
   }// fin de encontrar caso
   
//      public  CasoEntity encontrarReferencia(String referencia){
//        EntityManager em = JpaUtil.getEntityManager();
//        //recuperando el objeto a modificar
//    // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
//      EntityTransaction tran= em.getTransaction();
//       tran.begin();//Iniciando transaccion
//         Query consulta = em.createNamedQuery("CasoEntity.findByReferenciaR");
//               consulta.setParameter("referencia", referencia);
//     
//     CasoEntity bit=(CasoEntity) consulta.getSingleResult();
//          
//            
//       tran.commit();//confirmando la transaccion
//            em.close();
//     
//     return bit;
//     
//   }// fin de encontrar avance pro referencia
   
   
   
   
}// fin de la clase 
