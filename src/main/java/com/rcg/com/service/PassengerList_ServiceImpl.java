package com.rcg.com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.dialect.identity.GetGeneratedKeysDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Guardian;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dto.PassengerListDto;
import com.rcg.com.dto.PassengerListWrapper;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.GuardianRepository;
import com.rcg.com.repository.YoungGustRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class PassengerList_ServiceImpl implements PassengerList_Service 
{
	@Autowired
	private GuardianRepository gr;
	
	@Autowired
	private YoungGustRepository yr;
	
	  

	//Save Passenger List into Guardian and Youngest tables
	@Override
	public String savePassenger(PassengerListWrapper p) throws RitzkidsException
	{

		if(p.getPassengerWrapper()!=null)
		{
			List<PassengerListDto> pl=p.getPassengerWrapper();

			  pl.forEach(a-> 
			  { //Check if Passenger is a adult type 
				  if(String.valueOf(a.getPassengertype()).equals("A"))
				  {
					  Guardian g=guardianMapper(a);
					  //Check Whether Guardian Existing or not
					  if(!gr.getGuardianByfolioid(g.getFolioid()).isPresent())
					  {
						  //getting all kid already registered on the given booking number
						  List<YoungGust> ygl=yr.getYoungGustBybookingid(g.getBookingid());
						  //if Kid found in same booking number
						  if(ygl.size()>0)
						  {
							  for(YoungGust young:ygl)
							  {
								Set<YoungGust> youngGustSet=new HashSet<YoungGust>();
								youngGustSet.add(young); 
								g.setYoung_gust(youngGustSet);
							  }
						  }
						  
						  gr.save(g);

					  }
				  }
				  else
				  {
					    YoungGust y=youngGustMapper(a);
					    //check kid already existing or not
					    if(!yr.getYoungGustByfolioid(y.getFolioid()).isPresent())
					    {
					    	 yr.save(y);
					    	 System.out.println("Yooungster Registerd");
					    	 
							//getting all guarding have same booking number
					    	 List<Guardian> gl=gr.getGuardianBybookingid(y.getBookingid());
							
					    	 if(gl!=null)
							    {
								 	YoungGust yg=yr.getYoungGustByfolioid(y.getFolioid()).get();
							    	for(Guardian g:gl)
							    	{
							    
							    			if(g.getYoung_gust()!=null)
							    			{
							    				g.getYoung_gust().add(new YoungGust(yg.getYounggust_id())); 
							    				
							    			}
							    			else
							    			{
							    				Set<YoungGust> young_gust=new HashSet<YoungGust>();
							    				young_gust.add(yg);
							    				g.setYoung_gust(young_gust);
							    			}
							    			gr.save(g);
								
							    	}
									
							    }
					    }
					   
				  }
			  });
		}
		else
		{
			throw new RitzkidsException("Passenger list is Empty", RitzConstants.ERROR_CODE); 
		}
		
		  
		 
		
		return "success";
	}
	//get All guardian detail
	@Override
	public List<Guardian> getAllGuardian() throws RitzkidsException 
	{
		List<Guardian> g=new ArrayList<Guardian>();
		gr.findAll().forEach(g::add);
		return g;
	}
	
	//geting guardian detail
	@Override
	public Guardian getGuardian(int gid) throws RitzkidsException 
	{
		Optional<Guardian>  guardian=gr.findById(gid);
		
		if(!guardian.isPresent())
		{
			throw new RitzkidsException("No guardian were found in this ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			return guardian.get();
		}
		 
	}

	
	private Guardian guardianMapper(PassengerListDto pdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(pdto,Guardian.class);
	}
	
	private YoungGust youngGustMapper(PassengerListDto pdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(pdto,YoungGust.class);
	}
	
}
