package com.mx.Jobs.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data

public class Jobs {
	@Id
	private Long idJobTitle;
	private String jobTitle;

}
