package mentoring.application.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode() {
        return new HashCodeBuilder(17, 31).
            append(name).
            toHashCode();
    }

    public boolean equals(Object obj) {
       if (!(obj instanceof Person))
            return false;
        if (obj == this)
            return true;

        Person rhs = (Person) obj;
        return new EqualsBuilder().
            append(name, rhs.name).
            isEquals();
    }
	
}
