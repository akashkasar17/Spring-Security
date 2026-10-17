package com.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);		
	}
//http://localhost:8080/swagger-ui/index.html
}

//
//@Override
//public List<EmployeeDto> getAllEmployees() {
//	List<EmployeeDto> copyProp = null;
//	List<Employee> listOfEmployees = employeeRepository.findAll();
//	copyProp = copyPropUsingModelMapper(listOfEmployees);
////	copyProp = copyPropUsingBeanUtils(listOfEmployees);
//	return copyProp;
//}
//
//@Override
//public List<EmployeeDto> copyPropUsingAnnotation(){
//	List<EmployeeDto> copyProp = employeeRepository.findAllUsersProjected();
//	return copyProp;
//}
//
//public List<EmployeeDto> copyPropUsingModelMapper(List<Employee> listOfEmployees){
//	return listOfEmployees.stream()
//            .map(emps -> modelMapper.map(emps, EmployeeDto.class))
//            .collect(Collectors.toList());
//}
//
//public List<EmployeeDto> copyPropUsingBeanUtils(List<Employee> listOfEmployees){
//	List<EmployeeDto> dtoList = new ArrayList<>();
//
//    for (Employee emp : listOfEmployees) {
//        EmployeeDto dto = new EmployeeDto();
//        BeanUtils.copyProperties(emp, dto);
//        dtoList.add(dto);
//    }
//	return dtoList;
//}