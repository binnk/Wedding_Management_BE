package home.javaweb.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.javaweb.bill.entity.Bill;
import home.javaweb.bill.entity.Fine;
import home.javaweb.bill.service.IBillService;
import home.javaweb.converter.FeastConverter;
import home.javaweb.dto.ExistedFeastDTO;
import home.javaweb.dto.FeastDTO;
import home.javaweb.entity.FeastEntity;
import home.javaweb.entity.LobbyEntity;
import home.javaweb.regime.dto.FeastRegimeDTO;
import home.javaweb.regime.entity.FeastRegime;
import home.javaweb.regime.entity.Regime;
import home.javaweb.regime.repository.FeastRegimeRepository;
import home.javaweb.regime.service.RegimeService;
import home.javaweb.repository.FeastRepository;
import home.javaweb.repository.LobbyRepository;
import home.javaweb.repository.ShiftRepository;
import home.javaweb.service.IFeastService;
import home.javaweb.service.IFeastServiceService;
import home.javaweb.service.IFeastTableService;

@Service("feastService")
public class FeastService implements IFeastService {
	@Autowired
	private FeastRepository feastRepo;
	@Autowired
	private LobbyRepository lobbyRepo;
	@Autowired
	private ShiftRepository shiftRepo;
	@Autowired
	private IBillService billService;
	@Autowired
	private IFeastServiceService feastSService;
	@Autowired
	private IFeastTableService feastTableService;
	@Autowired
	private FeastRegimeRepository feastRegimeRepo;
	@Autowired
	private RegimeService regimeService;

	@Override
	public List<FeastDTO> findAll() {
		// TODO Auto-generated method stub
		List<FeastDTO> listDTO = new LinkedList<FeastDTO>();

		List<FeastEntity> listsEntity = feastRepo.findAll();
		for (FeastEntity item : listsEntity) {
			System.out.println(item.getshift());
			listDTO.add(FeastConverter.getIntance().EntityToDto(item));
		}
		return listDTO;
	}

	@Override
	public FeastDTO save(FeastDTO feast) {
		FeastEntity result = null;
		FeastEntity entity = null;
		try {

				entity = FeastConverter.getIntance().DtoToEntity(feast);
				if (lobbyRepo.findById(feast.getLobbyId()) != null) {
					entity.setId_lobby(lobbyRepo.findById(feast.getLobbyId()).get());
					if (shiftRepo.findById(feast.getIdShift()) != null) {
						entity.setshift(shiftRepo.findById(feast.getIdShift()).get());
						result = feastRepo.save(entity);
						
						// Auto add Bill when add Feast
						Bill bill = new Bill();
						bill.setFeast(result);			
						billService.save(bill);
						
						return FeastConverter.getIntance().EntityToDto(result);
					}
				}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public FeastDTO update(FeastDTO feast) {
		FeastEntity result = null;
		FeastEntity entity = null;
		try {
			if (!feast.IsAnyNullOrEmty() && feast.getId() != null) {
				entity = FeastConverter.getIntance().DtoToEntity(feast);
				if (lobbyRepo.findById(feast.getLobbyId()) != null) {
					entity.setId_lobby(lobbyRepo.findById(feast.getLobbyId()).get());
					if (shiftRepo.findById(feast.getIdShift()) != null) {
						entity.setshift(shiftRepo.findById(feast.getIdShift()).get());
						if (feastRepo.findById(feast.getId()) != null)
							result = feastRepo.save(entity);
						return FeastConverter.getIntance().EntityToDto(result);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public void delete(Long id) {
	//	 delete feast_id in feast_service
		feastSService.deleteByFeast(id);
		feastTableService.deleteByFeast(id);
		
		feastRepo.deleteById(id);
	}

	@Override
	public FeastEntity findById(Long id) {
		FeastEntity result = feastRepo.findById(id).get();
		return result;
	}

	@Override
	public void deleteById(Long id) {
		// delete all table has feast
		feastSService.deleteByFeast(id);
		feastTableService.deleteByFeast(id);
		billService.deleteByFeast(id);
		
		feastRepo.deleteById(id);
		
	}

	@Override
	public Boolean checkExist(ExistedFeastDTO feast) {	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	LocalDate dateOgnz = LocalDate.parse(feast.getDateOfOrganization(), dtf);
		int count = feastRepo.countByShift_IdAndLobby_IdAndDateOfOrganization(feast.getShiftId(), feast.getLobbyId(), dateOgnz);
		
		if (count >=1) return true;
		
		return false;
	}


}