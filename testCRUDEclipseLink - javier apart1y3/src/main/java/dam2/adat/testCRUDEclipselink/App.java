package dam2.adat.testCRUDEclipselink;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import dam2.adat.testCRUDEclipselink.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class App {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
    public static void main(String[] args) {
    	
    	emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
    	em = emf.createEntityManager();
    	
    	try {
    		/*
            Region region = new Region();
            region.setName("RegionPrueba2");
            region.setContinentId(1);
            crearRegion(region);

    		
    		Country pais = new Country();
    		//pais.setCountryId(243);					//Hace falta para el update
    		pais.setName("Pais de prueba1");
    		pais.setArea(new BigDecimal(20202020.00));
    		pais.setNationalDay(java.sql.Date.valueOf("2000-10-10"));
    		pais.setCountryCode2("PD");
    		pais.setCountryCode3("PDP");
    		pais.setRegion(region);
    		crearPais(pais);
    		
    		
    		 Country pais2 = new Country();
             pais2.setName("Pais de prueba2");
             pais2.setArea(new BigDecimal(30303030.00));
             pais2.setNationalDay(Date.valueOf("2000-10-10"));
             pais2.setCountryCode2("DP");
             pais2.setCountryCode3("DPD");
             pais2.setRegion(region);  // Asignamos el ID de la región
             crearPais(pais2);
    		*/
    		
    		leerPaisesPorRegion(28);
    		
    		//actualizarPais(pais);
    		//eliminarPais(243);
    		//Country encontrado = leerPaisPorId(243);
    		//System.out.println("Pais Encontrado con el id proporcionado: " + encontrado);
    	}finally {
    		em.close();
    		emf.close();
    	}
    }
    
    //Metodos CRUD
    //Metodo CREATE
    public static void crearPais(Country pais) {
    	try {
    		em.getTransaction().begin();
    		em.persist(pais);
    		em.getTransaction().commit();
    		System.out.println("Creado con exito: " + pais.getName());
    	}catch(Exception e) {
    		em.getTransaction().rollback();
    		System.err.println("Error al crear el pais: " + e.getMessage());
    	}
    }
    //Metodos READ
    public static Country leerPaisPorId(int id) {
    	return em.find(Country.class, id);
    }
    
    //METODO UPDATE
    public static void actualizarPais(Country paisActualizado) {
    	try {
    		em.getTransaction().begin();
    		Country pais = em.merge(paisActualizado);
    		em.getTransaction().commit();
    		System.out.println("Pais actualizado o insertado con exito");
    	}catch(Exception e) {
    		em.getTransaction().rollback();
    		System.err.println("Error al actualizar el pais: " + e.getMessage());
    	}
    }
    
    //METODO DELETE
    public static void eliminarPais(int id) {
    	try {
	    	em.getTransaction().begin();
	    	Country pais = em.find(Country.class, id);
	    	if (pais!=null) {
	    		em.remove(pais);
	    		em.getTransaction().commit();
	    		System.out.println("Pais eliminado: " + pais.getName());
	    	}else {
	    		System.out.println("No se encontro el pais " + pais.getName());
	    		em.getTransaction().rollback();
	    	}
    	}catch(Exception e) {
    		em.getTransaction().rollback();
    		System.out.println("Error al eliminar el pais");
    	}
    }
    
    //Cosas del oneToMany
    public static void crearRegion(Region region) {
        try {
            em.getTransaction().begin();
            em.persist(region);
            em.getTransaction().commit();
            System.out.println("Región creada con éxito: " + region.getName());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al crear la región: " + e.getMessage());
        }
    }
    
    public static void leerPaisesPorRegion(int regionId) {
        String jpql = "SELECT c FROM Country c WHERE c.region.regionId = :regionId";
        List<Country> paises = em.createQuery(jpql, Country.class)
                                  .setParameter("regionId", regionId)
                                  .getResultList();

        if (paises.isEmpty()) {
            System.out.println("No se encontraron países para la región con ID " + regionId);
        } else {
            System.out.println("Países en la región con ID " + regionId + ":");
            for (Country pais : paises) {
                System.out.println(pais);
            }
        }
    }


    
    

}
