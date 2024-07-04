package com.bd.basico.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.basico.modelo.TblProductoCL3;
import com.bd.basico.repositorio.IProductoCL3Repositorio;

@Service
public class ClassProductoCL3Imp implements IProductoCL3Servicio {

    @Autowired
    private IProductoCL3Repositorio productoRepositorio;

    @Override
    public List<TblProductoCL3> ListadoProductos() {
        return (List<TblProductoCL3>) productoRepositorio.findAll();
    }

    @Override
    public void RegistrarProducto(TblProductoCL3 producto) {
        productoRepositorio.save(producto);
    }

    @Override
    public TblProductoCL3 BuscarProductoPorId(Integer id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void EliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }
}
