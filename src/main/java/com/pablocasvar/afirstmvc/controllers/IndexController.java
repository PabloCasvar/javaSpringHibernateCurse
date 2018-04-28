package com.pablocasvar.afirstmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Pablo on 14/04/2018.
 */
@Controller
public class IndexController {
    //note: correo jmperezsantos@gmail.com
    //todo: maquetar htmls de Lista de usuarios, nuevo usuario, modificación de usuario
    //todo: maquetar htmls de Lista de libros, nuevo libro , modificación de Libro
    //todo: maquetar base de datos para Libros: id, titulo, Autor, editorial, páginas, edición
    //todo: Maquetar base de datos para Usuarios: id, nombre, appellido paterno, apellido materno, edad, dirección

    @RequestMapping("/")
    public String index(){
        // En este caso se utiliza solo el nombre SIN extensión del archivo a renderear
        return "index";
    }

    @RequestMapping("/mav")
    public ModelAndView indexMAV(){
        // En este caso se retorna una vista a la que se le inyectan variables
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("saludo", "Este es un saludo");
        return mav;
    }
}
