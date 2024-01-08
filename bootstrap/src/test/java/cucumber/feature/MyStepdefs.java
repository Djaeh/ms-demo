package cucumber.feature;

import com.example.karatemsdemo.rest.model.Category;
import com.example.karatemsdemo.rest.model.Pet;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.client.WebClient;
import utils.ApplicationStarter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@Log4j2
public class MyStepdefs {

    private Pet petRequest;
    private Pet petResult;

    @When("Arthur create this pet to the store")
    public void addingThisPet() {
        var client = WebClient.create("http://localhost:" + ApplicationStarter.FIRST_AVAILABLE_TCP_PORT);
        petResult = client.post()
                .uri("/pet")
                .bodyValue(petRequest)
                .retrieve()
                .bodyToMono(Pet.class)
                .block();
    }

    @Given("Arthur has a new pet")
    public void theFollowingPet(DataTable petTable) {
        var petMap = petTable.asMaps().get(0);
        petRequest = new Pet();
        petRequest.setId(Long.valueOf(petMap.get("id")));
        petRequest.setName(petMap.get("name"));
        petRequest.setPhotoUrls(Arrays.stream(petMap.get("photoUrls").split(",")).toList());
        petRequest.setStatus(Pet.StatusEnum.valueOf(petMap.get("status").toUpperCase()));
        // category
        var category = new Category();
        category.setId(Long.valueOf(petMap.get("category.id")));
        category.setName(petMap.get("category.name"));
        petRequest.setCategory(category);
    }

    @Then("the pet is added and is same as")
    public void thePetIsAddedAndIsSameAs(DataTable petTable) {
        var expected = DataTable.create(List.of(
                List.of("id", "name", "category.id", "category.name", "photoUrls", "tags", "status"),
                Stream.of(String.valueOf(petResult.getId()), petResult.getName(), String.valueOf(petRequest.getCategory().getId()), petResult.getCategory().getName(), String.join(",", petResult.getPhotoUrls()), null, petResult.getStatus().getValue()).toList()
        ));
        assertEquals(expected, petTable);
    }
}
