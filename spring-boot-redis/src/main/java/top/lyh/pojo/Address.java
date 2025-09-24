package top.lyh.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private String city;
    private String province;
}
