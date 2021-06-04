package home.javaweb.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.bill.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
