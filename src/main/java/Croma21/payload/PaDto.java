package Croma21.payload;

import lombok.Data;

import java.util.List;
@Data
public class PaDto<P> {

    private List<PatientDto>dto;
    private int pageNo;
    private int pageSize;
    private  int totalPage;
}
