package com.miempresa.franquicia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.miempresa.franquicia.model.Franquicia;
import com.miempresa.franquicia.model.Producto;
import com.miempresa.franquicia.model.Sucursal;
import com.miempresa.franquicia.service.FranquiciaService;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @GetMapping
    public ResponseEntity<List<Franquicia>> getAllFranquicia() {
        return ResponseEntity.ok(franquiciaService.getAllFranquicia());
    }

    @PostMapping
    public ResponseEntity<Franquicia> addFranquicia(@RequestBody Franquicia franquicia) {
        return ResponseEntity.ok(franquiciaService.addFranquicia(franquicia));
    }

    @PutMapping("/{idFranquicia}")
    public ResponseEntity<Franquicia> modificarFranquicia(@PathVariable String idFranquicia, @RequestBody String nombre) {
        return ResponseEntity.ok(franquiciaService.modificarFranquicia(idFranquicia, nombre));
    }

    @PostMapping("/{idFranquicia}/sucursales")
    public ResponseEntity<Sucursal> agregarSucursal(@PathVariable String idFranquicia, @RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(franquiciaService.agregarSucursal(idFranquicia, sucursal));
    }

    @PostMapping("/{idFranquicia}/sucursales/{idSucursal}/productos")
    public ResponseEntity<Producto> agregarProducto(@PathVariable String idFranquicia, @PathVariable String idSucursal, @RequestBody Producto producto) {
        return ResponseEntity.ok(franquiciaService.agregarProducto(idFranquicia, idSucursal, producto));
    }

    @DeleteMapping("/{idFranquicia}/sucursales/{idSucursal}/productos/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String idFranquicia, @PathVariable String idSucursal, @PathVariable String idProducto) {
        franquiciaService.eliminarProducto(idFranquicia, idSucursal, idProducto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idFranquicia}/sucursales/{idSucursal}/productos/{idProducto}/stock")
    public ResponseEntity<Producto> modificarStock(@PathVariable String idFranquicia, @PathVariable String idSucursal, @PathVariable String idProducto, @RequestParam int nuevoStock) {
        return ResponseEntity.ok(franquiciaService.modificarStock(idFranquicia, idSucursal, idProducto, nuevoStock));
    }
}
