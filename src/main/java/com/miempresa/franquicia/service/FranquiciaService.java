package com.miempresa.franquicia.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.franquicia.model.Franquicia;
import com.miempresa.franquicia.model.Producto;
import com.miempresa.franquicia.model.Sucursal;
import com.miempresa.franquicia.repository.FranquiciaRepository;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public List<Franquicia> getAllFranquicia() {
        return franquiciaRepository.findAll();
    }

    public Franquicia addFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Franquicia modificarFranquicia(String idFranquicia, String nombre) {
        Franquicia franquicia = franquiciaRepository.findById(idFranquicia).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franquicia.setNombre(nombre);
        franquiciaRepository.save(franquicia);
        return franquicia;
    }

    public Sucursal agregarSucursal(String idFranquicia, Sucursal sucursal) {
        Franquicia franquicia = franquiciaRepository.findById(idFranquicia).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franquicia.getSucursales().add(sucursal);    
        franquiciaRepository.save(franquicia);
        return sucursal;
    }

    public Producto agregarProducto(String idFranquicia, String idSucursal, Producto producto) {
        Franquicia franquicia = franquiciaRepository.findById(idFranquicia).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        Sucursal sucursal = franquicia.getSucursales().stream().filter(s -> s.getId().equals(idSucursal)).findFirst().orElseThrow();
        sucursal.getProductos().add(producto);
        franquiciaRepository.save(franquicia);
        return producto;
    }

    public void eliminarProducto(String idFranquicia, String idSucursal, String idProducto) {
        Franquicia franquicia = franquiciaRepository.findById(idFranquicia).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        Sucursal sucursal = franquicia.getSucursales().stream().filter(s -> s.getId().equals(idSucursal)).findFirst().orElseThrow();
        sucursal.getProductos().removeIf(p -> p.getId().equals(idProducto));
        franquiciaRepository.save(franquicia);
    }

    public Producto modificarStock(String idFranquicia, String idSucursal, String idProducto, int nuevoStock) {
        Franquicia franquicia = franquiciaRepository.findById(idFranquicia).orElseThrow();
        Sucursal sucursal = franquicia.getSucursales().stream().filter(s -> s.getId().equals(idSucursal)).findFirst().orElseThrow();
        Producto producto = sucursal.getProductos().stream().filter(p -> p.getId().equals(idProducto)).findFirst().orElseThrow();
        producto.setStock(nuevoStock);
        franquiciaRepository.save(franquicia);
        return producto;
    }
}
