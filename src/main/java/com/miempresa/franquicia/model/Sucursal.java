package com.miempresa.franquicia.model;

import lombok.Data;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sucursales")
public class Sucursal {
    @Id
    private String id;
    private String nombre;
    private List<Producto> productos;
        private List<Sucursal> sucursales;
        
        public String getId() {
            return id;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public List<Producto> getProductos() {
            return productos;
        }
    
        public void setProductos(List<Producto> productos) {
            this.productos = productos;
    }
}

