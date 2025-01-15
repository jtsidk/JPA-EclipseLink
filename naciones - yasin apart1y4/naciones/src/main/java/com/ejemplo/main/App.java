package com.ejemplo.main;

import com.ejemplo.model.Country;
import com.ejemplo.model.Language;
import com.ejemplo.model.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nacionesPU");
        EntityManager em = emf.createEntityManager();
        
        
        //PRUEBA MANY TO MANY
        try {
            em.getTransaction().begin();

            // Buscar o crear el país España
            Country country = em.createQuery(
                    "SELECT c FROM Country c WHERE c.countryCode2 = :code", Country.class)
                    .setParameter("code", "ES")
                    .getResultStream()
                    .findFirst()
                    .orElseGet(() -> {
                        Country newCountry = new Country();
                        newCountry.setName("España");
                        newCountry.setArea(505944);
                        newCountry.setNationalDay("2025-10-12");
                        newCountry.setCountryCode2("ES");
                        newCountry.setCountryCode3("ESP");
                        em.persist(newCountry);
                        return newCountry;
                    });

            // Crear o buscar el idioma Español
            Language language = em.createQuery(
                    "SELECT l FROM Language l WHERE l.language = :lang", Language.class)
                    .setParameter("lang", "Español")
                    .getResultStream()
                    .findFirst()
                    .orElseGet(() -> {
                        Language newLanguage = new Language();
                        newLanguage.setLanguage("Español");
                        em.persist(newLanguage);
                        return newLanguage;
                    });

            // Relacionar el país con el idioma
            country.getLanguages().add(language);
            language.getCountries().add(country);

            em.merge(country);
            em.merge(language);

            em.getTransaction().commit();

            System.out.println("Relación Many-to-Many probada exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

/*
 //PRUEBA ACTUALIZAR TABLA
        try {
            em.getTransaction().begin();

            // Buscar el país existente por su código
            Country country = em.createQuery(
                "SELECT c FROM Country c WHERE c.countryCode2 = :code", Country.class)
                .setParameter("code", "ES")
                .getSingleResult();

            if (country != null) {
                // Modificar el nombre del país
                System.out.println("Nombre actual del país: " + country.getName());
                country.setName("Reino de España");
                em.merge(country); // Guardar los cambios
                System.out.println("Nombre actualizado a: " + country.getName());
            } else {
                System.out.println("El país con código 'ES' no existe.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
        */
/*
 * 
 //CODIGO PRINCIPAL
        try {
            em.getTransaction().begin();

            // verificar o crear region
            Region region = em.find(Region.class, 1);
            if (region == null) {
                region = new Region();
                region.setRegionId(1);
                region.setName("Europa Occidental");
                region.setContinentId(1);
                em.persist(region);
                System.out.println("La región 'Europa Occidental' ha sido creada.");
            } else {
                System.out.println("La región con ID 1 ya existe.");
            }

            // verificar o crear pais
            Country existingCountry = null;
            try {
                existingCountry = em.createQuery(
                    "SELECT c FROM Country c WHERE c.countryCode2 = :code2 OR c.countryCode3 = :code3", Country.class)
                    .setParameter("code2", "ES")
                    .setParameter("code3", "ESP")
                    .getSingleResult();
            } catch (javax.persistence.NoResultException e) {
                existingCountry = null;
            }

            
            if (existingCountry == null) {
                Country country = new Country();
                country.setName("España");
                country.setArea(505944);
                country.setNationalDay("2025-10-12");
                country.setCountryCode2("ES");
                country.setCountryCode3("ESP");
                country.setRegion(region); // relacion con la region
                
                em.persist(country);
                
                System.out.println("el pais 'España' ha sido creado.");
            } else {
                System.out.println("el pais con código ES o ESP ya existe.");
            }

            
            em.getTransaction().commit();
            System.out.println("Datos guardados correctamente.");
            
           
        } catch (Exception e) {
            em.getTransaction().rollback();
            
            System.err.println("error de la transacción. se ha realizado un rollback.");
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
    */
}
}


