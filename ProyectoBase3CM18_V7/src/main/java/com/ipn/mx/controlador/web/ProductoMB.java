/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web;



import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.entidades.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author darkdestiny
 */
@ManagedBean(name = "productoMB")
@SessionScoped
public class ProductoMB extends BaseBean implements Serializable {
    private final ProductoDAO dao = new ProductoDAO();
    private final CategoriaDAO catDAO = new CategoriaDAO();
    
    private Producto dto;
    private List<Producto> listaProductos;
    private List<Categoria> listaCategorias;
    
    /**
     * Creates a new instance of ProductoMB
     */
    public ProductoMB() {
    }

    public Producto getDto() {
        return dto;
    }

    public void setDto(Producto dto) {
        this.dto = dto;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
    
    @PostConstruct
    public void init(){
        listaProductos = new ArrayList<>();
        listaProductos = dao.readAll();
        
        listaCategorias = new ArrayList<>();
        listaCategorias = catDAO.readAll();
    }
    
    public String prepareAdd(){
        dto = new Producto();
        setAccion(ACC_CREAR);
        return "/producto/productoForm?faces-redirect=true";
    }
    public String prepareUpdate(){
        setAccion(ACC_ACTUALIZAR);
        return "/producto/productoForm?faces-redirect=true";
    }
    public String prepareIndex(){
        init();
        return "/producto/listadoProductos?faces-redirect=true";
    }
    public boolean validate(){
        boolean valido = true;
        //Aqui les toca a ustedes poner todas las reglas de validacion 
       
        return valido;
    }
    
    public String add(){
        boolean valido = validate();
        if(valido){
            Categoria cat = new Categoria();
            cat.setIdCategoria(dto.getIdCat());
            cat = catDAO.read(cat);
            dto.setIdCategoria(cat);
            
            dao.create(dto);
            if(valido){
                return prepareIndex();
            }else{
                return prepareAdd();
            }
        }
        return prepareAdd();
    }
    public String update(){
        boolean valido = validate();
        if(valido){
             Categoria cat = new Categoria();
            cat.setIdCategoria(dto.getIdCat());
            cat = catDAO.read(cat);
            dto.setIdCategoria(cat);
            
            dao.update(dto);
            if(valido){
                return prepareIndex();
            }else{
                return prepareUpdate();
            }
        }
        return prepareUpdate();
    }
    public String delete(){
        dao.delete(dto);
        return prepareIndex();
    }
    
    public void seleccionarProducto(ActionEvent event){
        String claveSeleccionada = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("claveSel");
        dto = new Producto();
        dto.setIdProducto(Integer.parseInt(claveSeleccionada));
        try{
            dto = dao.read(dto);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
