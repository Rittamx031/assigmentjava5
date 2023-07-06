package thatdz.assignment.assigmentjava5.restcontroller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.entity.CuaHang;
import thatdz.assignment.assigmentjava5.service.CuaHangService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/cuahang")
public class CuaHangRestController {
    @Autowired
    public CuaHangService service;

    @GetMapping
    public List<CuaHang> getCuaHangs() {
        return service.getCuaHangs();
    }

    @GetMapping("{id}")
    public CuaHang getEmployeeById(@PathVariable UUID id) {
        CuaHang employee = service.getCuaHangById(id);
        return employee;
    }

    @GetMapping("/search")
    public ResponseEntity<List<CuaHang>> searchProduct(@RequestParam("query") String query){
        return ResponseEntity.ok(service.searchCuaHangs(query));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CuaHang> updateProduct(@PathVariable UUID id, @RequestParam CuaHang cuahang){
        return ResponseEntity.ok(service.updateCuaHangByRest(cuahang));
    }

    @PostMapping("/cuahangup")
    public CuaHang createEmployee(@Valid @RequestBody CuaHang cuahang) {
        return service.saveCuaHang(cuahang);
    }

    @DeleteMapping("{id}")
    public void removeCuaHang(@PathVariable UUID id) {
        service.deleteCuaHang(id);
    }
}
