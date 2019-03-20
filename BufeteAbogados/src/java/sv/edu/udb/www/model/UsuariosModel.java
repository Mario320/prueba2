/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
//import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.utils.JpaUtil;
//import utils.SecurityUtils;

/**
 *
 * @author benja
 */

public class UsuariosModel {

      public List<UsuarioEntity>listarUsuarios(){
    //obtengo una instsancia de EntityManager
    EntityManager em = JpaUtil.getEntityManager();
    try{
    Query consulta = em.createNamedQuery("UsuarioEntity.findAll");
    //El metodo getResultList() de la clase Query permite obtener
    //la lista de resultados de una consulta de seleccion
    List<UsuarioEntity> lista=consulta.getResultList();
    em.close();
    return lista;
    }catch(Exception e){
    em.close();
    return null;
    }
    }// fin metodo
    
    public int ingresarUsuarios(UsuarioEntity usuarios){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(usuarios);
            tran.commit();
            em.close();
            return 1;
        } catch(Exception e){
            em.close();
            return 0;
        }
    
    }// fin metodo insertar
   public int modificarUsuarios(UsuarioEntity usuarios){
       EntityManager em = JpaUtil.getEntityManager();
       EntityTransaction tra = em.getTransaction();
       try{
       tra.begin();//iniciando transacion
       em.merge(usuarios);//actualiznado el objeto en la BD
       tra.commit(); //confirmando la transaccion
       em.close();
       return 1;
       }catch(Exception e){
           em.close();
           return 0;
       }
   }// fin del metodo modificar colaborador
   
   public int eliminarUsuarios(String idUsuarios){
       EntityManager em = JpaUtil.getEntityManager();
       int filasBorradas = 0;
       try{
       //Recuperando el objeto a eliminar
       UsuarioEntity col = em.find(UsuarioEntity.class, idUsuarios);
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
   
   public UsuarioEntity encontrarUsuario(String idUsuarios){
        EntityManager em = JpaUtil.getEntityManager();
        //recuperando el objeto a modificar
    // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
      EntityTransaction tran= em.getTransaction();
       tran.begin();//Iniciando transaccion
         Query consulta = em.createNamedQuery("UsuarioEntity.findByIdUsuarios");
               consulta.setParameter("idUsuario", idUsuarios);
     
     UsuarioEntity bit=(UsuarioEntity) consulta.getSingleResult();
     
                      
            
            
       tran.commit();//confirmando la transaccion
            em.close();
     
     return bit;
     
   }// fin de encontrar colaborador
    
    
    

   public UsuarioEntity checkLogin(String user, String password) throws Exception{
       
       try{
            EntityManager em = JpaUtil.getEntityManager();
       Query query= em.createNamedQuery("UsuarioEntity.checkLogin");
       //Pasandole parametros a la consulta nombrada
       query.setParameter("usuario",user);
       query.setParameter("clave",password);
       return (UsuarioEntity) query.getSingleResult();
       }
       catch(Exception e){
           return null;
       }
   }


    
}