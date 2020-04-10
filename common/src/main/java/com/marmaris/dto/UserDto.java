package com.marmaris.dto;

import com.marmaris.enums.Role;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class UserDto {

    private final Long id;
    private final Integer version;
    private final String name;
    private final Role role;

    @GeneratePojoBuilder
    UserDto(Long id, Integer version, String name, Role role) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto other = (UserDto) o;

        return new EqualsBuilder()
                .append(id, other.id)
                .append(version, other.version)
                .append(name, other.name)
                .append(role, other.role)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(version)
                .append(name)
                .append(role)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("version", version)
                .append("name", name)
                .append("role", role)
                .toString();
    }

}
