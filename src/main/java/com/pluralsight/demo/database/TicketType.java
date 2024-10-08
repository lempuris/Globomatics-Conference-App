package com.pluralsight.demo.database;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ticket_types")
public class TicketType {

    @Id
    @Column(name = "ticket_type_code", unique = true, nullable = false, length = 1)
    private String code;

    @Column(name = "ticket_type_name", nullable = false, length = 30)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "includes_workshop", nullable = false)
    private boolean includesWorkshop;

    public TicketType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIncludesWorkshop() {
        return includesWorkshop;
    }

    public void setIncludesWorkshop(boolean includesWorkshop) {
        this.includesWorkshop = includesWorkshop;
    }

    @Override
    public String toString() {
        return code + " " + name;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (includesWorkshop ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketType other = (TicketType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (includesWorkshop != other.includesWorkshop)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

   
}
