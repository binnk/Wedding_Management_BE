package home.javaweb.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    		 result.setDeposit(entity.getDeposit());
    		 result.setIdShift(entity.getshift().getId());
    		 result.setNameShift(entity.getshift().getName());
    		 result.setLobbyId(entity.getId_lobby().getId());
    		 result.setLobbyName(entity.getId_lobby().getName());
    		 result.setNote(entity.getNote());
    		 result.setPhone(entity.getPhone());
    		 result.setRegimeRefund(entity.getRegimeRefund());
    		 result.setWeddingRefund(entity.getWeddingRefund());
    		 result.setReasonRefund(entity.getReasonRefund());
    		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    		 String strDate = formatter.format(entity.getWedding_date());  
    		 result.setWeddingDate(strDate);
    		 
    		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    		 String dateOgnz = entity.getDateOfOrganization().format(dtf);
    		 result.setDateOfOrganization(dateOgnz);
    	 }
    	 return result;
    }
    public FeastEntity DtoToEntity(FeastDTO dto) throws Exception {
    	FeastEntity result = new FeastEntity();
    	if(dto.getId() != null ) result.setId(dto.getId());
    	result.setGroomname(dto.getGroomName());
    	result.setBridename(dto.getBrideName());
    	result.setDeposit(dto.getDeposit());
    	result.setPhone(dto.getPhone());
	   	result.setRegimeRefund(dto.getRegimeRefund());
	   	result.setWeddingRefund(dto.getWeddingRefund());
	    result.setReasonRefund(dto.getReasonRefund());;
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    	Date  date = formatter.parse(dto.getWeddingDate());
    	result.setWedding_date(date);
    	result.setNote(dto.getNote());
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	LocalDate dateOgnz = LocalDate.parse(dto.getDateOfOrganization(), dtf);
    	result.setDateOfOrganization(dateOgnz);
    	
    	
    	return result;
    }
}
