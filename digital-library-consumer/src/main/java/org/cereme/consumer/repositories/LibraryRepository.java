package org.cereme.consumer.repositories;

import org.cereme.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

	//Library findByWorks(Work work);
	//Library findByLibraryName(String libraryname);
	Library findByCity(String city);  

}
