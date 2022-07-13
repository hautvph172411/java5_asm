package com.lab.crud.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.lab.crud.entities.Lamp;
import com.lab.crud.entities.LampBrand;
import com.lab.crud.entities.LampOrigin;
import com.lab.crud.repositories.ILampRepository;
@Service
public class LampService {
	@Autowired
	public ILampRepository repository;
	public Page<Lamp> finAll(int page) {
		return repository.findAll(PageRequest.of(page, 5,Sort.by("id").descending()));
	}
	
	public Lamp add(Lamp l) {
		l = defaultLamp(l);
		return repository.save(l);
	}

	public Lamp findById(String pk) {
		Optional<Lamp> l = repository.findById(Integer.parseInt(pk));
		if (l.isPresent()) {
			return l.get();
		} else {
			return null;
		}
	}
	
	public Lamp update(String pk, Lamp l) {
		Optional<Lamp> Lamp = repository.findById(Integer.parseInt(pk));
		if (Lamp.isPresent()) {
			Lamp myLamp = Lamp.get();
			myLamp.setName(l.getName() == null ? myLamp.getName() : l.getName());
			myLamp.setImg(l.getImg()==null ? myLamp.getImg() : l.getImg());
			myLamp.setOrigin(l.getOrigin() ==null? myLamp.getOrigin() : l.getOrigin());
			myLamp.setColor(l.getColor()==null? myLamp.getColor():l.getColor());
			myLamp.setPrice(l.getPrice()==null? myLamp.getPrice():l.getPrice());
			myLamp.setQuantity(l.getQuantity()==null? myLamp.getQuantity():l.getQuantity());
			myLamp.setBrand(l.getBrand()==null? myLamp.getBrand():l.getBrand());
			return repository.save(myLamp);
		} else
			return null;

	}
	
	public Lamp delete(String pk){
		Optional<Lamp> l = repository.findById(Integer.parseInt(pk));
		if (l.isPresent()) {
			repository.deleteById(Integer.parseInt(pk));
			return l.get();
		} else {
			return null;
		}
	}
	
	public List<Integer> delete(List<Integer> list){
		if(list!=null) {
			List<Lamp> listLamp =repository.findAllById(list);
			repository.deleteAll(listLamp);
			return list;
		}else return null;
	}

	public Lamp defaultLamp(Lamp l) {
		if (l.getName() == null)
			l.setName("No name");
		if (l.getCreatedDate() == null)
			l.setCreatedDate();;
		if (l.getOrigin() == null)
			l.setOrigin(LampOrigin.VietNam);
		if(l.getImg()==null) 
		l.setImg(null);
		if(l.getBrand()==null) l.setBrand(LampBrand.RạngĐông);
		if(l.getColor()==null) l.setColor("Red");
		if(l.getQuantity()==null) l.setQuantity(1);
		if(l.getPrice()==null) l.setPrice(BigDecimal.ZERO);
		return l;
	}
	public Page<Lamp> getOrigin(LampOrigin origin,int page){
		Pageable pageable = PageRequest.of(page, 5,Sort.by("id").descending());
		return repository.findByOrigin(origin,pageable);
	}
	public List<Lamp> getName(String name){
		return repository.findByNameLike("%"+name+"%");
	}
	public Lamp saveLamp(Lamp lamp) {
		return repository.save(lamp);
	}

}
