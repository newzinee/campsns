package com.campfour;

import com.campfour.domain.Address;
import com.campfour.domain.Camp;
import com.campfour.domain.Location;
import com.campfour.repository.CampRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(properties = {Application.APPLICATION_LOCATIONS}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
class ApplicationTests {

	@Autowired
	CampRepository campRepository;

	@Test
	@Transactional
//	@Rollback(false)
	void initCampSave() throws IOException {


		File file = new File("/Users/yj/Downloads/camp_data-20200715.xls");
//		String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3
//
//		if (!extension.equals("xlsx") && !extension.equals("xls")) {
//			throw new IOException("엑셀파일만 업로드 해주세요.");
//		}

		InputStream s = new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook(s);
//
//		if (extension.equals("xlsx")) {
//			workbook = new XSSFWorkbook(file.getInputStream());
//		} else if (extension.equals("xls")) {
//			workbook = new HSSFWorkbook(file.getInputStream());
//		}

		Sheet worksheet = workbook.getSheetAt(0);

//
		List<Camp> camps = new ArrayList<>();
		for (int i = 2; i < worksheet.getPhysicalNumberOfRows(); i++) {

			Row row = worksheet.getRow(i);

			Location location = Location.builder()
					.latitude(getDouble(row.getCell(9).getStringCellValue()))
					.longitude(getDouble(row.getCell(10).getStringCellValue()))
					.build();

			Address address = Address.builder()
					.roadAddr(row.getCell(11).getStringCellValue())
					.jibunAddr(row.getCell(12).getStringCellValue())
					.build();

			String str = row.getCell(39).getStringCellValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate baseDate = LocalDate.parse(str, formatter);

			Camp camp  = Camp.builder()
					.name(row.getCell(7).getStringCellValue())
					.campType(row.getCell(8).getStringCellValue())
					.location(location)
					.address(address)
					.phone(row.getCell(13).getStringCellValue())
					.spotNumber(getInteger(row.getCell(14).getStringCellValue()))
					.siteSize(getDouble(row.getCell(15).getStringCellValue()))
					.buildSize(getDouble(row.getCell(16).getStringCellValue()))
					.capacity(getInteger(row.getCell(30).getStringCellValue()))
					.parkingCapacity(getInteger(row.getCell(31).getStringCellValue()))
					.convenienceOptionStr(row.getCell(32).getStringCellValue())
					.safetyOptionStr(row.getCell(33).getStringCellValue())
					.extraOptionStr(row.getCell(34).getStringCellValue())
					.useTime(row.getCell(35).getStringCellValue())
					.charge(row.getCell(36).getStringCellValue())
					.managingAgencyPhone(row.getCell(37).getStringCellValue())
					.managingAgencyName(row.getCell(38).getStringCellValue())
					.baseDate(baseDate)
					.agencyCode(row.getCell(40).getStringCellValue())
					.agencyName(row.getCell(41).getStringCellValue())
					.build();

			camps.add(camp);
		}

		campRepository.saveAll(camps);

	}

	Double getDouble(String s) throws NumberFormatException {
		if(StringUtils.isEmpty(s)) {
			return 0.0;
		}
		try {
			return Double.parseDouble(s);
		} catch (NumberFormatException e) {
			System.out.println(s + " : e = " + e);
//			e.printStackTrace();
			return 0.0;
		}
	}

	Integer getInteger(String s) throws NumberFormatException {
		if(StringUtils.isEmpty(s)) {
			return 0;
		}
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println(s+" : e = " + e);
//			e.printStackTrace();
			return 0;
		}
	}


}