package tacos.web.api;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import tacos.Ingredient;
import tacos.Taco;

@Getter
@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource extends RepresentationModel { // link 객체 리스트와 관리 메소드 상속

	private static final IngredientResourceAssembler ingredientAssembler = new IngredientResourceAssembler();
	
	private final String name;
	private final Date createdAt;
	private final List<IngredientResource> ingredients;
	
	public TacoResource(Taco taco) {
		this.name = taco.getName();
		this.createdAt = taco.getCreatedAt();
		this.ingredients = (List<IngredientResource>) ingredientAssembler.toCollectionModel(taco.getIngredients());
	}
}