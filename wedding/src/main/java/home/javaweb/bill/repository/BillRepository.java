package home.javaweb.bill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import home.javaweb.bill.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

	Bill findByFeastId(Long feastId);

//	@Query("SELECT b FROM Bill b WHERE b.status = ?1")
//	List<Bill> findAllBillPaid(int status);

	List<Bill> findByStatus(int status);

	void deleteByFeastId(Long feastId);


}
