package org.lxy.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePageRequest {
    protected int pageNo;
    protected int pageSize;
}
