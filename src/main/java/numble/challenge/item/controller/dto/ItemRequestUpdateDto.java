package numble.challenge.item.controller.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ItemRequestUpdateDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    @Min(0)
    private Integer quantity;
}
