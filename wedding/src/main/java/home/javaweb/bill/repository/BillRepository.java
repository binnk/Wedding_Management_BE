package home.javaweb.bill.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import home.javaweb.bill.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

	Bill findByFeastId(Long feastId);

//	@Query("SELECT b FROM Bill b WHERE b.status = ?1")
//	List<Bill> findAllBillPaid(int status);

	List<Bill> findByStatus(int status);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM bill b WHERE b.feast_id = ?1", nativeQuery = true)
	void deleteByFeastId(Long feastId);


}
