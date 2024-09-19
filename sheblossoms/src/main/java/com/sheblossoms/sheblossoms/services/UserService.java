package com.sheblossoms.sheblossoms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.User;
import com.sheblossoms.sheblossoms.repository.UserRepository;



@Service
public class UserService {

		//Inyección de dependencias 
		@Autowired
		private UserRepository usersRepository;
		
		//GET Obtener lista de users
		public List<User> findAllUsers(){
			return usersRepository.findAll();
		}
		//GET Single Obtener un user (Id)
		public Optional<User> findUserById(Long id){
			return usersRepository.findById(id);
		}
		
		//POST
		public User saveUser(User user) {
			return usersRepository.save(user);
		}
		
		//PUT Actualizar una entidad existente 
		public User updateUser(Long id, User updateUser) {
			
			//Verificar si el autor existe 
			Optional<User> existUser = usersRepository.findById(id);
			
			if (existUser.isPresent()) {
				User existingUser = existUser.get();
			//Actualizar info 
			existingUser.setName(updateUser.getName());
	        //existing
	        
	        return usersRepository.save(existingUser);
			} else { 
				//Manejar en caso que no existe 
				throw new RuntimeException("User not found with id: " + id);
			}
		}
		
		//DELETE 
		public void deleteUser(Long id) {
			usersRepository.deleteById(id);
		}
	}


