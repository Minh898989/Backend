package com.example.demo.service;

import com.example.demo.model.Household;
import com.example.demo.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseholdService {

    private final HouseholdRepository householdRepository;

    @Autowired
    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    // Lấy tất cả sản phẩm gia dụng
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    // Lấy sản phẩm gia dụng theo ID
    public Optional<Household> getHouseholdById(Long id) {
        return householdRepository.findById(id);
    }

    // Thêm mới sản phẩm gia dụng
    public Household addHousehold(Household household) {
        return householdRepository.save(household);
    }

    // Cập nhật thông tin sản phẩm gia dụng
    public Household updateHousehold(Long id, Household householdDetails) {
        // Kiểm tra sản phẩm gia dụng có tồn tại hay không
        return householdRepository.findById(id)
                .map(existingHousehold -> {
                    existingHousehold.setName(householdDetails.getName());
                    existingHousehold.setPrice(householdDetails.getPrice());
                    existingHousehold.setQuantity(householdDetails.getQuantity());
                    existingHousehold.setBrand(householdDetails.getBrand());
                    existingHousehold.setOrigin(householdDetails.getOrigin());
                    existingHousehold.setMaterial(householdDetails.getMaterial());
                    return householdRepository.save(existingHousehold);
                })
                .orElseThrow(() -> new RuntimeException("Household not found with ID " + id));
    }

    // Xóa sản phẩm gia dụng
    public void deleteHousehold(Long id) {
        householdRepository.deleteById(id);
    }
}
