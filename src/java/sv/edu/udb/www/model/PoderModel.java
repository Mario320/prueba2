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
import sv.edu.udb.www.entities.PoderEntity;


public class PoderModel {

    public List<PoderEntity> listarPoderes() {
        //obtengo una instsancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
//     Query consulta = em.createNativeQuery("SELECT IDPODER, DETALLE, FECHA, OTORGANTE, PODER, IdCliente FROM poder");

            Query consulta = em.createNamedQuery("PoderEntity.findAll");
            //El metodo getResultList() de la clase Query permite obtener
            //la lista de resultados de una consulta de seleccion
            List<PoderEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }// fin metodo

    public int ingresarPoder(PoderEntity poder) {
        
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(poder);
            tran.commit();
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }

    }// fin metodo insertar

    public int modificarPoder(PoderEntity poder) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try {
            tra.begin();//iniciando transacion
            em.merge(poder);//actualiznado el objeto en la BD
            tra.commit(); //confirmando la transaccion
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }// fin del metodo modificar colaborador

    public int eliminarPoder(String idPoder) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            //Recuperando el objeto a eliminar
            PoderEntity col = em.find(PoderEntity.class, idPoder);
            
            if (col != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();//Iniciando transaccion
                em.remove(col);//Borrando la instancia
                tran.commit();//confirmando la transaccion
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;

        } catch (Exception e) {
            em.close();
            return 0;
        }
    }//fin metodo

    public PoderEntity encontrarPoder(String idPoder) {
        EntityManager em = JpaUtil.getEntityManager();
        //recuperando el objeto a modificar
        // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
        EntityTransaction tran = em.getTransaction();
        tran.begin();//Iniciando transaccion
        Query consulta = em.createNamedQuery("PoderEntity.findAll");
        consulta.setParameter("idPoder", idPoder);

        PoderEntity pod = (PoderEntity) consulta.getSingleResult();

        tran.commit();//confirmando la transaccion
        em.close();

        return pod;

    }// fin de encontrar poder
}
