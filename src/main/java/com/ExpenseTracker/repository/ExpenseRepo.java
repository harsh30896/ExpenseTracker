package com.ExpenseTracker.repository;

import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepo extends JpaRepository<ExpenseEntity, Long> {
    List<ExpenseEntity> findByCategory(Category category);
    ExpenseEntity findByUserAndCategory(UserEntity user,Category category);
    @Query("select e from ExpenseEntity e where e.category = :category and e.user.userId = :userId")
    Optional<ExpenseEntity> findByCategoryAndUserId(@Param("category") Category category, @Param("userId") Long userId);


}
