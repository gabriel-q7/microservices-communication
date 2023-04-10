package br.com.commicros.productapi.modules.supplier.service;

import br.com.commicros.productapi.config.exception.ValidationException;
import br.com.commicros.productapi.modules.category.dto.CategoryResponse;
import br.com.commicros.productapi.modules.category.model.Category;
import br.com.commicros.productapi.modules.supplier.dto.SupplierRequest;
import br.com.commicros.productapi.modules.supplier.dto.SupplierResponse;
import br.com.commicros.productapi.modules.supplier.model.Supplier;
import br.com.commicros.productapi.modules.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierResponse> findAll() {
        return supplierRepository
                .findAll()
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }
    public List<SupplierResponse> findByName(String name) {
        if (isEmpty(name)) {
            throw new ValidationException("The supplier name must be informed");
        }
        return supplierRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }

    public SupplierResponse findByIdResponse(Integer id){
        return SupplierResponse.of(findById(id));
    }

    public Supplier findById(Integer id){
        if (isEmpty(id)) {
            throw new ValidationException("The supplier ID must be informed");
        }
        return supplierRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }

    public SupplierResponse save(SupplierRequest request) {
        validateSupplierNameInformed(request);
        var supplier = supplierRepository.save(Supplier.of(request));
        return SupplierResponse.of(supplier);
    }

    public void validateSupplierNameInformed(SupplierRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The supplier's name was not informed");
        }
    }
}
