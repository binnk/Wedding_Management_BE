package home.javaweb.converter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.DTD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import home.javaweb.dto.FeastServiceDTO;
import home.javaweb.dto.FeastTableDTO;
import home.javaweb.dto.FeastTableSupport;
import home.javaweb.dto.ServiceSupport;
import home.javaweb.entity.FeastService;
import home.javaweb.entity.FeastTable;
import home.javaweb.service.IFeastService;
import home.javaweb.service.ITableCategoryService;

@Component
public class FeastTableConverter {
	
	@Autowired
	private IFeastService _feastService;
	
	@Autowired
	private ITableCategoryService _categotyService;
	
	public FeastTableDTO toDTO(List<FeastTable> entities) {
		FeastTableDTO result = new FeastTableDTO();
		
		result.setFeast(entities.get(0).getFeast());
		
		for(FeastTable ft : entities) {
			FeastTableSupport support = new FeastTableSupport();
			
			support.setId(ft.getId());
			support.setTableCategory(ft.getTableCategory());
			support.setNote(ft.getNote());
			support.setNumberTables(ft.getNumberTables());
			support.setReverseTables(ft.getReverseTables());
			support.setUnitPriceTable(ft.getUnitPriceTable());
			support.setTotalPrice(ft.getTotalPrice());
			
			result.getFeastTables().add(support);
		}

		return result;
	}
	
	public FeastTable toEntity(FeastTableDTO dto) {
		FeastTable result = new FeastTable();
		
		result.setId(dto.getId());
		result.setFeast(_feastService.findById(dto.getFeastId()));
		result.setTableCategory(_categotyService.findById(dto.getTableCategoryId()));
		result.setNumberTables(dto.getNumberTables());
		result.setReverseTables(dto.getReverseTables());
		result.setUnitPriceTable(dto.getUnitPriceTable());
		result.setNote(dto.getNote());
		result.setTotalPrice(dto.getTotalPrice());

		return result;
	}
	

}
