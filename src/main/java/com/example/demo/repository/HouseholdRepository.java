package com.example.demo.repository;

import com.example.demo.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Long> {
    // Bạn có thể thêm các phương thức tìm kiếm tùy chỉnh ở đây nếu cần
}
