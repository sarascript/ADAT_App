package utils;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import classes.Gato;


public class AccesoHibernate {

	Session session;
	
	public AccesoHibernate() {
		
		HibernateUtil util = new HibernateUtil(); 
		
		session = util.getSessionFactory().openSession();
		
	}
	
    
	public void borrarDatos(){
    	System.out.println("Inicio Borrado");

		session.beginTransaction();
    	
		Query q = session.createQuery("delete from Gato");
		q.executeUpdate();
		
		session.getTransaction().commit();
		System.out.println("Fin Borrado");
	}
	
    public void consultaGato() {
    	System.out.println("Inicio Consulta Simple Gatos");
    	
        Query q= session.createQuery("select e from Gato e");
        List results = q.list();
        
        Iterator gatosIterator= results.iterator();

        while (gatosIterator.hasNext()){
            Gato gato = (Gato)gatosIterator.next();
            
        	System.out.println ( "		Id: " + gato.getID() + " - Nombre: " + gato.getNombre() + " - Raza: " + gato.getRaza() + " - Color: " + gato.getColor());
            
        }

    	System.out.println("Fin Consulta Gatos");
    }
    
    
	public void insertarGato(String nombre, String raza, String color) {
		System.out.println("Inicio Inserción");
		
		Gato gato = new Gato();
		gato.setNombre(nombre);
		gato.setRaza(raza);
		gato.setColor(color);		
		
		// Utilizamos hibernate para guardar objetos
		
		session.beginTransaction();

		session.save(gato);
		
		session.getTransaction().commit();
		
		System.out.println("Fin Inserción");
	}
    
	public void cerrarSesion() {
		
		session.close();
		
	}
	

}
