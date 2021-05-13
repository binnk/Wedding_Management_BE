package home.javaweb.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;

public class FeastConverter {
	private static final FeastConverter instance  = new FeastConverter();
	private FeastConverter() {}
    public static FeastConverter getIntance() {
    	return instance;
    }
    public  FeastDTO EntityToDto(FeastEntity entity) {
    	 FeastDTO result = new FeastDTO();
    	 if(entity != null) {
    		 result.setId(entity.getId());
    		 result.setBrideName(entity.getBridename());
    		 result.setGroomName(entity.getGroomname());
    		 result.setEstimatedNumberOfTables(entity.getEstimated_number_of_tables());
    		 result.setDeposit(entity.getDeposit());
    		 result.setIdShift(entity.getId_shift());
    		 result.setLobbyName(entity.getId_lobby().getName());
    		 result.setNumberOfTables(entity.getNumber_of_table());
    		 result.setNote(entity.getNote());
    		 result.setPhone(entity.getPhone());
    		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    		 String strDate = formatter.format(entity.getWedding_date());  
    		 result.setWeddingDate(strDate);
    		 result.setUnitpriceTable(entity.getUnitprice_table());
    	 }
    	 return result;
    }
    public FeastEntity DtoToEntity(FeastDTO dto) throws Exception {
    	FeastEntity result = new FeastEntity();
    	if(dto.getId() != null ) result.setId(dto.getId());
    	result.setGroomname(dto.getGroomName());
    	result.setBridename(dto.getBrideName());
    	result.setDeposit(dto.getDeposit());
    	result.setUnitprice_table(dto.getUnitpriceTable());
    	result.setEstimated_number_of_tables(dto.getEstimatedNumberOfTables());
    	result.setId_shift(dto.getIdShift());
    	result.setNumber_of_table(dto.getNumberOfTables());
    	result.setPhone(dto.getPhone());
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    	Date  date = formatter.parse(dto.getWeddingDate());
    	System.out.println(dto.getWeddingDate());
        System.out.println(date.toString());
    	result.setWedding_date(date);
    	result.setNote(dto.getNote());
    	
    	
    	return result;
    }
}

