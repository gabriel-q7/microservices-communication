package br.com.commicros.productapi.modules.supplier.controller;

import br.com.commicros.productapi.modules.supplier.dto.SupplierRequest;
import br.com.commicros.productapi.modules.supplier.dto.SupplierResponse;
import br.com.commicros.productapi.modules.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService ;

    @PostMapping
    public SupplierResponse save(@RequestBody SupplierRequest request) {
        return supplierService.save(request);
    }

    @GetMapping
    public List<SupplierResponse> findAll() {
        return supplierService.findAll();
    }

    @GetMapping("{id}")
    public SupplierResponse findById(@PathVariable Integer id) {
        return supplierService.findByIdResponse(id);
    }

    @GetMapping("name/{name}")
    public List<SupplierResponse> findByDescription(@PathVariable String name) {
        return supplierService.findByName(name);
    }
}
