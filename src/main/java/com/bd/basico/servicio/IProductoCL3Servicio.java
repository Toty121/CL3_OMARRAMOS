package com.bd.basico.servicio;

import java.util.List;

import com.bd.basico.modelo.TblProductoCL3;

public interface IProductoCL3Servicio {

    List<TblProductoCL3> ListadoProductos();

    void RegistrarProducto(TblProductoCL3 producto);

    TblProductoCL3 BuscarProductoPorId(Integer id);

    void EliminarProducto(Integer id);
}
