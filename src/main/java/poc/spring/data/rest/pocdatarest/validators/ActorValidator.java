package poc.spring.data.rest.pocdatarest.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import poc.spring.data.rest.pocdatarest.entities.Actor;

@Component("beforeCreateActorValidator")
public class ActorValidator implements Validator {

	@Override
	public boolean supports(Class<?> claz) {
		return Actor.class.equals(claz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Actor actor = (Actor)obj;
		if(null == actor.getFirstName() || "nombreInvalido".equalsIgnoreCase(actor.getFirstName())){
			errors.rejectValue("firstName", "invalid");
		}
		
	}

	
}
