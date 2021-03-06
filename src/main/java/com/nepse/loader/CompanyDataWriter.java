package com.nepse.loader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.nepse.dao.ICompanyRepository;
import com.nepse.dao.IGenericRepository;
import com.nepse.domain.Company;
import com.nepse.domain.CompanyData;
import com.nepse.exception.CompanyDataNotFound;


public class CompanyDataWriter implements ItemWriter<CompanyDataForm> {
	
	@Autowired
	private final IGenericRepository genericRepository = null;
	
	@Autowired
	private final ICompanyRepository companyRepository = null;

//	public void write(final List<CompanyDataForm> entities) throws Exception {
//		genericRepository.findById(objectClazz, key)
//		for (CompanyDataForm entity : entities) {
//			genericRepository.save(entity);
//		}
//	}
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void write(List<? extends CompanyDataForm> items) throws Exception {
		for (CompanyDataForm entity : items) {
			Company company = companyRepository.getCompanyBySymbol(entity.getCompanySymbol());
			
			String amount = entity.getAmount();
			String closingPrice = entity.getClosingPrice();
			String date = entity.getDate();
			String maxPrice = entity.getMaxPrice();
			String minPrice = entity.getMinPrice();
			String noOfTransaction = entity.getNoOfTransaction();
			String totalShares = entity.getTotalShares();
			
			CompanyData companyData = new CompanyData(noOfTransaction, totalShares, amount, maxPrice, minPrice, closingPrice, dateFormat.parse(date));
			
			if(company != null) {
				companyData.setCompany(company);
				genericRepository.save(companyData);
			} else {
				throw new CompanyDataNotFound("Company data not found for : " + entity.getCompanySymbol());
			}
			
		}
		
	}

}
