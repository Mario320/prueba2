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

    public List<BitacoraEntity> bitacora() {
        //obtengo una instsancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("BitacoraEntity.findAll");
            //El metodo getResultList() de la clase Query permite obtener
            //la lista de resultados de una consulta de seleccion
            List<BitacoraEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }// fin metodo

    public int ingresarAvance(BitacoraEntity IdBitacora) {
        
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(IdBitacora);
            tran.commit();
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }

    }// fin metodo insertar

    public int modificarAvance(BitacoraEntity IdBitacora) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try {
            tra.begin();//iniciando transacion
            em.merge(IdBitacora);//actualiznado el objeto en la BD
            tra.commit(); //confirmando la transaccion
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }// fin del metodo modificar colaborador

    public int eliminarAvance(String IdBitacora) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            //Recuperando el objeto a eliminar
            BitacoraEntity col = em.find(BitacoraEntity.class, IdBitacora);
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

    public List<BitacoraEntity> encontrarAvance(String referencia) {
        EntityManager em = JpaUtil.getEntityManager();
        //recuperando el objeto a modificar
        // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
        EntityTransaction tran = em.getTransaction();
        tran.begin();//Iniciando transaccion
        Query consulta = em.createNamedQuery("BitacoraEntity.findByIReferencia");
        consulta.setParameter("referencia", referencia);
        List<BitacoraEntity> lista = consulta.getResultList();
        tran.commit();//confirmando la transaccion
        em.close();

        return lista;

    }// fin de encontrar avances

    public BitacoraEntity encontrarReferencia(String referencia) {
        EntityManager em = JpaUtil.getEntityManager();
        //recuperando el objeto a modificar
        // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
        EntityTransaction tran = em.getTransaction();
        tran.begin();//Iniciando transaccion
        Query consulta = em.createNamedQuery("BitacoraEntity.findByReferenciaR");
        consulta.setParameter("referencia", referencia);
        BitacoraEntity bit = (BitacoraEntity) consulta.getSingleResult();
        tran.commit();//confirmando la transaccion
        em.close();
        return bit;

    }// fin de encontrar avance pro referencia

}
