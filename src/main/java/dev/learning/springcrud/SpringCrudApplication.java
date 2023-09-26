package dev.learning.springcrud;

import dev.learning.springcrud.dao.DAO;
import dev.learning.springcrud.model.Faction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringCrudApplication {

	private static DAO<Faction> dao;

	public SpringCrudApplication(DAO<Faction> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);

		System.out.println("\n Create Faction: \n");
		Faction deathguard = new Faction("Deathguard",	"The Death Guard is a traitor Space Marine Legion dedicated to the Chaos God Nurgle. They are known for their resilience and their vile plagues.", "Mortarion, Daemon Primarch of Nurgle");
		dao.create(deathguard);

		System.out.println("\n One Course \n");
		Optional<Faction> faction = dao.get(1);
		System.out.println(faction.get());

		deathguard.setDescription("testing");
		dao.update(deathguard, deathguard.getFactionId());

		dao.delete(2);

		System.out.println("\n All Factions: \n");
		List<Faction> factions = dao.list();
		factions.forEach(System.out::println);

	}

}
