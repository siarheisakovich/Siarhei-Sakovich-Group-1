package mentoring.application.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Currency {

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
       if (!(obj instanceof Currency))
            return false;
        if (obj == this)
            return true;
        Currency rhs = (Currency) obj;
        return new EqualsBuilder().
            append(name, rhs.name).
            isEquals();
    }
	
}
