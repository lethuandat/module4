package vn.codegym.module4_exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.module4_exam.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
