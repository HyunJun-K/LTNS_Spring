package com.ltns.rest_area.domain.restarea;

import com.ltns.rest_area.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GasStationDTO implements DTO {
	private int gs_code;
	private int ra_code;	//휴게소 코드(외래키)
	private String ga_company;
	private String ga_diesel;
	private String ga_gasoline;
	private String ga_lpg;
}
