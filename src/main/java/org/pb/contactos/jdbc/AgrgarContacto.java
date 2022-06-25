package org.pb.contactos.jdbc;


import org.pb.contactos.jdbc.modelo.Contacto;
import org.pb.contactos.jdbc.repositorio.ContactoRepositorio;
import org.pb.contactos.jdbc.repositorio.ContactoRepositorioImpl;

import java.util.Scanner;

public class AgrgarContacto {

    public static void main(String[] args) {
        ContactoRepositorio<Contacto> repositorio = new ContactoRepositorioImpl();
        System.out.println("================ Contactos ================");

        repositorio.listar().forEach(c -> System.out.println(c.getId()+"|"+c.getNombre()+"|"+c.getApellido()+"|"+c.getTelefono()+"|"+c.getEmail()));

        System.out.println("--------------------------------------------");


        System.out.println("============= Agregar  Contacto =============");
        Contacto contacto = new Contacto();



        Scanner Datos = new Scanner(System.in);
        System.out.println("Ingresar Nombre");
        String nombre = Datos.nextLine();

        System.out.println("Ingresar Apellido");
        String apellido = Datos.nextLine();

        System.out.println("Ingresar Email");
        String email = Datos.nextLine();

        System.out.println("Ingresar Telefono");
        int telefono = Datos.nextInt();
        Datos.close();



        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setTelefono(telefono);
        contacto.setEmail(email);
        repositorio.guardar(contacto);
        System.out.println("Contacto guardado");
        repositorio.listar().forEach(c -> System.out.println(c.getId()+"|"+c.getNombre()+"|"+c.getApellido()+"|"+c.getTelefono()+"|"+c.getEmail()));

    }
}
